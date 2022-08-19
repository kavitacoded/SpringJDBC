package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEMployeeService {

	public String getEmpById(int eid);
	public List<Employee> getEmpByDesg(String desg1,String desg2,String desg3);
	public String registerEmployee(Employee emp);
	
}
