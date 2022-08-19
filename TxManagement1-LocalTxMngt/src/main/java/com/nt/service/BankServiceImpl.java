package com.nt.service;


import org.springframework.stereotype.Service;

import com.nt.dao.IBankDAO;

public class BankServiceImpl implements IBankService {

	private IBankDAO dao;
	
	public BankServiceImpl(IBankDAO dao) {
		this.dao=dao;
	}
	@Override
	public String transferMoney(int scrno, int descno, double amount) {
	int count1=	dao.deposite(descno, amount);
	int count2=	dao.withdraw(descno, amount);
	if(count1==0 | count2==0)
		throw new RuntimeException("Tx is rolled back -->Money not transfer ");
		else
		return "Tx commited -->Money Transfered";
	}

}
