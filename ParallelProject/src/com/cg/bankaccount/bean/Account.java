package com.cg.bankaccount.bean;

import java.util.ArrayList;
import java.util.List;

public class Account {
	
	private Long AccNo;
	private String Name;
	private double balance;
	private long phoneno;
	private List<Transaction> transaction=new ArrayList<>();     //array list for transactions
	
	public long getPhoneno() {                                        
		return phoneno;
	}
	
	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	
	public Long getAccNo() {
		return AccNo;                                                     
	}
	
	public void setAccNo(Long accNo) {
		AccNo = accNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public List<Transaction> getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction .add(transaction);
	}
	
	@Override
	public String toString() {
		return "Account [AccNo=" + AccNo + ", Name=" + Name + ", balance=" + balance + ", phoneno=" + phoneno
				+ ", transaction=" + transaction + "]";
	}  
	
}
