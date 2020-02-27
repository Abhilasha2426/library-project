package com.capgemini.library_management.factory;

import com.capgemini.library_management.dao.LibraryBookDao;
import com.capgemini.library_management.dao.LibraryBookDaoImpl;
import com.capgemini.library_management.service.LibraryBookService;
import com.capgemini.library_management.service.LibraryBookServiceImpl;

public class LibraryManagementBookFactory {
	public LibraryManagementBookFactory() {

	}

	public static LibraryBookDao objLibraryDao() {
		LibraryBookDao dao1 = new LibraryBookDaoImpl();
		return dao1;

	}

	public static LibraryBookService objLibraryService() {
		LibraryBookService service = new LibraryBookServiceImpl();
		return service;

	}

}
