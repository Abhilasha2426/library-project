package com.capgemini.library_management.controller;

import java.util.LinkedList;
import java.util.Scanner;

import com.capgemini.library_management.beans.BookInfo;
import com.capgemini.library_management.beans.UserInfoBean;
import com.capgemini.library_management.dao.LibraryBookDao;
import com.capgemini.library_management.dao.LibraryBookDaoImpl;

public class LibraryMainPage {
	@SuppressWarnings({ "resource", "rawtypes", "unchecked" })
	public static void main(String[] args) {

		LibraryBookDao libraryBookDao = new LibraryBookDaoImpl();
		Scanner sc = new Scanner(System.in);
		UserInfoBean userInfoBean = null;
		BookInfo bookInfo = null;

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
				LibraryManagementController.admin();
			} else if (userName.equals("User") && password.equals("user@123")) {
				LibraryManagementController.user();
			} else {
				System.out.println("Please enter correct username and password");
			}
			
			
		}
	}
}

	

	
	

