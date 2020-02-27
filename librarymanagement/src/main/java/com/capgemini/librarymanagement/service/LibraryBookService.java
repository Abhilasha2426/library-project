package com.capgemini.librarymanagement.service;

import java.util.LinkedList;

import com.capgemini.librarymanagement.bean.BookInfo;
import com.capgemini.librarymanagement.bean.UserInfoBean;

public interface LibraryBookService {

	/*boolean signUp(UserInfoBean userInfoBean); 
	boolean userAuthenticate(int id ,String password);*/
	boolean addBook(BookInfo bookInfo, LinkedList ll );
	boolean deleteBook(int id);
}
