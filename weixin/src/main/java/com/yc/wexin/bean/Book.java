package com.yc.wexin.bean;

public class Book {
	private Integer id;
	private String bookName;
	private String bookDir;

	public Book(Integer id, String bookName, String bookDir) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.bookDir = bookDir;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookDir() {
		return bookDir;
	}

	public void setBookDir(String bookDir) {
		this.bookDir = bookDir;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", bookDir=" + bookDir + "]";
	}

}
