package com.nt;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.IBankService;

public class LocalTest
{
    public static void main( String[] args )
    {
       //create IOC Container
    	ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
    	//get service class obejct
    	IBankService proxy=ctx.getBean("bankService",IBankService.class);
    	//invoke method
    	try {
			System.out.println(proxy.transferMoney(115, 101,10000.0));
		} catch (Exception e) {
			e.printStackTrace();
		}
    	ctx.close();
    }
}
