package com.cg.bankaccount.testing;

import static org.junit.Assert.*;

import org.junit.*;

import com.cg.bankacccount.exceptions.InvalidDepositException;
import com.cg.bankacccount.exceptions.InvalidFundAmountException;
import com.cg.bankacccount.exceptions.InvalidWithdrawException;
import com.cg.bankaccount.service.BankServiceImpl;

public class BankServiceImplTest {
	
	BankServiceImpl serviceObj;
	
	@Before
	public void before() {
		serviceObj=new BankServiceImpl();
	}
	
	@After
	public void after() {
		serviceObj=null;
	}
	
	@Test	
	public void testCreateAccount() {
		serviceObj.createAccount(12345678l,"Alokananda Ghosh",9876543210l,20000.00);
		assertEquals(12345678l,(long)serviceObj.dao.a1.getAccNo());
		assertEquals("Alokananda Ghosh",serviceObj.dao.a1.getName());
		assertEquals(9876543210l,(long)serviceObj.dao.a1.getPhoneno());
		assertEquals(20000.00,(double)serviceObj.dao.a1.getBalance(),0);
	}

	@Test
	public void testShowBalance() {
		serviceObj.createAccount(12345632l,"John Carter",9876543201l,50000.00);
		assertEquals(50000.00,(long)serviceObj.showBalance(12345632l),0);
	}

	@Test
	public void testDeposit() {
		serviceObj.createAccount(12344132l,"David Perry",9873543201l,70000.00);
		try {
			serviceObj.deposit(12344132l, 30000.00);
			assertEquals(100000.00,(double)serviceObj.dao.a1.getBalance(),0);
		} catch (InvalidDepositException e1) { fail(); }		
		try{
			serviceObj.deposit(12344132l, 0);
			fail();
		} catch(InvalidDepositException e) {}
		
	}

	@Test
	public void testWithdraw() {
		serviceObj.createAccount(12344178l,"David Perry",9873543556l,110000.00);
		try {
			serviceObj.withdraw(12344178l, 20000.00);
			assertEquals(90000.00,(double)serviceObj.dao.a1.getBalance(),0);
		} catch (InvalidWithdrawException e) {	fail();	}
		try {
			serviceObj.withdraw(12344178l,0);
			fail();
		} catch (InvalidWithdrawException e) {System.out.println(e.getMessage());	}
		
	}

	@Test
	public void testFundtransfer() {
		
		serviceObj.createAccount(67344146l,"Daniel Rashford",9875897456l,200000.00);
		serviceObj.createAccount(35344818l,"Dany Shaw",9235417896l,100000.00);
		try {
			serviceObj.fundtransfer(67344146l,35344818l,40000.00);
			assertEquals(160000.00,serviceObj.showBalance(67344146l),0);
			assertEquals(140000.00,serviceObj.showBalance(35344818l),0);
		} catch (InvalidFundAmountException e) {fail();	}
		try {
			serviceObj.fundtransfer(67344146l,35344818l,400); //error as minimum amount to transfer is 500
			fail();
		} catch (InvalidFundAmountException e) {System.out.println(e.getMessage());}
		
	}

	@Ignore("It will display the Account List on the console only")
	public void testDisplay() {
		
	}

	@Test
	public void testValidateName() {
		assertTrue(serviceObj.validateName("Alokananda Ghosh"));
		assertTrue(serviceObj.validateName("alokananda Ghosh"));
		assertTrue(serviceObj.validateName("Alokananda ghosh"));
		assertTrue(serviceObj.validateName("alokananda ghosh"));
		
		assertFalse(serviceObj.validateName("alok@ananda Ghosh"));
		assertFalse(serviceObj.validateName("alokana&nda Ghosh"));
	}

	@Test
	public void testValidateContactNumber() {
		assertTrue(serviceObj.validateContactNumber(9876543210l));
		assertTrue(serviceObj.validateContactNumber(8976543210l));
		assertTrue(serviceObj.validateContactNumber(7654123089l));
		
		assertFalse(serviceObj.validateContactNumber(6541239870l));	//not starting with 7,8 or 9
		assertFalse(serviceObj.validateContactNumber(987654321l));	//less than 10 digit
		assertFalse(serviceObj.validateContactNumber(98765432100l));//greater than 10 digit
	}

}
