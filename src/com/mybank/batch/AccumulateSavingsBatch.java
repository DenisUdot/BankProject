package com.mybank.batch;
import com.mybank.domain.*;

public class AccumulateSavingsBatch {
	private Bank bank;
	public void doBatch(){
		for(int ind_cus=0; ind_cus<bank.getNumOfCustomers();ind_cus++){
			Customer customer=Bank.getCustomer(ind_cus);
			for ( int acct_idx = 0;acct_idx < customer.getNumOfAccounts();acct_idx++ ) {
		        Account account = customer.getAccount(acct_idx);
		        if(account instanceof SavingsAccount){
		        	((SavingsAccount) account).accumulateInterest();
		        }
			}
		}
	}
	public void setBank(Bank bank){
		this.bank=bank;
	}
}
