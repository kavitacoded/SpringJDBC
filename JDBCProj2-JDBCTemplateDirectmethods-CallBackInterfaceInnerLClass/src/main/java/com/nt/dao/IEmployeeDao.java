package com.nt.dao;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeDao {
 public int getEmpsCount();
 public Employee  getEmpDetailsById(int eno);
 public List<Employee> getEmpDetailsByDesg(String desg1,String desg2,String desg3);
}
