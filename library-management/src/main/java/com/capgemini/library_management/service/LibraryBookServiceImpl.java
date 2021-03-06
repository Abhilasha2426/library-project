package com.capgemini.library_management.service;

import java.util.LinkedList;

import com.capgemini.library_management.beans.BookInfo;
import com.capgemini.library_management.dao.LibraryBookDao;

public class LibraryBookServiceImpl implements LibraryBookService {

	private LibraryBookDao dao;

	@SuppressWarnings("rawtypes")
	public boolean addBook(BookInfo bookInfo, LinkedList li) {
		return dao.addBook(bookInfo, li);
	}

	public boolean addUser(int id) {
		return dao.addUser(id);
	}

	public boolean deleteBook(int id) {
		return dao.deleteBook(id);
	}

	public boolean replaceBook(int id) {
		return dao.replaceBook(id);
	}

	public boolean deleteUser(int id) {
		return dao.deleteUser(id);
	}

	/*public boolean login() {
		return ((LibraryBookServiceImpl) dao).login();
	}
*/
}
