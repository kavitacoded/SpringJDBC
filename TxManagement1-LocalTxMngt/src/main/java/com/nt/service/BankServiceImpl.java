package com.nt.service;




import com.nt.dao.IBankDAO;

public class BankServiceImpl implements IBankService {

	private IBankDAO dao;
	
	public BankServiceImpl(IBankDAO dao) {
		this.dao=dao;
	}
	
	@Override
	public String transferMoney(int scrno, int descno, double amount) throws IllegalAccessException {
	int count1=	dao.deposite(descno, amount);
	int count2=	dao.withdraw(scrno, amount);
	
	try {
		Thread.sleep(220000);
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	
	if(count1==0 | count2==0)
		//throw new RuntimeException("Tx is rolled back -->Money not transfer ");
		throw new IllegalAccessException("Tx rolled back -->Money is not transfered");
		else
		return "Money trasper from a/c"+scrno+" to"+descno+" amount is "+amount;
	}

}
