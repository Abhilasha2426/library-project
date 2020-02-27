package com.capgemini.librarymanagement.dao;

import java.util.LinkedList;

import com.capgemini.librarymanagement.bean.BookInfo;
import com.capgemini.librarymanagement.bean.UserInfoBean;

public interface LibraryBookDao {
//	boolean signUp(UserInfoBean userInfoBean); 
//	boolean userAuthenticate(int id ,String password);
	
	boolean addBook(BookInfo bookInfo, LinkedList ll );
	boolean addUser(UserInfoBean userInfoBean, LinkedList li);
	boolean deleteBook(int id);
	boolean deleteUser(int usrId);
	public void showAllUser();
	
	
	
	
	
	

}
