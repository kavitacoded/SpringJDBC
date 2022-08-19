package com.nt.dao;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeDAO {

	public String getEmpByNo(int no);
	public List<Employee> getEmpByDesgs(String desg1,String desg2,String desg3);
	public int updateEmpByDesg(int bonus,String desg);
}
