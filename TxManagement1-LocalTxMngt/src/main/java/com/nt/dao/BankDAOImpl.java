package com.nt.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class BankDAOImpl implements IBankDAO {

	private static final String  BankWithdraw="UPDATE  SPRING_TX_BANK SET BALANCE=BALANCE-? WHERE ACCNO=?";
	private static final String BankDeposite="UPDATE SPRING_TX_BANK SET BALANCE=BALANCE+? WHERE ACCNO=?";
	
		private JdbcTemplate temple;
	
		public BankDAOImpl(JdbcTemplate jt) {
			this.temple=jt;
		}
	
	@Override
	public int withdraw(int accno, double amount) {
		int count=temple.update(BankWithdraw,amount,accno);
		return count;
	}

	@Override
	public int deposite(int accno, double amount) {
	int count=	temple.update(BankDeposite,amount,accno);
		return count;
	}

}
