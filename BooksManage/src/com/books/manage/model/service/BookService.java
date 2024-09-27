package com.books.manage.model.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import com.books.manage.model.dto.Book;

public class BookService {
	Scanner sc = new Scanner(System.in);
	List<Book> bookList = new ArrayList<Book>();
	
	public BookService() {
		bookList.add(new Book(1111, "세노이의 가르침", "세이노", 6480, "데이원", true, 3, "2024-09-01", "2024-09-08"));
		bookList.add(new Book(2222, "문과남자의 과학공부", "유시민", 15750, "돌배개", true, 1, "2024-09-09", "2024-09-16"));
		bookList.add(new Book(3333, "역행자", "자청", 17550, "웅진지식하우스", false, 0, null, null));
		bookList.add(new Book(4444, "꿀벌의 예언", "베르나르 베르베르", 15120, "열린책들", false, 0, null, null));
		bookList.add(new Book(5555, "도둑맞은 집중력", "요한 하리", 16920, "어크로스", false, 0, null, null));
		bookList.add(new Book(6666, "노인과 바다", "어니스트 해밍웨이", 18000, "민음사", false, 0, null, null));
	}
	
	public void displayMenu() {
		int input = 0;
		
		do {
			System.out.println("=======도서관리 메뉴=======");
			System.out.println("1. 도서 등록");
			System.out.println("2. 도서 조회");
			System.out.println("3. 도서 수정");
			System.out.println("4. 도서 삭제");
			System.out.println("5. 도서 대여");
			System.out.println("6. 도서 반납");
			System.out.println("7. 대여 도서 조회");
			System.out.println("8. 미 반납 도서 조회");
			System.out.println("9. 도서 대여 횟수 조회");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 선택 : ");
			input = sc.nextInt();
			
			switch(input) {
			case 1 : addBook(); break;
			case 2 : displayBooks(); break;
			case 3 : editBook(); break;
			case 4 : delBook(); break;
			case 5 : rentBook(); break;
			case 6 : returnBook(); break;
			case 7 : displayRentBooks(); break;
			case 8 : displayNotReturnBooks(); break;
			case 9 : displayRentCountBooks(); break;
			case 0 : System.out.println("프로그램을 종료합니다.."); break;
			}
			
		} while(input != 0);
	}
	
	public void addBook() {
		System.out.print("도서 번호 : ");
		int bookNum = sc.nextInt();
		sc.nextLine(); // 개행문자 처리를 위함
		
		boolean flag = false;
		for(Book book : bookList) {
			if(book.getBookNum() == bookNum) {
				flag = true;
				break;
			}
		}
		
		if(flag) {
			System.out.println("입력하신 도서번호는 등록되어 있습니다.");
			return;
		}
		
		System.out.print("도서 제목 : ");
		String name = sc.nextLine();
		
		System.out.print("도서 저자 : ");
		String writer = sc.nextLine();
		
		System.out.print("도서 가격 : ");
		int price = sc.nextInt();
		sc.nextLine(); // 개행문자 처리를 위함
		
		System.out.print("출판사 : ");
		String publisher = sc.nextLine();
		
		bookList.add(new Book(bookNum, name, writer, price, publisher, false, 0, null, null));
		
		System.out.println("도서가 등록되었습니다.");
	}
	
	public void displayBooks() {
		int count = 1;
		for(Book book : bookList) {
			System.out.println(count + ". " + book);
			count++;
		}
	}
	
	public void editBook() {
		System.out.print("도서 번호 : ");
		int bookNum = sc.nextInt();
		boolean flag = false; // 도서번호 존재 여부
		
		for(Book book : bookList) {
			if(book.getBookNum() == bookNum) {
				if(book.isRentYn() == true) {
					System.out.println("대여중인 책은 수정할 수 없습니다.");
					return;
				} else {
					System.out.println("1. 도서 제목");
					System.out.println("2. 도서 저자");
					System.out.println("3. 도서 가격");
					System.out.println("4. 출판사");
					System.out.print("번호 입력 : ");
					int input = sc.nextInt();
					sc.nextLine(); // 개행문자 처리를 위함
					
					switch(input) {
					case 1 : 
						System.out.print("도서 제목 : ");
						String name = sc.nextLine();
						book.setName(name);
						break;
					case 2 : 
						System.out.print("도서 저자 : ");
						String writer = sc.nextLine();
						book.setWriter(writer);
						break;
					case 3 : 
						System.out.print("도서 가격 : ");
						int price = sc.nextInt();
						book.setPrice(price);
						break;
					case 4 : 
						System.out.print("출판사 : ");
						String publisher = sc.nextLine();
						book.setPublisher(publisher);
						break;
					default : 
						System.out.println("알맞은 번호를 입력해주세요..");
						break;	
					}
					flag = true;
					break;
				}
			}
		}
		
		if(flag) {
			System.out.println("도서정보를 수정하였습니다.");
		} else {
			System.out.println("입력하신 도서번호는 존재하지 않습니다.");
		}
	}
	
	public void delBook() {
		System.out.print("삭제 도서번호 : ");
		int bookNum = sc.nextInt();
		boolean flag = true; // 삭제할 도서 존재 여부
		
		for(Book book : bookList) {
			if(book.getBookNum() == bookNum) {
				Book temp = bookList.remove(bookList.lastIndexOf(book));
				System.out.println(temp.getBookNum() + "번의 '" + temp.getName() + "'책이 삭제되었습니다.");
				flag = false;
				break;
			}
		}
		
		if(flag) {
			System.out.println("도서번호가 존재하지 않습니다..");
		}
	}
	
	public void rentBook() {
		System.out.print("대여 도서 번호 : ");
		int bookNum = sc.nextInt();
		boolean flag = true;
		
		for(Book book : bookList) {
			if(book.getBookNum() == bookNum) {
				int index = bookList.indexOf(book);
				
				bookList.get(index).setRentYn(true);
				
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String rentDate = sdf.format(date);
				bookList.get(index).setRentDate(rentDate);
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				cal.add(Calendar.DAY_OF_MONTH, 7);
				bookList.get(index).setReturnDate(sdf.format(cal.getTime()));
				
				bookList.get(index).setRentCount(bookList.get(index).getRentCount() + 1);
				
				flag = false;
				System.out.println("대여 처리를 완료 하였습니다..");
				break;
			}
		}
		
		if(flag) {
			System.out.println("도서 번호가 존재하지 않습니다..");
		}
	}
	
	public void returnBook() {
		System.out.print("반납 도서 번호 : ");
		int bookNum = sc.nextInt();
		boolean flag = true;
		
		for(Book book : bookList) {
			if(book.getBookNum() == bookNum) {
				int index = bookList.indexOf(book);
			
				bookList.get(index).setRentYn(false);
				bookList.get(index).setRentDate(null);
				bookList.get(index).setReturnDate(null);
				
				flag = false;
				System.out.println("반납 처리를 완료 하였습니다..");
				break;
			}
		}
		
		if(flag) {
			System.out.println("도서 번호가 존재하지 않습니다..");
		}
	}
	
	public void displayRentBooks() {
		for(Book book : bookList) {
			if(book.isRentYn() == true) {
				System.out.println(book);
			}
		}
	}
	
	public void displayNotReturnBooks() {
		for(Book book : bookList) {
			if(book.isRentYn() == true) {
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String curentDate = sdf.format(date);
				String returnDate = book.getReturnDate();
				
				Date from;
				try {
					from = sdf.parse(curentDate);
					Date to = sdf.parse(returnDate);
					
					int compare = from.compareTo(to); 
					
					if(compare > 0) { // 현재날짜가 반납일자보다 크다면 미반납 도서
						System.out.println(book);
					}

				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void displayRentCountBooks() {
		HashMap<String, Integer> bookMap = new HashMap<String, Integer>();
		
		for(Book book : bookList) {
			int rentCount = 0;
			for(int i = 0; i < bookList.size(); i++) { // 같은 도서 렌트 횟수 Map에 반영
				if(book.getName().equals(bookList.get(i).getName())) {
					rentCount += bookList.get(i).getRentCount();
				}
			}
			bookMap.put(book.getName(), rentCount);		
		}
		
		List<Integer> list = new ArrayList<Integer>(bookMap.values());
		
		Collections.sort(list);
		
		int count = 1;
		
		for( Entry<String, Integer> entry : bookMap.entrySet() ) {
			if(entry.getValue() > 0) {
				System.out.println(count + "위. 책 제목 : " + entry.getKey() + " / 대여횟수 : " + entry.getValue());
				count++;				
			}
		}
	}
		
	
}
