package com.cg.wallet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.wallet.beans.Customer;

@Controller
public class URIController {

	
	@RequestMapping("/")
	public String getIndexPage() {
		return "indexPage";
	}
	
	
	@RequestMapping("/createAccount")
	public String getCreateAccountPage() {
		return "createAccountPage";
	}
	
	@RequestMapping("/showBalance")
	public String getShowBalancePage() {
		return "showBalancePage";
	}
	
	@RequestMapping("/withdrawal")
	public String getwithdrawPage() {
		return "withdrawPage";
	}
	
	@RequestMapping("/deposit_Amount")
	public String getDepositPage() {
		return "depositPage";
	}
	
	@RequestMapping("/fund_Transfer")
	public String getfundTransferPage() {
		return "fundTransferPage";
	}
	
	
	
	@ModelAttribute("customer")
	public Customer getCustomer() {
		return new Customer();
	}
	
}
