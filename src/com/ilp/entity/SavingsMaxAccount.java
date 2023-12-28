package com.ilp.entity;

import java.security.Provider.Service;
import java.util.ArrayList;

public class SavingsMaxAccount extends Product {
	
	private double minBalance;
	
	

	public SavingsMaxAccount(String productCode, String productName, ArrayList<Services> serviceList,
			double minBalance) {
		super(productCode, productName, serviceList);
		this.minBalance = minBalance;
	}

	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}
	
	

	    
}
