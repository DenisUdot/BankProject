package com.mybank.view;
import java.awt.*;
import javax.swing.*;

import com.mybank.controller.KeyPadController;
import com.mybank.model.Model;

public class ATMView extends JPanel {
	
public JTextArea output;
public JTextField input;
public JTextField message;
public JPanel actionButtonPanel;
public JButton accountBalance;
public JButton deposit;
public JButton withdrawal;
public JPanel keyPadPanel;
public JButton[] keyPad;
public Model model = null;
public JFrame frame;

public ATMView(Model m) {
	super();
	this.model = m;
	frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Java Bank ATM");
    frame.setVisible(true);
    
    KeyPadController kpc=new KeyPadController(model);
    
	output=new JTextArea(13,75);
	output.setEditable(false);
	output.setText("Enter your customer ID into the key pad and press ENTER  ");
	output.setLineWrap(true);
	output.setWrapStyleWord(true);
	
	message=new JTextField(75);
	message.setEnabled(false);
	
	input=new JTextField(10);
	
	input.setEnabled(false);
	accountBalance=new JButton("Display account Balance");
	accountBalance.setActionCommand("Display account Balance");
	accountBalance.setEnabled(false);
	accountBalance.addActionListener(kpc);
	
	deposit=new JButton("Make a deposit");
	deposit.setActionCommand("Make a deposit");
	deposit.setEnabled(false);
	deposit.addActionListener(kpc);
	
	withdrawal=new JButton("Make a withdrawal");
	withdrawal.setActionCommand("Make a withdrawal");
	withdrawal.setEnabled(false);
	withdrawal.addActionListener(kpc);
	
	keyPad=new JButton[12];

	//creating panel and adding JTextField and JTextArea
	JPanel outText=new JPanel();
	outText.setLayout(new BoxLayout(outText,BoxLayout.Y_AXIS));
	outText.add(output);
	outText.add(message);
	
	JPanel buttonPanel=new JPanel();
	buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.Y_AXIS));
	
	//creating action button panel and adding buttons
	actionButtonPanel=new JPanel();
	actionButtonPanel.setLayout(new GridLayout(4,1));
	actionButtonPanel.add(accountBalance);
	actionButtonPanel.add(deposit);
	actionButtonPanel.add(withdrawal);
	actionButtonPanel.add(input);
	
	//creating key pad panel and adding buttons
	keyPadPanel=new JPanel();
	keyPadPanel.setLayout(new GridLayout(4,3));
	
	for(int i=1;i<(keyPad.length-2);i++){
		keyPad[i]=new JButton(Integer.toString(i));
		keyPad[i].setActionCommand(Integer.toString(i));
		keyPad[i].addActionListener(kpc);
		keyPadPanel.add(keyPad[i]);
	}
	keyPad[0]=new JButton("0");
	keyPad[0].setActionCommand("0");
	keyPadPanel.add(keyPad[0]);
	keyPad[0].addActionListener(kpc);
	keyPad[keyPad.length-2]=new JButton(".");
	keyPad[keyPad.length-2].setActionCommand(".");
	keyPad[keyPad.length-2].setEnabled(false);
	keyPad[keyPad.length-2].addActionListener(kpc);
	keyPadPanel.add(keyPad[keyPad.length-2]);
	
	keyPad[keyPad.length-1]=new JButton("ENTER");
	keyPad[keyPad.length-1].setActionCommand("ENTER");
	keyPad[keyPad.length-1].addActionListener(kpc);
	keyPadPanel.add(keyPad[keyPad.length-1]);
		
	buttonPanel.add(actionButtonPanel);
	buttonPanel.add(keyPadPanel);
	
	frame.add(buttonPanel, BorderLayout.WEST);
	frame.add(outText, BorderLayout.EAST);
	frame.pack();
	
}

}
