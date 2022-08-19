package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO")
public class EmployeeDaoImpl implements IEmployeeDao {

	private static final String GET_EMPS_COUNTS = "SELECT COUNT(*) FROM EMP";
	private static final String GET_EMPS_EMPNO = "SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	private static final String GET_EMPS_EMPDESG = "SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN(?,?,?)ORDER BY JOB";
	@Autowired
	private JdbcTemplate jt;

	public EmployeeDaoImpl(JdbcTemplate jt) {
		this.jt = jt;

	}

	@Override
	public int getEmpsCount() {
		int count = jt.queryForObject(GET_EMPS_COUNTS, Integer.class);
		return count;
	}

	@Override
	public Employee getEmpDetailsById(int eno) {
		Employee emp = jt.queryForObject(GET_EMPS_EMPNO, // arg1
				new RowMapper<Employee>() {

					@Override
					public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
						// copy the RS Records to Employee object
						Employee emp = new Employee();
						emp.setEno(rs.getInt(1));
						emp.setEname(rs.getString(2));
						emp.setJob(rs.getString(3));
						emp.setSal(rs.getFloat(4));
						emp.setDeptno(rs.getInt(5));
						return emp;
					}
				}, eno);
		return emp;
	}// method

	@Override
	public List<Employee> getEmpDetailsByDesg(String desg1, String desg2, String desg3) {
		List<Employee> empList1 = jt.query(GET_EMPS_EMPDESG, // arg1
				rs -> {
					List<Employee> list = new ArrayList<Employee>();
					while (rs.next()) {
						Employee emp = new Employee();
						emp.setEno(rs.getInt(1));
						emp.setEname(rs.getString(2));
						emp.setJob(rs.getString(3));
						emp.setSal(rs.getFloat(4));
						emp.setDeptno(rs.getInt(5));
						list.add(emp);
					} // while

					return list;
				}, desg1, desg2, desg3);
		return empList1;
	}

}// class
