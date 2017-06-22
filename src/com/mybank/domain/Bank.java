package com.mybank.domain;

import java.util.ArrayList;
import java.util.List;

public class Bank {
private static  List<Customer> customers;

private Bank(){
	}
	static{
		customers=new ArrayList<Customer>(10);
	}
	public static void addCustomer(String f,String l){
		customers.add(new Customer(f,l));
	}
	public static int getNumOfCustomers(){
		return customers.size();
	}
	public static Customer getCustomer(int index){
		if(index<customers.size()){
			return customers.get(index);
		}else{
			return null;
		}
	}
}