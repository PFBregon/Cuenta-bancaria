package dev.patriciafb.bankacount;

import dev.patriciafb.bankacount.controller.AccountController;
import dev.patriciafb.bankacount.models.Account;
import dev.patriciafb.bankacount.service.AccountService;

public class BankacountApplication {

	public static void main(String[] args) {
			Account account = new Account(1000, 5);

			AccountService accountService = new AccountService(account);
			AccountController accountController = new AccountController(accountService);
	
			System.out.println("Performing deposit...");
			accountController.deposit(500);
			accountController.displayAccountStatus();
			System.out.println("\nPerforming withdrawal...");
			accountController.withdraw(300);
			accountController.displayAccountStatus();
			System.out.println("\nGenerating monthly statement...");
			accountController.generateMonthlyStatement();
			accountController.displayAccountStatus();
		}
	}
