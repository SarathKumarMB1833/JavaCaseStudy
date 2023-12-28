package com.ilp.services;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.CurrentAccount;
import com.ilp.entity.Customer;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Services;

public class CustomerAccountService {

	public static void createService(ArrayList<Services> serviceList) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Services service = null;
		char choice = 'y';
		do {
			System.out.println("Enter Service Code : ");
			String serviceCode = scanner.next();

			System.out.println("Enter Service Name  : ");
			String serviceName = scanner.next();

			System.out.println("Enter Transaction Rate : ");
			double serviceRate = scanner.nextDouble();

			service = new Services(serviceCode, serviceName, serviceRate);
			serviceList.add(service);
			System.out.println("Do you want to continue (y/n)");
			choice = scanner.next().charAt(0);

		} while (choice == 'y');

	}

	public static void createProduct(ArrayList<Product> productList, ArrayList<Services> serviceList) {
		Scanner scanner = new Scanner(System.in);
		char addProductChoice;
		char productTypeChoice;
		char serviceChoice;
		do {

			System.out.println("Enter the Product Code");
			String productCode = scanner.next();
			System.out.println("Enter the Product Name");
			String productName = scanner.next();
			int serviceListLength = serviceList.size();
			System.out.println(serviceListLength);

			ArrayList<Services> productServiceList = new ArrayList<>();
			SavingsMaxAccount savingsMaxAccount = null;
			LoanAccount loanAccount = null;
			CurrentAccount currentAccount = null;
			do {
				int serialNo = 1;
				System.out.println("Select the Service from below List");
				for (Services service : serviceList) {
					System.out.println(serialNo + service.getServiceName());
					serialNo++;
				}
				System.out.println("Select the Service");
				int serviceItemChoice = scanner.nextInt();
				if (serviceList.isEmpty()) {
					System.out.println("No Service added");
				} else {
					productServiceList.add(serviceList.get(serviceItemChoice - 1));
					serviceListLength--;
				}
				System.out.println("Do you want to add another service? (y/n)");
				serviceChoice = scanner.next().charAt(0);
			} while (serviceChoice == 'y');
			switch (productName) {
			case "SavingsMaxAccount":
				savingsMaxAccount = new SavingsMaxAccount(productCode, productName, productServiceList, 1000.0);
				productList.add(savingsMaxAccount);
				break;
			case "LoanAccount":
				loanAccount = new LoanAccount(productCode, productName, productServiceList, 4);
				productList.add(loanAccount);

				break;
			case "CurrentAccount":
				currentAccount = new CurrentAccount(productCode, productName, productServiceList);
				productList.add(currentAccount);
				break;
			}
			System.out.println("Do you want to enter another product? (y/n)");
			addProductChoice = scanner.next().charAt(0);
		} while (addProductChoice == 'y');

	}

	public static Customer createCustomer(ArrayList<Customer> customerList, ArrayList<Product> productList, Customer customer) {

		ArrayList<Account> accountList = new ArrayList<Account>();
		ArrayList<Account> tempList = null;
		int concatNumber = 1;
//		Customer customer = null;
		char accountContinueChoice = 'y';
		Scanner scanner = new Scanner(System.in);
		String customerCode;
		String customerName;
		System.out.println("Enter the customer code :");
		customerCode = scanner.nextLine();
		boolean flag = true;
		for (Customer customer1 : customerList) {
			if (customer1.getCustomerCode().equals(customerCode)) {
				flag = false;
			}
		}
		if (flag) {
			System.out.println("Customer id not available: Create a new account");
			do {
				System.out.println("*************Accounts Available****************");
				int i = 1;
				for (Product product : productList) {
					System.out.println(i + ". " + product.getProductName());
					i++;
				}
				System.out.println("Enter Your Choice");
				int accountChoice = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter the customer code:");
				customerCode = scanner.nextLine();
				System.out.println("Enter the customer name:");
				customerName = scanner.nextLine();
				System.out.println("Enter the balance amount");
				double balanceAmount = scanner.nextDouble();
				scanner.nextLine();
				Account account = new Account("AC00" + concatNumber,
						productList.get(accountChoice - 1).getProductName(), balanceAmount,
						productList.get(accountChoice - 1));
				concatNumber++;
				accountList.add(account);
				
				System.out
						.println(productList.get(accountChoice - 1).getProductName() + " Created for " + customerName);
				System.out.println("Account is Active !!!!");
				System.out.println("You Have the following Services");
				ArrayList<Services> localServiceList = productList.get(accountChoice - 1).getServiceList();
				int size = localServiceList.size();
				int count = 0;
				for (Services service : localServiceList) {

					if (count == size - 1)
						System.out.print(service.getServiceName());
					else
						System.out.print(service.getServiceName() + " ,");
					count++;

				}
				System.out.println("");
				System.out.println("Do you want to add more account(y/n)");
				accountContinueChoice = scanner.next().charAt(0);
				scanner.nextLine();
			} while (accountContinueChoice == 'y' || accountContinueChoice == 'Y');
			customer = new Customer(customerCode, customerName, accountList);
			customerList.add(customer);

		}

		else {
			tempList = customer.getAccountList();
			do {
				System.out.println("*************Accounts Available****************");
				int i = 1;
				for (Product product : productList) {

					System.out.println(i + ". " + product.getProductName());
					i++;
				}
				System.out.println("Enter Your Choice");
				int accountChoice = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter the customer code:");
				customerCode = scanner.nextLine();
				System.out.println("Enter the customer name:");
				customerName = scanner.nextLine();
				System.out.println("Enter the balance amount");
				double balanceAmount = scanner.nextDouble();
				scanner.nextLine();
				Account account = new Account("AC00" + concatNumber,
						productList.get(accountChoice - 1).getProductName(), balanceAmount,
						productList.get(accountChoice - 1));
				concatNumber++;
//				accountList.add(account);
//				tempList = customer.getAccountList();
				tempList.add(account);
//				customer.setAccountList(tempList);
				
				System.out
						.println(productList.get(accountChoice - 1).getProductName() + " Created for " + customerName);
				System.out.println("Account is Active !!!!");
				System.out.println("You Have the following Services");
				ArrayList<Services> localServiceList = productList.get(accountChoice - 1).getServiceList();
				int size = localServiceList.size();
				int count = 0;
				for (Services service : localServiceList) {

					if (count == size - 1)
						System.out.print(service.getServiceName());
					else
						System.out.print(service.getServiceName() + " ,");
					count++;

				}
				System.out.println("");
				System.out.println("Do you want to add more account(y/n)");
				accountContinueChoice = scanner.next().charAt(0);
				scanner.nextLine();
			} while (accountContinueChoice == 'y' || accountContinueChoice == 'Y');
			customer.setAccountList(tempList);
		}
		
		return customer;
			
	}

	public static void manageAccount(ArrayList<Customer> customerList) {
		Scanner scanner = new Scanner(System.in);
		Customer currentCustomer = null;
		String customerCode;
		System.out.println("Enter the customer id");
		customerCode = scanner.next();
		boolean flag = false;
		for (Customer customer : customerList) {
			if (customer.getCustomerCode().equals(customerCode)) {
				flag = true;
				currentCustomer = customer;
				break;
			}
		}
		if (flag) {
			String accountType;
			System.out.println(currentCustomer.getCustomerName() + " has the following accounts:");
			for (Account account : currentCustomer.getAccountList()) {
				System.out.println(account.getAccountType());
			}
			System.out.println("Enter the choice");
			accountType = scanner.next();
			Account activeAccount = null;
			for (Account account : currentCustomer.getAccountList()) {
				if (account.getAccountType().equals(accountType)) {
					activeAccount = account;
					break;
				}
			}
			char transactionContinueChoice = 'y';
			do {
				System.out.println("Enter your choice:");
				System.out.println("1.Deposit Money\n2.Withdraw Money\n3.Display Balance");
				int transactionChoice = scanner.nextInt();
				double balanceMoney = 0;
				switch (transactionChoice) {
				case 1:
					System.out.println("Enter the amount to deposit:");
					double depositAmount = scanner.nextDouble();
					if (activeAccount.getAccountType().equals("LoanAccount")) {
						System.out.println("Enter The Deposit Method \n 1. Cash Deposit \n 2.Cheque Deposit");
						int choice = scanner.nextInt();
						switch (choice) {
						case 1:
							balanceMoney = activeAccount.getBalance() - depositAmount;
							break;
						case 2:
							double rateDeduction = depositAmount * (0.3 / 100);
							depositAmount = depositAmount - rateDeduction;
							balanceMoney = activeAccount.getBalance() - depositAmount;

						}
					} else {
						balanceMoney = activeAccount.getBalance() + depositAmount;
					}
					activeAccount.setBalance(balanceMoney);
					break;
				case 2:
					if (activeAccount.getAccountType().equals("LoanAccount")) {
						System.out.println("ERROR : You Cannot Withdraw From Loan Account");
					}
					System.out.println("Enter the amount to withdraw:");
					double withdrawAmount = scanner.nextDouble();
					balanceMoney = activeAccount.getBalance() - withdrawAmount;
					if (activeAccount.getAccountType().equals("SavingsMaxAccount")) {
						if (balanceMoney < ((SavingsMaxAccount) activeAccount.getProduct()).getMinBalance()) {
							System.out.println("Withdrawal blocked due to insufficient balance\nMinimum balance of "
									+ ((SavingsMaxAccount) activeAccount.getProduct()).getMinBalance()
									+ " should be maintained");
							System.out.println("Your current balance is: " + activeAccount.getBalance());
						}

					} else {
						activeAccount.setBalance(activeAccount.getBalance() - withdrawAmount);
						break;
					}
				case 3:
					System.out.println("Your balance amount: " + activeAccount.getBalance());
					break;
				default:
					System.out.println("Invalid");

				}
				System.out.println("Do you want to continue:(y/n)");
				transactionContinueChoice = scanner.next().charAt(0);
			} while (transactionContinueChoice == 'y' || transactionContinueChoice == 'Y');

		}

	}

	public static void displayAccount(ArrayList<Customer> customerList) {
		String customerCode;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the customer id:");
		customerCode = scanner.next();
		for (Customer customer : customerList) {
			if (customer.getCustomerCode().equals(customerCode)) {
				System.out.println("************************Customer Account Details****************************");
				System.out.println("Customer_id\t\tCustomer_name\t\tAccount_Type\t\tBalance");
				System.out.println("****************************************************************************");

				ArrayList<Account> accountList = customer.getAccountList();
				for (Account account : accountList) {
					System.out.println(customer.getCustomerCode() + "\t\t\t" + customer.getCustomerName() + "\t\t\t"
							+ account.getAccountType() + "\t\t" + account.getBalance());
					System.out.print("Services provided:");
					ArrayList<Services> serviceList = account.getProduct().getServiceList();
					int size = serviceList.size();
					int count = 0;
					for (Services service : serviceList) {
						if (count == size - 1)
							System.out.print(service.getServiceName());
						else
							System.out.print(service.getServiceName() + " ,");
						count++;
					}
					System.out.println();

				}
			}
		}

	}

}
