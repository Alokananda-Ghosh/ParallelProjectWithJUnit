package com.cg.bankaccount.service;

import com.cg.bankacccount.exceptions.InvalidDepositException;
import com.cg.bankacccount.exceptions.InvalidFundAmountException;
import com.cg.bankacccount.exceptions.InvalidWithdrawException;

public interface IBankService
{
	     //service interface methods
	public void createAccount(long AccNo,String Name,long phoneno,Double balance);
	public long showBalance(long AccNo);
	public void  deposit(long AccNo,double deposit) throws InvalidDepositException;
	public void  withdraw(long AccNo,double withdraw) throws InvalidWithdrawException;
	public void  fundtransfer(long AccNo1,long AccNo2,double fundamt) throws InvalidFundAmountException;
	public boolean validateName(String name);
	public boolean validateContactNumber(long phoneno);
	public void  display();
	

}
