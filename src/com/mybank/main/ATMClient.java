package com.mybank.main;

import com.mybank.data.*;
import com.mybank.domain.Bank;
import com.mybank.domain.Customer;
import com.mybank.fvk.Configuration;
import com.mybank.model.Model;
import com.mybank.view.ATMView;

import java.io.*;
import java.awt.*;
import javax.swing.*;

public class ATMClient {
private int	numberOfCustomer;
  private static final String USAGE = "USAGE: java com.mybank.gui.ATMClient <dataFilePath>";
 
  public static void main(String[] args) {
	

    // Retrieve the dataFilePath command-line argument
    if ( args.length != 1 ) {
      System.out.println(USAGE);
    } else {
      String dataFilePath = args[0];

      try {
	System.out.println("Reading data file: " + dataFilePath);
	// Create the data source and load the Bank data
	DataSource dataSource = new DataSource(dataFilePath);
	dataSource.loadData();
	 
	     } catch (IOException ioe) {
	System.out.println("Could not load the data file.");
	System.out.println(ioe.getMessage());
	ioe.printStackTrace(System.err);
      }
    }
    Model model=new Model();
    ATMView view= Configuration.getInstance(model).getView();
  } 
}            
