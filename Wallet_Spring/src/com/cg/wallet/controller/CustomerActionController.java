package com.cg.wallet.controller;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.wallet.beans.Customer;
import com.cg.wallet.services.Service;

@Controller
public class CustomerActionController {

	@Autowired(required=true)
	private Service service;
	
	
	@RequestMapping(value="/registerCustomer",method=RequestMethod.POST)
	public ModelAndView registerCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
		try
		{
			if(result.hasErrors())
				return new ModelAndView("registerCustomer");
			customer=service.createAccount(customer);
			
			
		} catch(Exception e)
		{
			e.printStackTrace();
			return new ModelAndView("error");
		}
		return  new ModelAndView("createAccountSuccess", "customer", customer);
	}
	
	@RequestMapping(value="/showBalancePage")
	public ModelAndView showBalancePage(@RequestParam("mobileNo")String mobileNo) {
		try
		{
			Customer  customer=service.showBalance(mobileNo);
			ModelAndView modelAndView = new ModelAndView("showBalanceSuccess", "customer", customer);
			return modelAndView;
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ModelAndView("error");
	}
	
	@RequestMapping(value="/withdrawAmount")
	public ModelAndView withdrawAmount(@RequestParam("mobileNo")String mobileNo,@RequestParam("balance") BigDecimal balance)
	{
		try
		{
		 Customer customer=service.withdraw(mobileNo, balance); 
		ModelAndView modelAndView=new ModelAndView("withdrawSuccess","customer", customer);
		return modelAndView;
		
	}catch(Exception e)
		{
		e.printStackTrace();
		}
	return new ModelAndView("error");
	}
	
	@RequestMapping(value="/depositAmount")
	public ModelAndView depositAmount(@RequestParam("mobileNo")String mobileNo,@RequestParam("balance") BigDecimal balance)
	{
		try
		{
		 Customer customer=service.deposit(mobileNo, balance); 
		ModelAndView modelAndView=new ModelAndView("depositPageSuccess","customer", customer);
		return modelAndView;
		
	}catch(Exception e)
		{
		e.printStackTrace();
		}
	return new ModelAndView("error");
	}
	
	
	@RequestMapping(value="/fundTransfer")
	public ModelAndView fundTransfer(@RequestParam("sourceMobileNo")String sourceMobileNo,@RequestParam("targetMobileNo")String targetMobileNo,@RequestParam("balance")BigDecimal amount) {
		try
		{
			Customer customer=service.fundtransfer(sourceMobileNo, targetMobileNo, amount);
			ModelAndView modelAndView = new ModelAndView("fundTransferPageSuccess", "customer", customer);
			return modelAndView;
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ModelAndView("error");
	}
	
}
