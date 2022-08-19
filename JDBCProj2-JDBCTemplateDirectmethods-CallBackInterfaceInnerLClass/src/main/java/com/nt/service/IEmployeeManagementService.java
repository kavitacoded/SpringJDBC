package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeManagementService {

	public int fetchEmpCounts();
	public Employee fetchEmpById(int eno);
	public List<Employee> fetchEmByDesg(String desg1,String desg2,String desg3);
}
