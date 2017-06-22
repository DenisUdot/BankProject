package com.mybank.domain;


public class CheckingAccount extends Account {
	private double overdraftAmount;
	public CheckingAccount(double initBalance,double overdraft){
		super(initBalance);
		overdraftAmount=overdraft;
	}
	public CheckingAccount(double initBalance){
		super(initBalance);
	}
	
	public void withdraw(double atm) throws OverdraftException{
		if(balance<atm){
		double overdraftNeeded=atm-balance;
			if(overdraftAmount<overdraftNeeded){
				throw new OverdraftException("Insufficient funds for overdraft protection",(overdraftNeeded));//may be needed (overdraftNeeded-overdraftAmount)
		
			}else{
				balance=0.0;
				overdraftAmount=overdraftAmount-overdraftNeeded;
			}
		}else{
			balance=balance-atm;
		}
	}
}
