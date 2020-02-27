package com.capgemini.librarymanagement.controller;

import java.util.Scanner;

import com.capgemini.librarymanagement.validation.LibraryManagementValidation;

public class LibraryMainPage {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		LibraryManagementController libraryManagementController=new LibraryManagementController();
		System.out.println("LIBRARY MANAGEMENT SYSTEM");
		System.out.println("---------------------------");
	
		boolean flag = true;
		while (flag == true) {
			System.out.println("<----login---->");
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter UserName \n");
			String userName = scanner.next();
			System.out.println("Enter Password \n");
			String password = scanner.next();

			if (userName.equals("Admin") && password.equals("admin@123")) {
				libraryManagementController.admin();
			} else if (userName.equals("User") && password.equals("user@123")) {
				LibraryManagementController.user();
			} else {
				System.out.println("Please enter correct username and password?");
			}

		}
		
		
	}

}
