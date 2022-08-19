package com.nt;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.model.Employee;
import com.nt.service.IEmployeeManagementService;

public class EmployeeManagementTest
{
    public static void main( String[] args )
    {
       //create IOC Container
    	ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
    	//get spring bean obj
    	IEmployeeManagementService service=ctx.getBean("empService",IEmployeeManagementService.class);
    	try {
			System.out.println("Emp count :: " +service.fetchEmpCounts());
		}//catch 
    	catch (DataAccessException dae) {
		dae.printStackTrace();
		}//catch
    	System.out.println();
    	try {
		Employee emp=service.fetchEmpById(7788);
		System.out.println(emp);
		}//catch 
    	catch (DataAccessException dae) {
		dae.printStackTrace();
		System.out.println("Record not found//");
		}//catch
    	System.out.println();
    	try {
    	List<Employee>	 emp=service.fetchEmByDesg("CLERK", "MANAGER","SALESMAN");
    		//System.out.println(emp);
    		emp.forEach(System.out::println);
    		}//catch 
        	catch (DataAccessException dae) {
    		dae.printStackTrace();
    		System.out.println("Record not found");
    		}//catch
    	
    	
    	//close container
    	ctx.close();
    }//main
}//class
