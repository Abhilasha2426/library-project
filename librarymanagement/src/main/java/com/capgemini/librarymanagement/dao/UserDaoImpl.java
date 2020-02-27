package com.capgemini.librarymanagement.dao;

import java.util.HashMap;

import com.capgemini.librarymanagement.bean.BookInfoTransaction;
import com.capgemini.librarymanagement.exception.BookException;

public class UserDaoImpl implements UserDao{
	public  static HashMap<Integer, BookInfoTransaction> h1 = new HashMap<Integer, BookInfoTransaction>();

	public HashMap<Integer, BookInfoTransaction> getAllTransanction() {
		if (h1.isEmpty() != true) {
			return h1;
		} else {
			return null;
		}
	}

	public boolean updateBookTransaction(int bookTransactionId, BookInfoTransaction book) {
		if (h1.replace(bookTransactionId, book) != null) {
			return true;
		} else {
			throw new BookException("Book transaction Failed, Problem in updating try again..!");
		}
	}

	public boolean deleteBookTransaction(int bookTransactionId) {
		if (h1.remove(bookTransactionId) != null) {
			return true;
		} else {
			throw new BookException("Book transaction Failed!,Problem in deleting the trancsaction");
		}
	}

	public boolean addBookTransaction(BookInfoTransaction books) {
		while (true) {
			int bookTransactionId=0;
			++bookTransactionId;

			books.setBookRegistrationId(bookTransactionId);
			try {
				h1.put(bookTransactionId, books);
				return true;
			} catch (Exception e) {
				throw new BookException("Duplicate TransactionId, please try again..!");
			}
		}
	}

	public BookInfoTransaction searchBook(int bookId) {
		if (h1.containsKey(bookId) == true) {
			return h1.get(bookId);
		} else {
			System.err.println("No such transaction Exist..!");
			return null;
		}
	}




}
