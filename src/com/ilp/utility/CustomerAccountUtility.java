package com.ilp.utility;


import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Services;
import com.ilp.services.CustomerAccountService;

public class CustomerAccountUtility {

	public static void main(String[] args) 
	{
		
		Scanner scanner=new Scanner(System.in);
		ArrayList<Services> serviceList = new ArrayList<>();
		ArrayList<Product> productList = new ArrayList<>();
		ArrayList<Customer> customerList = new ArrayList<>();
		Customer customer = null;
		char choice='y';
		int option;
	do
	{
			System.out.println("*****Welcome To Bank*****");
			System.out.println(" 1.Create Service \n 2.Create Product \n 3.Create Customer \n 4.Manage Account \n 5.Display Account \n 6.Exit");
			System.out.println("Enter The Choice : ");
			option=scanner.nextInt();
			switch(option) 
			{
			case 1:CustomerAccountService.createService(serviceList);
				break;
			case 2:CustomerAccountService.createProduct(productList,serviceList);
				break;
			case 3:customer = CustomerAccountService.createCustomer(customerList,productList,customer);
				break;
			case 4:CustomerAccountService.manageAccount(customerList);
				break;
			case 5:CustomerAccountService.displayAccount(customerList);
			    break;
			case 6:System.out.println("Existing....!");
				return;

			}
			
		}while(option<6);

	}

}
