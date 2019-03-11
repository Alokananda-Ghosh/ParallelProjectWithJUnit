package com.cg.bankaccount.service;

import com.cg.bankacccount.exceptions.InvalidDepositException;
import com.cg.bankacccount.exceptions.InvalidFundAmountException;
import com.cg.bankacccount.exceptions.InvalidWithdrawException;
import com.cg.bankaccount.dao.BankDaoImpl;

public class BankServiceImpl implements IBankService {
	
    public BankDaoImpl dao=new BankDaoImpl();   //creating object of IBankDao interface
    
    // implementing methods of IBankService interface
    
	@Override
	public void createAccount(long AccNo, String Name,long phoneno, Double balance)
	{
		dao.createAccount(AccNo, Name,phoneno, balance);
	}

	@Override
	public long showBalance(long AccNo) 
	{
		// TODO Auto-generated method stub
		return dao.showBalance(AccNo);
	}

	@Override
	public void deposit(long AccNo, double deposit) throws InvalidDepositException 
	{
		// TODO Auto-generated method stub
		dao.deposit(AccNo, deposit);
	}

	@Override
	public void withdraw(long AccNo, double withdraw) throws InvalidWithdrawException {
		// TODO Auto-generated method stub
		dao.withdraw(AccNo, withdraw);
	}

	@Override
	public void fundtransfer(long AccNo1, long AccNo2, double fundamt) throws InvalidFundAmountException {
		// TODO Auto-generated method stub
		dao.fundtransfer(AccNo1, AccNo2, fundamt);
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		dao.display();
	}

	@Override
	public boolean validateName(String name) {
		// TODO Auto-generated method stub
		String regex="^[a-zA-Z\\s]+$";
		if(name.matches(regex))
			return true;
		return false;
	}

	@Override
	public boolean validateContactNumber(long phoneno) {
		// TODO Auto-generated method stub
		String number=String.valueOf(phoneno);
		String regex1="^([+][9][1]|[9][1]|[0]){0,1}?([7-9]{1})([0-9]{9})$";
		//long number=Long.parseLong(regex1);
		if(number.matches(regex1))
		return true;
		return false;
	}

}
