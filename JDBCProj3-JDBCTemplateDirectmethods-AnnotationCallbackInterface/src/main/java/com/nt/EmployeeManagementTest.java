package com.nt;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.model.Employee;
import com.nt.service.EmployeeManagementServiceImpl;
import com.nt.service.IEmployeeManagementService;

public class EmployeeManagementTest
{
    public static void main( String[] args )
    {
       //create IOC Container
    	ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
    	//get service class object
    	IEmployeeManagementService service=ctx.getBean("empService",IEmployeeManagementService.class);
    	try {
		Employee emp=	service.fetchEmployeeById(7983);
		System.out.println(emp);
		} catch (DataAccessException dae) {
			dae.printStackTrace();
			System.out.println("Employee not registered");
		}
    	
    	//close container
    	ctx.close();
    }//main
}//class
