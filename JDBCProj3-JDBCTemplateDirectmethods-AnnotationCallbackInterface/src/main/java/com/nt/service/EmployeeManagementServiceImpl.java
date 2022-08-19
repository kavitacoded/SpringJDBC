package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDao;
import com.nt.model.Employee;

@Service("empService")
public class EmployeeManagementServiceImpl implements IEmployeeManagementService {

	@Autowired
	private IEmployeeDao dao;
	@Override
	public Employee fetchEmployeeById(int eno) {
	Employee emp=	dao.getEmpByDetails(eno);
		return emp;
	}


}
