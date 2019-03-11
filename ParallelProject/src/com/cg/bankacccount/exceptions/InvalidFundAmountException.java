package com.cg.bankacccount.exceptions;

public class InvalidFundAmountException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidFundAmountException(String msg)
	{
		super(msg);
	}
}
