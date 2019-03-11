package com.cg.bankaccount.bean;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
	
	private String transactiontype;
	private double transactionamt;
	private LocalDate d;
	private LocalTime tt;

	public String getTransactiontype() {
		return transactiontype;
	}
	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}
	public double getTransactionamt() {
		return transactionamt;
	}
	public void setTransactionamt(double transactionamt) {
		this.transactionamt = transactionamt;
	}
	public LocalDate getD() {
		return d;
	}
	public void setD(LocalDate d) {
		this.d = d;
	}
	public LocalTime getTt() {
		return tt;
	}
	public void setTt(LocalTime tt) {
		this.tt = tt;
	}
	@Override
	public String toString() {
		return "Transaction [transactiontype=" + transactiontype + ", transactionamt=" + transactionamt + ", d=" + d
				+ ", tt=" + tt + "]";
	}
	

}
