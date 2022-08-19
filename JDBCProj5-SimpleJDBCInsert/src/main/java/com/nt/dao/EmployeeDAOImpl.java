package com.nt.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("EmpDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {

	@Autowired
	private SimpleJdbcInsert sj;

	/*@Override
	public int insert(Employee emp) {
		//set table name
		sj.setTableName("emp");
		//create Map object having col name and values
		Map<String,Object>colmap=Map.of("EMPNO",emp.getEmpno(),
				                                                                  "ENAME",emp.getEname(),
				                                                                  "JOB",emp.getJob(),
				                                                                  "SAL",emp.getSal());
				      int count=sj.execute(colmap);                                                      
				      return count;
	}//method
	*/

	/*	@Override
		public int insert(Employee emp) {
			// set table name
			sj.setTableName("emp");
			// use mapsql parameter source obj having col names and values
			MapSqlParameterSource source = new MapSqlParameterSource();
			source.addValue("EMPNO", emp.getEmpno());
			source.addValue("ENAME", emp.getEname());
			source.addValue("JOB", emp.getJob());
			source.addValue("SAL", emp.getSal());
			int count = sj.execute(source);
			return count;
		}
	*/
	@Override
	public int insert(Employee emp) {
		//set table name
		sj.setTableName("emp");
		//use bean property of sql parameter source obj having model class/bean class object
		BeanPropertySqlParameterSource source=new BeanPropertySqlParameterSource(emp);
		int count=sj.execute(source);
		return count;
	}
}// class
