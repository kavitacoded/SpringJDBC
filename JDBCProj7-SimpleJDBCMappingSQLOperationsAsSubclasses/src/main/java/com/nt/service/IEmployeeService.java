package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeService {

	public String fetchEmpByName(int no);
	public List<Employee> fetchEmpByDesgs(String desg1,String desg2,String desg3);
	public int updateEmpSalaryByDesg(int  bonus,String desg);

}
