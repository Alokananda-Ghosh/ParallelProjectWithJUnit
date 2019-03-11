package com.cg.bankacccount.exceptions;

public class InvalidDepositException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidDepositException(String msg)
	{
		super(msg);
	}
}
