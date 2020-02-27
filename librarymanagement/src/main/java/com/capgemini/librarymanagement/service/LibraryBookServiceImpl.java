package com.capgemini.librarymanagement.service;

import java.util.LinkedList;

import com.capgemini.librarymanagement.bean.BookInfo;
import com.capgemini.librarymanagement.bean.UserInfoBean;
import com.capgemini.librarymanagement.dao.LibraryBookDao;

public class LibraryBookServiceImpl implements LibraryBookService {

	private LibraryBookDao dao;

	@Override
	public boolean addBook(BookInfo bookInfo, LinkedList ll) {
		return dao.addBook(bookInfo, ll);
	}

	@Override
	public boolean deleteBook(int id) {
		return dao.deleteBook(id);
	}
}
