package com.cg.bankaccount.ui;

import java.util.Random;
import java.util.Scanner;

import com.cg.bankacccount.exceptions.InvalidDepositException;
import com.cg.bankacccount.exceptions.InvalidFundAmountException;
import com.cg.bankacccount.exceptions.InvalidWithdrawException;
import com.cg.bankaccount.service.IBankService;
import com.cg.bankaccount.service.BankServiceImpl;

public class AccountMain
{
public static void main(String[] args) 
{
	IBankService service=new BankServiceImpl();      //creating object of IBankService
	Scanner sc=new Scanner(System.in);                //creating Scanner class object to input user data
	while(true)
	{
		System.out.println("1.create account");
		System.out.println("2.show balance");
		System.out.println("3.deposit into account");
		System.out.println("4.withdraw from account");
		System.out.println("5.fund transfer");
		System.out.println("6.display account");
		System.out.println("7.exit");
		int opt=sc.nextInt();
		switch(opt)
		{
		case 1:   Random obj=new Random(); //generating account no randomly
		          long accno=obj.nextLong();
		          String  name;           
		          do {
			      System.out.println("enter name");
			      name=sc.next();
		          }while(!service.validateName(name));    //checking validation method for name
		          
		          long phoneno;
		          do {
			      System.out.println("enter contact number");
			      phoneno=sc.nextLong();
		          }while(!service.validateContactNumber(phoneno));    //checking validation method for contact number
			   
			      double balance=0;
			      service.createAccount(accno, name,phoneno, balance);
			      break;
			      
		case 2:   System.out.println("enter acc no to show balance");	  
		          long accno1=sc.nextLong();
		          System.out.println("Balance :"+service.showBalance(accno1));
		          break;
		          
		case 3:   System.out.println("enter amount to be deposited"); 
		          double deposit=sc.nextDouble();
		          System.out.println("enter acc no to deposit money");	  
		          long accno2=sc.nextLong();
				try {
					service.deposit(accno2, deposit);
				} catch (InvalidDepositException e) {
					System.out.println(e.getMessage());
				}
		          break;
		          
		case 4:   System.out.println("enter amount to be withdrawn"); 
			      double withdraw=sc.nextDouble();
			      System.out.println("enter acc no to withdraw money");	  
			      long accno5=sc.nextLong();
				try {
					service.withdraw(accno5, withdraw);
				} catch (InvalidWithdrawException e) {
					System.out.println(e.getMessage());
				}
			      break;    
					          
		          
		          
		case 5:     System.out.println("enter amount to be transfered"); 
			        double fundamt=sc.nextDouble();
			        System.out.println("enter acc no from where  money to be transfered");	  
			        long accno3=sc.nextLong();  
			        System.out.println("enter acc no where  money to be transfered");	  
			        long accno4=sc.nextLong();  
					try {
						service.fundtransfer(accno3, accno4, fundamt);
					} catch (InvalidFundAmountException e) {
						System.out.println(e.getMessage());
					}
			        break;
			        
		case 6:    service.display();	        
				   break;
				 
		case 7:    System.out.println("terminated");
		           System.exit(0);                                   //to exit system
		           sc.close();                                       //closing resource
		default:  System.out.println("wrong choice");			
		
		}  
	}
}
}
