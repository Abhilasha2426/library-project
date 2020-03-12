package com.capgemini.librarymanagement.dao;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import com.capgemini.librarymanagement.db.DbStore1;
import com.capgemini.librarymanagement.dto.BookInfo;
import com.capgemini.librarymanagement.dto.BookUserRel;
import com.capgemini.librarymanagement.dto.UserBookDetail;
import com.capgemini.librarymanagement.validation.LibraryManageValidation;

public class UserDAOImpl implements UserDAO {

	static int count = 0;

	public BookInfo searchBookWithName(String name) {
		for (BookInfo book : DbStore1.bookInfo) {
			String bookName = book.getBookName().toLowerCase();
			String bookAuthor = book.getBookAuthor().toLowerCase();
			String searchName = name.toLowerCase();
			if (bookName.startsWith(searchName) || bookAuthor.startsWith(searchName)) {
				return book;
			}
		}
		return null;
	}

	public boolean requestCheck(BookInfo book) {
		UserBookDetail bookDetail = new UserBookDetail();
		bookDetail.setBookId(book.getBookId());
		bookDetail.setCount(1);
		bookDetail.setUserId(DbStore1.user.get(0).getUsrId());
		DbStore1.userBookDetails.add(bookDetail);

		for (UserBookDetail bookDetailReq : DbStore1.userBookDetails) {
			System.out.println("Book Id:" + bookDetailReq.getBookId());
			System.out.println("User Id:" + bookDetailReq.getUserId());
		}
		return true;
	}

	public boolean bookReturn(String date) {
		LibraryManageValidation validation = new LibraryManageValidation();
		if (validation.dateValidation(date)) {
			BookUserRel userRel = new BookUserRel();
			List<UserBookDetail> bookList = new LinkedList<UserBookDetail>();
			for (BookUserRel relation : DbStore1.userBorrowedBook) {
				try {
					userRel.setReturnDate(new SimpleDateFormat("dd-MM-yyyy").parse(date));

				} catch (ParseException e) {
					System.err.println(e.getMessage());
				}
				userRel.setUserInfoBean(relation.getUserInfoBean());
				bookList.addAll(relation.getBook());
			}
			DbStore1.userReturnBooks.add(userRel);

			return true;
		} else {
			System.err.println("Please enter the date in this form dd-mm-yyyy");
			return false;
		}

	}

}
