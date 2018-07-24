package com.cg.wallet.services;

import java.math.BigDecimal;

import com.cg.wallet.beans.Customer;

public interface Service {

	public Customer createAccount(Customer customer);
	
	public Customer showBalance(String mobileNo);
	
	public Customer withdraw(String mobileNo, BigDecimal balance);
	
	public Customer deposit(String mobileNo, BigDecimal balance);
	
	public Customer fundtransfer(String sourceMobileNo, String targetMobileNo,
			BigDecimal amount);
}
