package com.capgemini.library_management.controller;


import java.util.LinkedList;
import java.util.Scanner;

import com.capgemini.library_management.beans.BookInfo;
import com.capgemini.library_management.factory.LibraryManagementBookFactory;
import com.capgemini.library_management.service.LibraryBookService;

public class LibraryManagementController {

	static LibraryBookService lbs = LibraryManagementBookFactory.objLibraryService();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void admin() {
		System.out.println(" Admin Successfull login");
		
		System.out.println("Enter your choice");
		System.out.println("1.Add Book");
		System.out.println("2.Add User");
		System.out.println("3.Delete Book");
		System.out.println("4.Replace Book");
		System.out.println("5.Delete User");
		Scanner scanner = new Scanner(System.in);
		int  choice = scanner.nextInt();

		while(true) {
		if(choice==1) {
			
			int ch = scanner.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter book id: ");
				String bookId = scanner.next();
				System.out.println("Enter name of book");
				String bookName = scanner.next();
				System.out.println("Enter author name");
				String bookAuth=scanner.next();
				System.out.println("Enter Category");
				String category=scanner.next();
				System.out.println("Enter no of books");
				int bookNum=scanner.nextInt();
				System.out.println("Enter publisher name");
				String pubName=scanner.next();
				System.out.println("Enter status");
				String status=scanner.next();
				LinkedList ll = new LinkedList();
				
				
//				bookInfo = new BookInfo();
//				bookInfo.setBookName(bookName);
				
//				if(LibraryBookDao.addBook(bookInfo,ll)) {
//					System.out.println("Added");
//				}
				break;
			}
		}


	}
		
		
	}

	public static void user() {
		System.out.println("User Successfull login");
	}

}
