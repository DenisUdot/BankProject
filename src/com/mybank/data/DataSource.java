package com.mybank.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.mybank.domain.Bank;
import com.mybank.domain.CheckingAccount;
import com.mybank.domain.SavingsAccount;

public class DataSource {
private File dataFile;

public DataSource(String dataFilePath){
	dataFile=new File(dataFilePath);
}
public void loadData() throws IOException{
	try{
		FileReader f=new FileReader(dataFile);
		BufferedReader b=new BufferedReader(f);
		Scanner input=new Scanner(b);
			String firstName;
			String secondName;
			int numbersOfAccount;
			int numberOfCustomers;
			String AccountTypeCode;
			double inttialBalance;
			double interestRate;		
			double overdraftAmount;
			numberOfCustomers=input.nextInt();
					for(int i=0;i<numberOfCustomers;i++){
					firstName=input.next();
					secondName=input.next();
					Bank.addCustomer(firstName,secondName);
					numbersOfAccount=input.nextInt();
						for(int j=0; j<numbersOfAccount; j++){
							AccountTypeCode=input.next();
							switch(AccountTypeCode){
								case "S":{
									try{
										inttialBalance=input.nextDouble();
										interestRate=input.nextDouble();
										Bank.getCustomer(i).addAccount(new SavingsAccount(inttialBalance,interestRate));
										break;
									}catch(InputMismatchException ime){
										ime.printStackTrace();
									}
								}
								case "C":{
									try{
										inttialBalance=input.nextDouble();
										overdraftAmount=input.nextDouble();
										Bank.getCustomer(i).addAccount(new CheckingAccount(inttialBalance,overdraftAmount));
										break;
									}catch(InputMismatchException ime){
										ime.printStackTrace();
									}
								}
							}
						}
				}
			
			b.close();
	}catch(IOException io){
		io.printStackTrace();
	}
	
}
}