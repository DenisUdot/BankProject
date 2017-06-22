package com.mybank.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.mybank.fvk.Configuration;
import com.mybank.main.ATMClient;
import com.mybank.model.Model;


public class KeyPadController implements ActionListener {
	
	private Model model;
	StringBuffer firstBuffer = new StringBuffer();
	private int number;
	private double numberDouble;
	boolean pointOn=false;
	boolean makeDeposit;
	boolean makeWithdrawal;
	boolean displayAccountBalance;
	private int i;
	private double x=1;
    // Конструктор
    public KeyPadController(Model m) {
        this.model = m;
       
    }

	
	public void actionPerformed(ActionEvent e) {
		JButton button=(JButton) e.getSource();
		switch(button.getActionCommand()){
		case "0":
			i=0;
			if(pointOn==false){
				number=number*10+i;
			}else{
				numberDouble=numberDouble+(i/(10*x));
				x=x*10;
			}
			break;
		case "1":
			i=1;
			if(pointOn==false){
				number=number*10+i;
			}else{
				numberDouble=numberDouble+(i/(10*x));
				x=x*10;
			}
			break;
		case "2":
			i=2;
			if(pointOn==false){
				number=number*10+i;
			}else{
				numberDouble=numberDouble+(i/(10*x));
				x=x*10;
			}
			break;
		case "3":
			i=3;
			if(pointOn==false){
				number=number*10+i;
			}else{
				numberDouble=numberDouble+(i/(10*x));
				x=x*10;
			}
			break;
		case "4":
			i=4;
			if(pointOn==false){
				number=number*10+i;
			}else{
				numberDouble=numberDouble+(i/(10*x));
				x=x*10;
				
			}
			break;
		case "5":
			i=5;
			if(pointOn==false){
				number=number*10+i;
			}else{
				numberDouble=numberDouble+(i/(10*x));
				x=x*10;
			}
			break;
		case "6":
			i=6;
			if(pointOn==false){
				number=number*10+i;
			}else{
				numberDouble=numberDouble+(i/(10*x));
				x=x*10;
			}
			break;
		case "7":
			i=7;
			if(pointOn==false){
				number=number*10+i;
			}else{
				numberDouble=numberDouble+(i/(10*x));
				x=x*10;
			}
			break;
		case "8":
			i=8;
			if(pointOn==false){
				number=number*10+i;
			}else{
				numberDouble=numberDouble+(i/(10*x));
				x=x*10;
			}
			break;
		case "9":
			i=9;
			if(pointOn==false){
				number=number*10+i;
			}else{
				numberDouble=numberDouble+(i/(10*x));
				x=x*10;
			}
			break;
		case ".":
			numberDouble=(double)number;
			pointOn=true;
			break;
		case "ENTER":
			
				if(model.customer==null){
					if(model.getCustomer((int)number)==true){
						if(pointOn==false){
							Configuration.getInstance(model).getView().output.setText("Welcome "+model.customer.getFirstName()+" "+model.customer.getLastName());
							Configuration.getInstance(model).getView().accountBalance.setEnabled(true);
							Configuration.getInstance(model).getView().deposit.setEnabled(true);
							Configuration.getInstance(model).getView().withdrawal.setEnabled(true);
							Configuration.getInstance(model).getView().keyPad[10].setEnabled(true);
							
						}
					}else{
						
						Configuration.getInstance(model).getView().output.setText("Customer ID  not found");
						
					}
				}else{	
					if(makeDeposit==true){
						if(pointOn==false){
							Configuration.getInstance(model).getView().output.setText(model.newDeposit((double)number));
						}else{
							Configuration.getInstance(model).getView().output.setText(model.newDeposit(numberDouble));
						}
					}
					if(makeWithdrawal==true){
						if(pointOn==false){
							Configuration.getInstance(model).getView().output.setText(model.withdrawal((double)number));
						}else{
							Configuration.getInstance(model).getView().output.setText(model.withdrawal(numberDouble));
						}
					}
				}
			number=0;
			numberDouble=0;
			pointOn=false;
			x=1;
			break;
		case "Display account Balance":
			Configuration.getInstance(model).getView().output.setText(model.getAccountBalance());
			break;
		case "Make a deposit":
			makeDeposit=true;
			makeWithdrawal=false;
			Configuration.getInstance(model).getView().deposit.setEnabled(false);
			Configuration.getInstance(model).getView().withdrawal.setEnabled(true);
			break;
		case "Make a withdrawal":
			makeDeposit=false;
			makeWithdrawal=true;
			Configuration.getInstance(model).getView().withdrawal.setEnabled(false);
			Configuration.getInstance(model).getView().deposit.setEnabled(true);
			break;
		}
		if(pointOn==false){	
			Configuration.getInstance(model).getView().input.setText(Integer.toString(number));
		}if(pointOn==true){
			Configuration.getInstance(model).getView().input.setText(Double.toString(numberDouble));
		}
	}
}

