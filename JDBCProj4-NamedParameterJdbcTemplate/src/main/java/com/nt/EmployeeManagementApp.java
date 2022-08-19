package com.nt;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.model.Employee;
import com.nt.service.IEMployeeService;

public class EmployeeManagementApp {
	public static void main(String[] args) {
		// ccreate IOC Cotainer
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// creat eservice class obj
		IEMployeeService service = ctx.getBean("empService", IEMployeeService.class);
		// invoke method
		try {

			System.out.println("Employee Name :: " + service.getEmpById(7839));
		} catch (DataAccessException dae) {
			
			dae.printStackTrace();
		}
		System.out.println();
		try {
			System.out.println("Emp Details whose desg clerk manager salesforce");
			List<Employee>list=service.getEmpByDesg("CLERK", "MANAGER", "SALESMAN");
		list.forEach(emp->{
				System.out.println(emp);
			});
			//System.out.println(list);
			
		} catch (DataAccessException dae) {
			dae.printStackTrace();
			System.err.println("Emp with desg not created");
		}
		System.out.println();
		try {
			Employee emp=new Employee(8085,"RAJA","MANAGER",54430.0f);
		String msg=service.registerEmployee(emp);
		System.out.println(msg);
		} catch (DataAccessException dae) {
			
			dae.printStackTrace();
		}
	}
}
