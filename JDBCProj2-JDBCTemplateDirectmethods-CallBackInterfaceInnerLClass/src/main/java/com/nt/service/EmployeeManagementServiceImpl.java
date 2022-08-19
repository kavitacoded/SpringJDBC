package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDao;
import com.nt.model.Employee;

@Service("empService")
public class EmployeeManagementServiceImpl implements IEmployeeManagementService {

	@Autowired
	private IEmployeeDao dao;
	
	public EmployeeManagementServiceImpl(IEmployeeDao dao) {
		this.dao=dao;
	}
	@Override
	public int fetchEmpCounts() {
		int count=dao.getEmpsCount();
		return count;
	}
	@Override
	public Employee fetchEmpById(int eno) {
	Employee emp=	dao.getEmpDetailsById(eno);
		return emp;
	}
	@Override
	public List<Employee> fetchEmByDesg(String desg1, String desg2, String desg3) {
		
		return dao.getEmpDetailsByDesg(desg1, desg2, desg3);
	}
	
}
