package com.capgemini.librarymanagement.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.librarymanagement.LibraryMainPage;
import com.capgemini.librarymanagement.dao.AdminBookDao;
import com.capgemini.librarymanagement.dao.AdminBookDaoImpl;
import com.capgemini.librarymanagement.dto.BookInfo;
import com.capgemini.librarymanagement.dto.UserInfoBean;
import com.capgemini.librarymanagement.exception.BookGenericException;
import com.capgemini.librarymanagement.service.UserService;
import com.capgemini.librarymanagement.service.UserServiceImpl;
import com.capgemini.librarymanagement.validation.LibraryManageValidation;
import com.capgemini.librarymanagement.service.AdminBookService;
import com.capgemini.librarymanagement.service.AdminBookServiceImpl;

public class UserController {

	UserService userService = new UserServiceImpl();
	static Logger log =Logger.getLogger(UserController.class);
	Scanner scanner = new Scanner(System.in);
	AdminBookService adminBookService = new AdminBookServiceImpl();

	public void user() {
		log.info("User login successfully");
		while (true) {
//			log.info("Enter your choice");
//			log.info("1.List Books\n2.Search Book\n3.Logout");
//			String choice = scanner.nextLine();
//			if (!LibraryManageValidation.isParsableInt(choice)) {
//				choice = "4";
//			}
			String choice = "";
			while(!LibraryManageValidation.isParsableInt(choice)) {
				log.info("Available Choices");
				log.info("1.List Books\n2.Search Book\n3.Logout");
				log.info("---------------------------");
				log.info("Enter Your Choice");
				choice = scanner.nextLine();
				if (!LibraryManageValidation.isParsableInt(choice)) {
					choice = "4";
				}
				
			}
			switch (Integer.parseInt(choice)) {
			case 1:
				log.info("---Book Details---");
				List<BookInfo> list = adminBookService.showAllBooks();
				if (!list.isEmpty()) {
					for (BookInfo books : list) {
						log.info("Book Id=" + books.getBookId() + "\t Book Name = " + books.getBookName()
								+ " \t Book Author = " + books.getBookAuthor() + "\t Number of book copies"
								+ books.getNoOfBooks() + "\t Publisher Name=" + books.getPublisher());
					}
				} else {
					log.info("No books to show");
				}
				break;
			case 2:
				log.info("Search Based on Book Name");
				String name = scanner.nextLine();
				displaySearchBookWithName(name);
				break;
			case 3:
				log.info("User Logout Successful");
				LibraryMainPage.mainPage();
				break;
			default:
				log.info("Wrong Choice!");
			}
		}
	}

	private void displaySearchBookWithName(String name) {
		LibraryManageValidation searchValidation = new LibraryManageValidation();

		if (searchValidation.bookValidation(name)) {
			BookInfo book = userService.searchBookWithName(name);
			if (book != null) {
				log.info("-------------------Book Details------------------------");
				log.info("Book Name:" + book.getBookName());
				log.info("Book Author Name:" + book.getBookAuthor());
				log.info("Publisher Name:" + book.getPublisher());
				log.info("-------------------------------------------------------");
				UserInfoBean bean = new UserInfoBean();
				while (true) {
					log.info("1.Borrow\n2.Return Book\n3.Return to SearchBook\n4.Logout\n");
					String choice = scanner.nextLine();
					System.out.println("Choice:" + choice);
					if (!LibraryManageValidation.isParsableInt(choice)) {
						choice = "5";
					}

					switch (Integer.parseInt(choice)) {

					case 1:
						if (barrow(book, bean)) {
							try {
								log.info("Your Book Request is on proccessing");
								log.info("-------------------------------------------------------");
								Thread.sleep(3000);
								AdminBookDao adminBookDaoImpl = new AdminBookDaoImpl();
								adminBookDaoImpl.requestPass();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						} else {
							log.info("unable to send Request");
						}

						break;
					case 2:
						log.info("Enter return date");
						String date = scanner.nextLine();
						if (userService.bookReturn(date)) {
							try {
								log.info("Your Book Return Request is on proccessing");
								log.info("-------------------------------------------------------");
								Thread.sleep(3000);
								log.info("Book Return Request Sent Successfully");
								AdminBookDao adminBookDaoImpl = new AdminBookDaoImpl();
								adminBookDaoImpl.bookRecieve();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						} else {
							log.info("Unable to send book return request");

						}
						break;
					case 3:
						user();
						break;
					case 4:
						log.info("Logout to Main Page Successful");
						LibraryMainPage.mainPage();
						break;
					default:
						log.info("Wrong Choice!");
						break;
					}
				}
			} else {
				try {
					throw new BookGenericException("Invalid Name");
				} catch (BookGenericException e) {
					log.info(e.getMessage());
				}
			}

		}

	}

	public boolean barrow(BookInfo book, UserInfoBean bean) {

		if (userService.requestCheck(book, bean)) {
			return true;

		} else {
			return false;
		}

	}
}
