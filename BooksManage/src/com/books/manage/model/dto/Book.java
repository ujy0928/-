package com.books.manage.model.dto;

public class Book {
	private int bookNum; // 책번호
	private String name; // 책 이름
	private String writer; // 저자
	private int price; // 책 가격
	private String publisher; // 출판사
	private boolean rentYn; // 대여 여부
	private int rentCount; // 대여 횟수
	private String rentDate; // 대여 날짜
	private String returnDate; // 반납 날짜
	
	public Book() {}

	public Book(int bookNum, String name, String writer, int price, String publisher, boolean rentYn, int rentCount,
			String rentDate, String returnDate) {
		super();
		this.bookNum = bookNum;
		this.name = name;
		this.writer = writer;
		this.price = price;
		this.publisher = publisher;
		this.rentYn = rentYn;
		this.rentCount = rentCount;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
	}

	public int getBookNum() {
		return bookNum;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public boolean isRentYn() {
		return rentYn;
	}

	public void setRentYn(boolean rentYn) {
		this.rentYn = rentYn;
	}

	public int getRentCount() {
		return rentCount;
	}

	public void setRentCount(int rentCount) {
		this.rentCount = rentCount;
	}

	public String getRentDate() {
		return rentDate;
	}

	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return String.format("도서번호 : %d / 도서명 : %s / 저자 : %s / 책 가격 : %d원 / 출판사 : %s", 
				bookNum, name, writer, price, publisher);
	}
	
	
}
