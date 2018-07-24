package com.cg.wallet.services;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.wallet.beans.Wallet;
import com.cg.wallet.exceptions.InsufficientBalanceException;
import com.cg.wallet.exceptions.InvalidInputException;
import com.cg.wallet.beans.Customer;
import com.cg.wallet.dao.Dao;

@Component(value="service")
public class ServiceImpl implements Service{

	@Autowired
	private Dao daoservices;
	BigDecimal minBalance = new BigDecimal("0");
	
	
	@Transactional
	@Override
	public Customer createAccount(Customer customer) {
	
		return daoservices.save(customer);
	}

	@Override
	public Customer showBalance(String mobileNo) {
		// TODO Auto-generated method stub
		
		Customer c1=daoservices.findOne(mobileNo);
		return c1;
	}

	@Override
	public Customer withdraw(String mobileNo, BigDecimal balance) {
		// TODO Auto-generated method stub
		Customer customer = daoservices.findOne(mobileNo);
		if (customer != null) {
			BigDecimal tempBalance = customer.getWallet().getBalance();
			if (tempBalance.max(minBalance).equals(new BigDecimal("0"))) {
				throw new InsufficientBalanceException("Insufficient Balance.");
			} else if (tempBalance.subtract(balance).max(minBalance)
					.equals(minBalance)) {
				throw new InsufficientBalanceException("Overdraft limit error.");
			} else {
				Wallet wallet = new Wallet(customer.getWallet().getBalance()
						.subtract(balance));
				customer.setWallet(wallet);
				if (daoservices.save(customer)!=null) {
					return customer;
				} else {
					return null;
				}
			}
		} else
			throw new InvalidInputException("Invalid mobile no ");
	}

	@Override
	public Customer deposit(String mobileNo, BigDecimal balance) {
		Customer customer = daoservices.findOne(mobileNo);
		if (customer != null) {

			Wallet wallet = new Wallet(customer.getWallet().getBalance()
					.add(balance));
			customer.setWallet(wallet);
			if (daoservices.save(customer)!=null) {
				return customer;
			} else {
				return null;
			}
		} else
			throw new InvalidInputException("Invalid mobile no ");
	}

	@Override
	public Customer fundtransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) {
		// TODO Auto-generated method stub
		
		
		if (daoservices.findOne(sourceMobileNo) == null) {
			throw new InvalidInputException("Invalid source mobile number ");
		} else if (daoservices.findOne(targetMobileNo) == null) {
			throw new InvalidInputException("Invalid target mobile number ");
		} else {
			Customer sourceCustomer = daoservices.findOne(sourceMobileNo);
			Customer targetCustomer = daoservices.findOne(targetMobileNo);
			
			BigDecimal tempBalance = sourceCustomer.getWallet().getBalance();
			
				Wallet sourceWallet = new Wallet(sourceCustomer.getWallet()
						.getBalance().subtract(amount));
				Wallet targetWallet = new Wallet(targetCustomer.getWallet()
						.getBalance().add(amount));
				sourceCustomer.setWallet(sourceWallet);
				targetCustomer.setWallet(targetWallet);
				if (daoservices.save(sourceCustomer)!=null && daoservices.save(targetCustomer)!=null) {
					return sourceCustomer;
				} else {
					return null;
				}
			}
		}
	}


