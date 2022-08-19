package com.nt.dao;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeDAO {

	public String getEmpById(int eno);
	public List<Employee> getEmpByDesg(String desg1,String desg2,String desg3);
	public int insertEmployee(Employee emp);
}
