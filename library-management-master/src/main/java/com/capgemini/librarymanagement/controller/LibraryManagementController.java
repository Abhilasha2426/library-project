package com.capgemini.librarymanagement.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.librarymanagement.LibraryMainPage;
import com.capgemini.librarymanagement.db.DbStore1;
import com.capgemini.librarymanagement.dto.BookInfo;
import com.capgemini.librarymanagement.dto.UserInfoBean;
import com.capgemini.librarymanagement.exception.BookGenericException;
import com.capgemini.librarymanagement.exception.UserGenericException;
import com.capgemini.librarymanagement.service.AdminBookService;
import com.capgemini.librarymanagement.service.AdminBookServiceImpl;
import com.capgemini.librarymanagement.service.UserService;
import com.capgemini.librarymanagement.service.UserServiceImpl;
import com.capgemini.librarymanagement.validation.LibraryManageValidation;

public class LibraryManagementController {

	@SuppressWarnings("unused")
	private static final Object userPassword = null;
	public static int count = 0;
	static Logger log =Logger.getLogger(LibraryManagementController.class);
	Scanner scanner = new Scanner(System.in);
	AdminBookService adminBookService = new AdminBookServiceImpl();
	UserService userService = new UserServiceImpl();


	public void admin() {

		log.info(" Admin Successfull login");
		while (true) {
			log.info("-------------------------");
			log.info("Enter your choice");
			log.info("1.Add Book");
			log.info("2.Add User");
			log.info("3.Delete Book");
			log.info("4.Delete User");
			log.info("5.Show All Users");
			log.info("6.Show All Books");
			log.info("7.Update User Details");
			log.info("8.Logout");
			log.info("-------------------------");

			String choice = scanner.nextLine();
			if (!LibraryManageValidation.isParsableInt(choice)) {
				choice = "11";
			}
			
			switch (Integer.parseInt(choice)) {
			case 1:
				log.info("Enter book id: ");
				String bookId = scanner.nextLine().trim();
				while(!LibraryManageValidation.isParsableInt(bookId)) {
					 log.info("Invalid book id! Enter valid book id: ");
						log.info("Enter book id: "); 
					 bookId = scanner.nextLine().trim();
				}

				log.info("Enter name of book: ");
				String bookName = scanner.nextLine().trim();
				while(!LibraryManageValidation.isStringAlphabet(bookName)) {
					log.info("Please enter Valid Book Name");
					log.info("Enter name of book: ");
					bookName= scanner.nextLine().trim();
				}

				log.info("Enter author name: ");
				String bookAuth = scanner.nextLine().trim();
				while(!LibraryManageValidation.isStringAlphabet(bookAuth)) {
					log.info("Please enter Valid Name");
					log.info("Enter author name: ");
					bookAuth= scanner.nextLine().trim();
				}

				log.info("Enter no of books: ");
				String bookNum = scanner.nextLine().trim();
				while(!LibraryManageValidation.isParsableInt(bookNum)) {
					log.info("Invalid no of books! Enter valid no of books: "); 
					log.info("Enter no of books: ");
					bookNum = scanner.nextLine().trim();
				}

				log.info("Enter publisher name: ");
				String pubName = scanner.nextLine().trim();
				while(!LibraryManageValidation.isStringAlphabet(pubName)) {
					log.info("Please enter Valid Name");
					log.info("Enter publisher name: ");
					pubName= scanner.nextLine().trim();
				}

				LibraryManageValidation validation = new LibraryManageValidation();
				if (validation.bookValidation(bookId, bookName, bookAuth, bookNum, pubName)) {
					BookInfo bookInfo = new BookInfo();
					bookInfo.setBookId(bookId);
					bookInfo.setBookName(bookName);
					bookInfo.setBookAuthor(bookAuth);

					bookInfo.setNoOfBooks(bookNum);
					bookInfo.setPublisher(pubName);

					if (adminBookService.addBook(bookInfo)) {
						log.info("Books added successfully with " + bookNum + "copy");
					}
				}

				break;
			case 2:
				log.info("Enter UserId: ");
				String usrId = scanner.nextLine().trim();
				while(!LibraryManageValidation.isParsableInt(usrId)) {
					log.info("Invalid userId!");
					log.info("Enter UserId: ");
					usrId=scanner.nextLine().trim();
				}

				log.info("Enter UserName: ");
				String usrName = scanner.nextLine().trim();
				while(!LibraryManageValidation.isStringAlphabet(usrName)) {
					log.info("Please enter Valid Name");
					log.info("Enter UserName: ");
					usrName= scanner.nextLine().trim();
				}

				log.info("Enter Email: ");
				String usrEmail = scanner.nextLine().trim();
				while(!LibraryManageValidation.validEmail(usrEmail)) {
					log.info("please enter valid E-mail");
					log.info("Enter Email: ");
					usrEmail = scanner.nextLine().trim();
				}

				log.info("Enter Password:");
				String usrPassword = scanner.nextLine().trim();
				while(!LibraryManageValidation.validPassword(usrPassword)) {
					log.info("please Enter between 8-12 Character's");
					log.info("It must contain Alphabet,Special Character,Number..!");
					log.info("Enter Password: ");
					usrPassword = scanner.nextLine().trim();
				}
				
				

				UserInfoBean userInfoBean = new UserInfoBean();
				LibraryManageValidation userValidation = new LibraryManageValidation();
				 
				for ( UserInfoBean users: DbStore1.userInfoBean) {
					if (users.getUsrEmail().equalsIgnoreCase(usrEmail) || users.getUsrId().equalsIgnoreCase(usrId) ) {
						count++;
					}
					
				}
				if (count==0) {
					count=0;
					
					if (userValidation.userValidation(usrId, usrName, usrEmail, usrPassword)) {
						userInfoBean.setUsrId(usrId);
						userInfoBean.setUsrName(usrName);
						userInfoBean.setUsrEmail(usrEmail);
						userInfoBean.setUsrPassword(usrPassword);
						if (adminBookService.addUser(userInfoBean)) {
							log.info("added Successfully");
						} else {
							log.info("user  not added");
						}

					}
				}else {
					
					log.info("user is already Exist");
					count=0;
				}
				


				break;
			case 3:

				log.info("enter the Book id for delete");
				String bookId1 = scanner.nextLine();

				LibraryManageValidation bookIdValidation = new LibraryManageValidation();

				if (bookIdValidation.bookIdValidation(bookId1)) {
					if (adminBookService.deleteBook(bookId1)) {
						log.info("Deleted Successfully");
					} else {
						log.info("Book Id not found");
					}

				} else {
					try {
						throw new BookGenericException("Invalid Book Id");
					} catch (BookGenericException e) {
						log.info(e.getMessage());
					}

				}

				break;
			case 4:
				log.info("enter the user id for delete");
				String userId = scanner.nextLine();
				LibraryManageValidation userIdValidation = new LibraryManageValidation();

				if (userIdValidation.userIdValidation(userId)) {
					if (adminBookService.deleteUser(userId)) {
						log.info("Deleted Successfully");
					} else {
						log.info("User Id not found");
					}
				} else {
					try {
						throw new UserGenericException("User Id is Invalid");
					} catch (UserGenericException e) {
						log.info(e.getMessage());
					}

				}
				break;
			case 5:
				log.info("---User Details---");
				List<UserInfoBean> list1 = adminBookService.showAllUser();
				if (!list1.isEmpty()) {
					for (UserInfoBean users : list1) {
						log.info(
								"User Id=" + users.getUsrId() + "\t User Name=" + users.getUsrName() + "\t User Email="
										+ users.getUsrEmail() + "\t User Password=" + users.getUsrPassword());
					}
				} else {
					log.info("No Users to show");
				}
				break;
			case 6:
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
			case 7:
				UserInfoBean bean = new UserInfoBean();
				log.info("Enter User Id to Update");
				bean.setUsrId(scanner.nextLine());

				log.info("Enter User Name to Update");
				bean.setUsrName(scanner.nextLine().trim());

				log.info("Enter User Email to Update");
				bean.setUsrEmail(scanner.nextLine().trim());

				log.info("Enter User Passsword to Upadte");
				bean.setUsrPassword(scanner.nextLine().trim());

				LibraryManageValidation userValidatin = new LibraryManageValidation();
				if (userValidatin.userValidation(bean.getUsrId(), bean.getUsrName(), bean.getUsrEmail(),
						bean.getUsrPassword())) {
					if (adminBookService.updateUser(bean) != null) {
						log.info("Updated Successfully!!!");

					} else {
						log.info("Failed to Update");
					}

				} else {
					try {
						throw new UserGenericException("Invalid User Details");
					} catch (UserGenericException e) {
						log.info(e.getMessage());
					}

				}

				break;
			
			case 8:
				log.info("Admin Logout Successfull");
				LibraryMainPage.mainPage();
				System.exit(0);

			default:
				log.info("Wrong Choice!");
			}
		}
	}

}
