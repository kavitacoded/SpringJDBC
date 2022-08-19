package com.nt;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.model.Employee;
import com.nt.service.IEmployeeService;

public class App 
{
    public static void main( String[] args )
    {
     //create IOC Container
    	ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
    //get service class obj
    	IEmployeeService service=ctx.getBean("empService",IEmployeeService.class);
    	//invoke method
    	try {
			Employee emp=new Employee(7565,"Jani","salesman",654.0f);
		String msg=	service.registerEmployee(emp);
		System.out.println(msg );
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		//	System.out.println("Employee Not Registered please Enter Valid Details");
		}//catch
    
    }//method
}//class
