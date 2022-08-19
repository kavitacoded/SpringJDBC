package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {

	private static final String GET_EMP_BY_NO = "SELECT ENAME FROM EMP WHERE EMPNO=?";
	private static final String GET_EMP_BY_DESG = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?)";
	private static final String UPDATE_EMP_SAL_BY_DESG="UPDATE EMP SET SAL=SAL+? WHERE JOB=?";
	private DataSource ds;
	private EmployeeSelector1 selector1;
	private EmployeeSelector2 selector2;
	private EmployeeUpdator updator;

	@Autowired
	public EmployeeDAOImpl(DataSource ds) {
		System.out.println("EmployeeDAOImpl.EmployeeDAOImpl() o-param constructor");
		this.ds = ds;
		selector1 = new EmployeeSelector1(ds, GET_EMP_BY_NO);
		selector2 = new EmployeeSelector2(ds, GET_EMP_BY_DESG);
		updator=new EmployeeUpdator(ds, UPDATE_EMP_SAL_BY_DESG);
	}

	@Override
	public String getEmpByNo(int no) {
		System.out.println("EmployeeDAOImpl.getEmpByNo()");
		String name = selector1.findObject(no);
		return name;
	}

	@Override
	public List<Employee> getEmpByDesgs(String desg1, String desg2, String desg3) {
		List<Employee> list = selector2.execute(desg1, desg2, desg3);
		return list;
	}
	@Override
	public int updateEmpByDesg(int bonus,String desg) {
	int count=updator.update(bonus,desg);
		return count;
	}
	
	// inner classes as subclasses of MappingSqlQuery to SqlUpdate class
	private static class EmployeeSelector1 extends MappingSqlQuery<String> {

		public EmployeeSelector1(DataSource ds, String query) {
			super(ds, query);
			System.out.println("EmployeeDAOImpl.EmployeeSelector1.EmployeeSelector1() 2 -param constructor");
			super.declareParameter(new SqlParameter(Types.INTEGER));
			super.compile();// calls super class method
		}

		@Override
		protected String mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("EmployeeDAOImpl.EmployeeSelector1.mapRow()");
			String name = rs.getString(1);
			return name;
		}
	}// inner class

	private static class EmployeeSelector2 extends MappingSqlQuery<Employee> {

		public EmployeeSelector2(DataSource ds, String query) {
			super(ds, query);
			super.declareParameter(new SqlParameter(Types.VARCHAR));
			super.declareParameter(new SqlParameter(Types.VARCHAR) );
			super.declareParameter(new SqlParameter(Types.VARCHAR) );
			
			System.out.println("EmployeeDAOImpl.EmployeeSelector2.EmployeeSelector2() 2- param constructor");
			super.compile();
		}// selector2

		@Override
		protected Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			// convert Resultset object record into Employee class obj
			Employee emp = new Employee();
			emp.setEmpno(rs.getInt(1));
			emp.setEname(rs.getString(2));
			emp.setJob(rs.getString(3));
			emp.setSal(rs.getFloat(4));
			return emp;
		}

	}// inner class2
    private static class EmployeeUpdator extends SqlUpdate{
    	public EmployeeUpdator(DataSource ds,String query) {
    		super(ds,query);
    		super.declareParameter(new SqlParameter(Types.INTEGER));
    		super.declareParameter(new SqlParameter(Types.VARCHAR));
    		super.compile();
    	}
    	
    }//inner class3

	
	
}// class
