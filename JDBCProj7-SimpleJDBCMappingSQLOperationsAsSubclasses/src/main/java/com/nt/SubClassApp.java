package com.nt;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;
import com.nt.service.IEmployeeService;

public class SubClassApp 
{
    public static void main( String[] args )
    {
      ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
      IEmployeeService service=ctx.getBean("empService",IEmployeeService.class);
    //b method
      try {
		System.out.println("" + service.fetchEmpByName(7369));
		System.out.println("" + service.fetchEmpByName(7499));
	} catch (DataAccessException dae) {
		dae.printStackTrace();
	}
      try {
  		System.out.println("CLERK,MANAGER,SALESMAN");
  		List<Employee>list=service.fetchEmpByDesgs("CLERK", "MANAGER", "SALESMAN");
  		list.forEach(emp->{
  			System.out.println(emp);
  		});
  	} catch (DataAccessException dae) {
  		dae.printStackTrace();
  	}
      System.out.println();
      try {
       System.err.println("update ");
    	System.out.println(service.updateEmpSalaryByDesg(4562, "CLERK"));
    	
    	} catch (DataAccessException dae) {
    		dae.printStackTrace();
    	}
     
    //close container
      ctx.close();
    
    }
}
