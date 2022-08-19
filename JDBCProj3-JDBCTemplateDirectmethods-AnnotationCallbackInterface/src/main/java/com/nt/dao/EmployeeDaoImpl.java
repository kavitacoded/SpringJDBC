package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO")
public class EmployeeDaoImpl implements IEmployeeDao {
private static final String GET_EMP_BYNO="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	
	@Autowired
	private JdbcTemplate jt;

	@Override
	public Employee getEmpByDetails(int eno) {
	Employee emp=	jt.queryForObject(GET_EMP_BYNO, new EmployeeMapper(), eno);
		return emp;
	}
	
	//inner classes
	private class EmployeeMapper implements RowMapper<Employee>{

		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			//copy the records of RS to Employee obj
			Employee emp=new Employee();
			emp.setEno(rs.getInt(1));
			emp.setEname(rs.getString(2));
			emp.setJob(rs.getString(2));
			emp.setSal(rs.getFloat(4));
			emp.setDeptno(rs.getInt(5));
			return emp;
		}//method
	}//inner class

}//class
