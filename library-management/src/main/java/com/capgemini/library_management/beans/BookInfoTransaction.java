package com.capgemini.library_management.beans;

public class BookInfoTransaction {
	private int bookTransactionId;
	private String bookIssueDate;
	private int bookRegistrationId;
	private String bookReturnDate;
	private double fine;

	public int getBookTransactionId() {
		return bookTransactionId;
	}

	public void setBookTransactionId(int bookTransactionId) {
		this.bookTransactionId = bookTransactionId;
	}

	public String getBookIssueDate() {
		return bookIssueDate;
	}

	public void setBookIssueDate(String bookIssueDate) {
		this.bookIssueDate = bookIssueDate;
	}

	public int getBookRegistrationId() {
		return bookRegistrationId;
	}

	public void setBookRegistrationId(int bookRegistrationId) {
		this.bookRegistrationId = bookRegistrationId;
	}

	public String getBookReturnDate() {
		return bookReturnDate;
	}

	public void setBookReturnDate(String bookReturnDate) {
		this.bookReturnDate = bookReturnDate;
	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}

}
