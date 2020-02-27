package com.capgemini.librarymanagement.controller;

import java.util.LinkedList;
import java.util.Scanner;

import com.capgemini.librarymanagement.bean.BookInfo;
import com.capgemini.librarymanagement.bean.LibrarianInfoBean;
import com.capgemini.librarymanagement.bean.UserInfoBean;
import com.capgemini.librarymanagement.dao.BookInfoTransactionDao;
import com.capgemini.librarymanagement.dao.BookInfoTransactionDaoImpl;
import com.capgemini.librarymanagement.dao.LibraryBookDao;
import com.capgemini.librarymanagement.dao.LibraryBookDaoImpl;
import com.capgemini.librarymanagement.db.DbStore;
import com.capgemini.librarymanagement.factory.LibraryManagementBookFactory;
import com.capgemini.librarymanagement.service.BookInfoTransactionService;
import com.capgemini.librarymanagement.service.LibraryBookService;
import com.capgemini.librarymanagement.service.UserService;

public class LibraryManagementController {

	LibraryBookService lbs = LibraryManagementBookFactory.objLibraryService();

	LibraryBookDao libraryBookDao = new LibraryBookDaoImpl();
	Scanner sc = new Scanner(System.in);
	UserInfoBean userInfoBean = null;
	BookInfoTransactionDao bookInfoTransactionDao = new BookInfoTransactionDaoImpl();

	BookInfo bookInfo = null;

	@SuppressWarnings("rawtypes")
	public void admin() {
		while (true) {
			System.out.println(" Admin Successfull login");
			System.out.println("Enter your choice");
			System.out.println("1.Add Book");
			System.out.println("2.Add User");
			System.out.println("3.Replace Book");
			System.out.println("4.Delete Book");
			System.out.println("5.Delete User");
			System.out.println("6.Show All User");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter book id: ");
				int bookId = scanner.nextInt();
				System.out.println("Enter name of book");
				String bookName = scanner.next();
				System.out.println("Enter author name");
				String bookAuth = scanner.next();
				System.out.println("Enter Category");
				String category = scanner.next();
				System.out.println("Enter no of books");
				int bookNum = scanner.nextInt();
				System.out.println("Enter publisher name");
				String pubName = scanner.next();
				System.out.println(" Enter date");
				String date = scanner.next();
				System.out.println("Enter status");
				String status = scanner.next();
				LinkedList ll = new LinkedList();
				bookInfo = new BookInfo();
				bookInfo.setBookId(bookId);
				bookInfo.setBookName(bookName);
				bookInfo.setBookAuthor(bookAuth);
				bookInfo.setCategory(category);
				bookInfo.setNoOfBooks(bookNum);
				bookInfo.setPublisher(pubName);
				bookInfo.setDateAdded(date);
				bookInfo.setStatus(status);
				if (libraryBookDao.addBook(bookInfo, ll)) {
					System.out.println("Books added successfully with " + bookNum + "copy");
				}
				break;
			case 2:
				System.out.println("Enter UserId: ");
				int usrId = scanner.nextInt();
				System.out.println("Enter UserName:");
				String usrName = scanner.next();
				System.out.println("Enter Email: ");
				String usrEmail = scanner.next();
				System.out.println("Enter Password:");
				String usrPassword = scanner.next();
				LinkedList l2 = new LinkedList();
				userInfoBean = new UserInfoBean();
				userInfoBean.setUsrId(usrId);
				userInfoBean.setUsrName(usrName);
				userInfoBean.setUsrEmail(usrEmail);
				userInfoBean.setUsrPassword(usrPassword);
				if (libraryBookDao.addUser(userInfoBean, l2)) {
					System.out.println("Successfully Added the user");
				}
				break;
			case 3:
				System.out.println("Enter Book Id to Replace");
				int repId = sc.nextInt();
				if (DbStore.bDb.containsKey(repId)) {
					if (bookInfoTransactionDao.replaceBook(repId)) {
						System.out.println("Data Modifeid");
					} else {
						System.out.println("Not Modifeid");
					}
				} else {
					System.out.println("Entered Id not found!!");
				}

				break;

			case 4:
				/*
				 * // Scanner sc =new Scanner(System.in);
				 */ System.out.println("Enter Book Id to Delete");
				int id = sc.nextInt();
				if (libraryBookDao.deleteBook(id)) {

					System.out.println("Deleted successfully ");
				} else {
					System.out.println("Id Not found ");

				}

				break;
			case 5:
				System.out.println("Enter User Id to Delete");
				usrId = sc.nextInt();
				if (libraryBookDao.deleteUser(usrId)) {

					System.out.println("Deleted successfully ");
				} else {
					System.out.println("Id Not found ");

				}

				break;
			case 6:
				libraryBookDao.showAllUser();
				break;

			}

			/*
			 * default: System.out.println("Invalid Choice!!!!!!!!!"); System.exit(0);
			 */

		}
	}

	public static void user() {
		System.out.println("User login successfully");
		Scanner sc = new Scanner(System.in);
		UserService bean = LibraryManagementBookFactory.objectUserServ();
		LibraryBookService userv = LibraryManagementBookFactory.objectBookServ();
		// BookRegistrationServ breg =
		// LibraryManagementBookFactory.objectBookRegisterServ();
		BookInfoTransactionService serv = LibraryManagementBookFactory.objectBookTransactionServ();
		while (true) {
			System.out.println("Choose Any One");
			System.out.println("1. Add Book");
			System.out.println("2. Delete Book");
			System.out.println("3. Show All Available Books");
			System.out.println("4. Generate Book Fine");
			System.out.println("5. Admin Home");
			System.out.println("6. LogOut");
			
			
		}

	}

}
