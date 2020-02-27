package com.capgemini.librarymanagement.service;

import java.util.HashMap;

import com.capgemini.librarymanagement.bean.BookInfoTransaction;
import com.capgemini.librarymanagement.dao.UserDao;

public class UserServiceImpl implements UserService{
	private UserDao dao;

	@Override
	public HashMap<Integer, BookInfoTransaction> getAllTransanction() {
		return dao.getAllTransanction();
	}

	@Override
	public boolean updateBookTransaction(int bookTransactionId, BookInfoTransaction books) {
		return dao.updateBookTransaction(bookTransactionId, books);
	}

	@Override
	public boolean deleteBookTransaction(int bookTransactionId) {
		return dao.deleteBookTransaction(bookTransactionId);
	}

	@Override
	public boolean addBookTransaction(BookInfoTransaction books) {
		return dao.addBookTransaction(books);
	}

	@Override
	public BookInfoTransaction searchBook(int bookId) {
		return dao.searchBook(bookId);
	}

}
