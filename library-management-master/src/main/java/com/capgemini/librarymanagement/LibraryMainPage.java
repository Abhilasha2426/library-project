package com.capgemini.librarymanagement;

import java.util.InputMismatchException;
//import java.io.Console;
import java.util.Scanner;

import com.capgemini.librarymanagement.controller.LibraryManagementController;
import com.capgemini.librarymanagement.controller.UserController;
import com.capgemini.librarymanagement.db.DbStore1;
import com.capgemini.librarymanagement.dto.UserInfoBean;
import com.capgemini.librarymanagement.exception.ValidInputException;
import com.capgemini.librarymanagement.validation.LibraryManageValidation;

public class LibraryMainPage {

	public static void mainPage() {

		LibraryManagementController libraryManagementController = new LibraryManagementController();
		Scanner scanner = new Scanner(System.in);
		//Console consl = System.console();
		System.out.println("---*****LIBRARY MANAGEMENT SYSTEM*****---");
		System.out.println("---------------------------");
		boolean flag = true;
		while (flag) {
			
			try {
				String choice = "";
				while(!LibraryManageValidation.isParsableInt(choice)) {
					System.out.println("Available Choices");
					System.out.println("1.Admin\n2.User\n3.Exit");
					System.out.println("---------------------------");
					System.out.println("Enter Your Choice");
					choice = scanner.nextLine();
					if (!LibraryManageValidation.isParsableInt(choice)) {
						choice = "5";
					}
					
				}
				switch (Integer.parseInt(choice)) {
				case 1:
					System.out.println("----Login----");
					System.out.println("Enter UserName");
					String adminName = scanner.nextLine();
					System.out.println("Enter Password");
					//char[] adminPasswordArr = consl.readPassword();
					//String adminPassword = new String(adminPasswordArr);
					String adminPassword = scanner.nextLine();
					if (adminName.toLowerCase().equals("a") && adminPassword.equals("a")) {
						if (!DbStore1.user.isEmpty()) {
							System.out.println("req are here");
						}
						libraryManagementController.admin();
					} else {
						System.err.println("Please enter valid username and password");
					}
					break;
				case 2:
					System.out.println("----Login---->");
					System.out.println("Enter Email");
					String userEmail = scanner.nextLine();
					System.out.println("Enter Password");
					String userPassword = scanner.nextLine();
					int userFlag = 0; // To 	track if we found a valid user.
					for (UserInfoBean user : DbStore1.userInfoBean) {
//						System.out.println(user.getUsrPassword().equals(userPassword));
//						System.out.println(user.getUsrEmail().equals(userEmail));
						if (user.getUsrEmail().equals(userEmail) && user.getUsrPassword().equals(userPassword)) {
							DbStore1.user.add(user);
							UserController controller = new UserController();
							controller.user();
							userFlag = 1;
							break; // No need to check further if we found atleast one user.
						}
					}
					if (userFlag == 0) {
						System.out.println("Invalid User!");
					}
					break;
				case 3:
					System.out.println("Admin Logout Successfully");
					System.exit(0);
				default:
					System.out.println("Wrong Choice!");
					break;
				}
			} catch (InputMismatchException e) {

				try {
					throw new ValidInputException();
				} catch (ValidInputException exp) {
					System.out.println(exp.getMessage());
					mainPage();
				}
			}
			
		}
		scanner.close();
	}
}
