package com.cg.bankaccount.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.cg.bankacccount.exceptions.InvalidDepositException;
import com.cg.bankacccount.exceptions.InvalidFundAmountException;
import com.cg.bankacccount.exceptions.InvalidWithdrawException;
import com.cg.bankaccount.bean.Account;
import com.cg.bankaccount.bean.Transaction;

public class BankDaoImpl implements IBankDao
{
     ArrayList<Account> list=new ArrayList<>();
     public Account a1;
     public Transaction t;
     //implemented methods of IBankDao interface
	
     @Override	
	public void createAccount(long AccNo, String Name,long phoneno, Double balance){ //method to create account
		
		a1=new Account();	
		a1.setAccNo(AccNo);
		a1.setName(Name);
		a1.setPhoneno(phoneno);
		a1.setBalance(balance);
		list.add(a1);		
		System.out.println("Account created successfully with account no"+" "+a1.getAccNo());		
	}

	@Override
	public long showBalance(long AccNo){                                          //method to show balance
		
		long balance=0;
	    for(Account a:list){
	    	if(a.getAccNo()==AccNo)			
	    		balance = (long) a.getBalance();
	    }
	    return balance;
	}

	@Override
	public void deposit(long AccNo,double deposit) throws InvalidDepositException {                             //method to deposit in account
		for (Account a:list) {
			if(a.getAccNo()==AccNo && deposit>0){
				double currentbalance=a.getBalance()+deposit;
				a.setBalance(currentbalance);
				System.out.println("Current balance after deposit is:"+a.getBalance());
				
				t=new Transaction();
				t.setTransactiontype("credit");
				t.setTransactionamt(deposit);
				t.setD(LocalDate.now());
				t.setTt(LocalTime.now());
				a.setTransaction(t);
				System.out.println(a);
				System.out.println("\ncredit done successfully");
			}
			else if(deposit==0)
				throw new InvalidDepositException("enter deposit amonut >0");
		}
	}
	
	@Override
	public void withdraw(long AccNo,double withdraw) throws InvalidWithdrawException                             //method to withdraw from account
	{
		for (Account a:list)
		{
			if(a.getAccNo()==AccNo && withdraw>0 && a.getBalance()>withdraw)
			{
				
				double currentbalance=a.getBalance()-withdraw;
				a.setBalance(currentbalance);
				System.out.println("Balance after withdrawing money"+a.getBalance());
				
				
				Transaction t1=new Transaction();
				t1.setTransactiontype("debit");
				t1.setTransactionamt(withdraw);
				t1.setD(LocalDate.now());
				t1.setTt(LocalTime.now());
				a.setTransaction(t1);
				System.out.println(a);
				System.out.println("\ndebit done successfully");
			}
			else if(withdraw==0)
			{
				throw new InvalidWithdrawException("enter withdraw amonut >0");
			}
			
			}
		}
	
	@Override
	public void fundtransfer(long AccNo1, long AccNo2, double fundamt) throws InvalidFundAmountException      //method to transfer fund amount
	{
		for(Account a:list)
		{
			
		if(a.getAccNo()==AccNo1 && fundamt>500)
		{
			double f=a.getBalance()-fundamt;
			a.setBalance(f);
			System.out.println(a.getBalance());
			
		}
		
		if(a.getAccNo()==AccNo2)
		{
			double f=a.getBalance()+fundamt;
			a.setBalance(f);
			System.out.println(a.getBalance());
		}
		else if(fundamt<500)
		{
			throw new InvalidFundAmountException("amount to be transfered >500");
		}
			
	}
	}
	
	@Override
	public void display()                                                    //method to display account details
		{
			System.out.println(list);
			
		}

}

