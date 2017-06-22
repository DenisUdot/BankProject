package com.mybank.domain;

public class SavingsAccount extends Account {
private double interestRate;
public SavingsAccount(double initBalance, double i){
	super(initBalance);
	interestRate=i;	
}
public void accumulateInterest(){
	balance=balance+(balance*(interestRate/12));
}
}
