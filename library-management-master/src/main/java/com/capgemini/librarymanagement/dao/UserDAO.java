package com.capgemini.librarymanagement.dao;

import com.capgemini.librarymanagement.dto.BookInfo;

public interface UserDAO {
	
	public BookInfo searchBookWithName(String name);
	public boolean requestCheck(BookInfo bookInfo);
	public boolean bookReturn(String date);
}
