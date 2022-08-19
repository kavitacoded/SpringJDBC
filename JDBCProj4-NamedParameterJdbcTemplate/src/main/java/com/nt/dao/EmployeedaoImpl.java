package com.nt.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO")
public class EmployeedaoImpl implements IEmployeeDAO {

	private static final String GET_EMP_BY_ID = "SELECT ENAME FROM EMP WHERE EMPNO=:Id";
	private static final String GET_EMP_BY_DESG = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(:desg1,:desg2,:desg3)";
	private static final String INSERT_EMPLOYEE = "INSERT INTO EMP (EMPNO,ENAME,JOB,SAL)VALUES(:empno,:ename,:job,:sal)";
	@Autowired
	private NamedParameterJdbcTemplate npjd;

	@Override
	public String getEmpById(int eno) {
		Map<String, Object> paramsmap = Map.of("Id", eno);
		String name = npjd.queryForObject(GET_EMP_BY_ID, paramsmap, String.class);
		return name;
	}

	@Override
	public List<Employee> getEmpByDesg(String desg1, String desg2, String desg3) {
		// create MapSqlParameterSource class object having named params name and values
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("desg1", desg1);
		source.addValue("desg2", desg2);
		source.addValue("desg3", desg3);

		List<Employee> emplist = npjd.query(GET_EMP_BY_DESG, // arg1
				source, // arg2
				rs -> { // arg3 resultset Extractor
					List<Employee> list = new ArrayList();
					while (rs.next()) {
						Employee e = new Employee();
						e.setEmpno(rs.getInt(1));
						e.setEname(rs.getString(2));
						e.setJob(rs.getString(3));
						e.setSal(rs.getFloat(4));
						list.add(e);
					}
					return list;
				});
		return emplist;
	}// method

	@Override
	public int insertEmployee(Employee emp) {
		BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(emp);
		int count = npjd.update(INSERT_EMPLOYEE, source);
		return count;
	}//method

}// class
