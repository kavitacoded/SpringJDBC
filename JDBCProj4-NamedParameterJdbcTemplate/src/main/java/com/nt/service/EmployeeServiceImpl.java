package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("empService")
public class EmployeeServiceImpl implements IEMployeeService {

	@Autowired
	private IEmployeeDAO dao;

	@Override
	public String getEmpById(int eid) {

		return dao.getEmpById(eid);
	}

	@Override
	public List<Employee> getEmpByDesg(String desg1, String desg2, String desg3) {
		return dao.getEmpByDesg(desg1, desg2, desg3);
	}

	@Override
	public String registerEmployee(Employee emp) {
		//use dao
		int count=dao.insertEmployee(emp);
		return count==0?"Employee not registered":"Employee Registered";
	}
}
