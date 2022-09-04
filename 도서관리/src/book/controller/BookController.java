package book.controller;

import java.util.List;

import book.model.service.BookService;
import book.model.vo.Book;
import book.view.BookView;

public class BookController {
	private BookService bs = new BookService();
	private BookView bv = new BookView();
	
	// 1. 도서 추가
	public void bookinsert(Book bookAdd) {
		int result = bs.bookInsert(bookAdd);
		if(result > 0) {
			System.out.println("도서 정보 추가 완료");
		} else {
			bv.bookErrorMsg("insert");
		}
	}
	// 6. 목록 전체 조회
	public void bookSelectAll() {
		List<Book> bookList = bs.bookSelectAll();
		if(bookList.isEmpty()) {
			System.out.println("조회 정보가 없습니다.");
		} else {
			bv.bookSelectView(bookList);
		}
	}
	public void bookDelete(int bookId) {
		int result = bs.bookDelete(bookId);
		if(result > 0) {
			System.out.println("도서 정보 삭제 완료");
		} else {
			bv.bookErrorMsg("delete");
		}
	}
	public void bookUpdate(int bookId,Book b) {
		Book book = b;
		book.setBookid(bookId);
		int result = bs.bookUpdate(book);
		if(result > 0) {
			System.out.println("도서 정보 수정 완료");
		} else {
			bv.bookErrorMsg("update");
		}
	}
	public void bookSelectId(int bookId) {
		Book book = bs.bookSelectId(bookId);
		
		if(book == null) {
			bv.bookErrorMsg("bookId");
		} else {
			bv.bookSelecteId(book);
		}
	}
	
	public void bookSelectTitle(String bookTitle) {
		List<Book> bookList = bs.bookSelectTitle(bookTitle);
		if(bookList.isEmpty()) {
			System.out.println("조회 정보가 없습니다.");
		} else {
			bv.bookSelectView(bookList);
		}
	}
}