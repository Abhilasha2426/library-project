package com.capgemini.librarymanagement.dao;

import java.util.HashMap;

import com.capgemini.librarymanagement.bean.BookInfoTransaction;

public interface UserDao {

	public HashMap<Integer, BookInfoTransaction> getAllTransanction();

	public boolean updateBookTransaction(int bookTransactionId, BookInfoTransaction books);

	public boolean deleteBookTransaction(int bookTransactionId);

	public boolean addBookTransaction(BookInfoTransaction books);

	public BookInfoTransaction searchBook(int bookId);

}
