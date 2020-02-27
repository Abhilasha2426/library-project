package com.capgemini.library_management.dao;

import java.util.LinkedList;


import com.capgemini.library_management.beans.BookInfo;

import com.capgemini.library_management.db.DbStore;

public class LibraryBookDaoImpl implements LibraryBookDao{

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean addBook(BookInfo bookInfo, LinkedList li) {
		@SuppressWarnings("unused")
		boolean isAdded =false;
		LinkedList ll=null;
		if(bookInfo != null) {
			ll=new LinkedList();
			ll.add(bookInfo.getBookName());
			for(int i=0; i< li.size();i++) {
				ll.add(li.get(i));
			}
			if(DbStore.bookDb(ll)){
				System.out.println("Book Id"+ DbStore.temp1);
				isAdded=true;
			}
		}
		return false;
	}

	public boolean addUser(int id) {
		return false;
	}

	public boolean deleteBook(int id) {
		return false;
	}

	public boolean replaceBook(int id) {
		return false;
	}

	public boolean deleteUser(int id) {
		return false;
	}

	

	

}
