package com.capgemini.librarymanagement.factory;

import com.capgemini.librarymanagement.dao.BookInfoTransactionDao;
import com.capgemini.librarymanagement.dao.BookInfoTransactionDaoImpl;
import com.capgemini.librarymanagement.dao.LibraryBookDao;
import com.capgemini.librarymanagement.dao.LibraryBookDaoImpl;
import com.capgemini.librarymanagement.dao.UserDao;
import com.capgemini.librarymanagement.dao.UserDaoImpl;
import com.capgemini.librarymanagement.service.BookInfoTransactionService;
import com.capgemini.librarymanagement.service.BookInfoTransactionServiceImpl;
import com.capgemini.librarymanagement.service.LibraryBookService;
import com.capgemini.librarymanagement.service.LibraryBookServiceImpl;
import com.capgemini.librarymanagement.service.UserService;
import com.capgemini.librarymanagement.service.UserServiceImpl;

public class LibraryManagementBookFactory {
	public LibraryManagementBookFactory() {

	}

	public static LibraryBookDao objLibraryDao() {
		LibraryBookDao dao1 = new LibraryBookDaoImpl();
		return dao1;

	}

	public static LibraryBookService objLibraryService() {
		LibraryBookService service = new LibraryBookServiceImpl();
		return service;

	}
	
	public static UserDao objectUserDao() {
		UserDao user = new UserDaoImpl();
		return user;
	}
	
	public static UserService objectUserServ() {
		UserService userService = new UserServiceImpl();
		return userService;
	}
	
	public static LibraryBookDao objectBookDao() {
		LibraryBookDao libraryBookDao = new LibraryBookDaoImpl();
		return libraryBookDao;
	}
	
	public static LibraryBookService objectBookServ() {
		LibraryBookService serv = new LibraryBookServiceImpl();
		return serv;
	}
	
	public static BookInfoTransactionDao objectBookTransactionDao() {
		BookInfoTransactionDao bt = new BookInfoTransactionDaoImpl();
		return bt;
	}
	
	public static BookInfoTransactionService objectBookTransactionServ() {
		BookInfoTransactionService btran = new BookInfoTransactionServiceImpl();
		return btran;
	}

}
