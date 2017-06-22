package com.mybank.domain;

public class Account {
protected double balance;
protected Account(double initBalance){
	if(initBalance>0){
		balance=initBalance;
	}else{
		System.out.println("Balance never go below zero");
	}
}
public double getBalance(){
	return balance;
}
public void deposit(double atm){
		balance=balance+atm;
}	
public void withdraw(double atm) throws OverdraftException{
	if(balance>=atm){
	balance=balance-atm;
	}
	else{
		throw new OverdraftException("Insufficient funds",atm-balance);
	}
}
}
