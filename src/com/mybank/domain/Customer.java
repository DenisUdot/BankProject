package com.mybank.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String firstName;
	private String lastName;
	private List <Account> account=new ArrayList <Account>();
	public Customer(String f, String l){
		firstName=f;
		lastName=l;
	}
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public Account getAccount(int num){
		return account.get(num);
	}
	public void addAccount(Account acct){
		account.add(acct);
	}
	public int getNumOfAccounts(){
		return account.size();
	}
}
