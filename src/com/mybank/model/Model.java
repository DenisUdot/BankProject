package com.mybank.model;

import com.mybank.domain.Bank;
import com.mybank.domain.Customer;
import com.mybank.domain.OverdraftException;

public class Model {
	 public Customer customer;
	 private int accountNumber=0; 
	 

	 public Boolean getCustomer(int i){
	
		 if(Bank.getCustomer(i)==null){
			 return false;
		
		 }else{
			 this.customer =Bank.getCustomer(i);
			 return true;
		 }
	 }
public String getAccountBalance(){
// ”  À»≈Õ“¿ ÃŒ∆≈“ ¡€“‹ Õ≈— ŒÀ‹ Œ ¿  ¿”Õ“Œ¬
	
	return ("Your account balance is: "+customer.getAccount(accountNumber).getBalance());
}
public String newDeposit(double deposit){
	customer.getAccount(accountNumber).deposit(deposit);
	return ("Your deposit of "+deposit+" was successful.");
}
public String  withdrawal(double withdrawal){
	try{
		customer.getAccount(accountNumber).withdraw(withdrawal);
		return ("Your withdrawal of "+withdrawal+" was successful");
	}catch(OverdraftException oe){
		return ("Your withdrawal of "+withdrawal+" was unsuccessful");
	}
	
}
}

