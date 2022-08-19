package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("empService")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDAO dao;

	@Override
	public String fetchEmpByName(int no) {
		return dao.getEmpByNo(no);

	}

	@Override
	public List<Employee> fetchEmpByDesgs(String desg1, String desg2, String desg3) {
		return dao.getEmpByDesgs(desg1, desg2, desg3);
	}

	@Override
	public int updateEmpSalaryByDesg(int bonus, String desg) {
		return dao.updateEmpByDesg(bonus,desg);
	}
}
