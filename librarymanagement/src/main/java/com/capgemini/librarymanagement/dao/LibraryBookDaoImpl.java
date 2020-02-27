package com.capgemini.librarymanagement.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.librarymanagement.bean.BookInfo;
import com.capgemini.librarymanagement.bean.UserInfoBean;
import com.capgemini.librarymanagement.db.DbStore;
import com.capgemini.librarymanagement.db.DbUser;

public class LibraryBookDaoImpl implements LibraryBookDao{
	private static HashMap<Integer, UserInfoBean> h1 = new HashMap<Integer, UserInfoBean>();
	static int userId = 0;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean addBook(BookInfo bookInfo, LinkedList ll) {
		boolean isAdded = false;
		LinkedList ll1 = null;
		if (bookInfo != null) {
			ll1 = new LinkedList();
			ll1.add(bookInfo.getBookId());
			for (int i = 0; i < ll.size(); i++) {
				ll1.add(ll.get(i));
			}
			//ll.add(medicineInfoBean.getPrice());
			//ll.add(medicineInfoBean.getTabName());

			if (DbStore.bookDb(ll1)) {
				System.out.println("Book Id "+DbStore.temp1); 
				//System.out.println(" Added");
				isAdded = true;
			}

		}

		return isAdded;
	}

	@Override
	public boolean deleteBook(int id) {
		boolean isDeleted= false;

		if(DbStore.bDb.containsKey(id)) {

			System.out.println("Deleted elemet is "+DbStore.bDb.remove(id));
			isDeleted=true;
		}
		else {
			System.out.println(id + " Book Not Matched ");
		}


		return isDeleted;
		
	}

	public boolean deleteUser(int usrId) {
		boolean isDeleted= false;

		if(DbStore.bDb.containsKey(usrId)) {

			System.out.println("Deleted elemet is "+DbStore.bDb.remove(usrId));
			isDeleted=true;
		}
		else {
			System.out.println(usrId + " User Not Matched ");
		}

		
		return isDeleted;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean addUser(UserInfoBean userInfoBean, LinkedList li) {
		boolean isAdded = false;
		LinkedList ll1 = null;
		if (userInfoBean != null) {
			ll1 = new LinkedList();
			ll1.add(userInfoBean.getUsrId());
			for (int i = 0; i < li.size(); i++) {
				ll1.add(li.get(i));
			}
			//ll.add(medicineInfoBean.getPrice());
			//ll.add(medicineInfoBean.getTabName());

			if (DbStore.bookDb(ll1)) {
				System.out.println("Book Id "+DbStore.temp1); 
				//System.out.println(" Added");
				isAdded = true;
			}

		}

		return isAdded;
	}

	@Override
	public void showAllUser() {
		
			if(h1.isEmpty()==false) {
				System.out.println(" USER'S DETAILS");
				Set<Integer> s=h1.keySet();
				for (Integer key : s) {
					UserInfoBean userInfoBean=h1.get(key);
					System.out.println("User-ID: "+key);
					System.out.println(userInfoBean);
				}
			}else {
				System.err.println("Currently there is no user..");
			}
		}
		
	}

	
	


