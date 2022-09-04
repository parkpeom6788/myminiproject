package book.view;

import java.util.Scanner;

import book.controller.BookController;
import book.model.vo.Book;
public class BookMenu {
	Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();
	public void displayBookMenu() {
		/*1. 도서 추가
		 * 2. 도서 정보 수정
		 * 3. 도서 삭제
		 * 4. 도서 아이디로 조회
		 * 5. 도서 제목으로 조회
		 * 6. 도서 목록 전체 조회
		 * 9. 끝내기
		 */
		while(true) {
			System.out.println("== 도서 관리 프로그램 ==");
			System.out.println("1. 도서 추가");
			System.out.println("2. 도서 정보 수정");
			System.out.println("3. 도서 삭제");
			System.out.println("4. 도서 아이디로 조회");
			System.out.println("5. 도서 제목으로 조회");
			System.out.println("6. 도서 목록 전체 조회");
			System.out.println("9. 끝내기");
			System.out.println("=======================");
			System.out.print("번호 입력 : ");
			int num = sc.nextInt();
			sc.nextLine();
			
			switch(num) {
			case 1:
				bc.bookinsert(bookAdd());
				break;
			case 2:
				bc.bookUpdate(bookId(), bookAdd());
				break;
			case 3:
				bc.bookDelete(bookId());
				break;
			case 4:
				bc.bookSelectId(bookId());
				break;
			case 5:
				bc.bookSelectTitle(bookTitle());
				break;
			case 6:
				bc.bookSelectAll();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default :
				System.out.println("번호를 다시 입력해주세요.");
			}
		}
	}
	
	// 1. 도서 정보 추가
	public Book bookAdd() {
		System.out.println("=== 도서 추가 , 수정 ===");
		System.out.print("도서명 : ");
		String title = sc.nextLine();
		System.out.print("작가명 : ");
		String author = sc.nextLine();
		System.out.print("출판사 : ");
		String publisher = sc.nextLine();
		System.out.print("출판일(19900101 양식으로 입력)  : ");
		String publisherDate = sc.nextLine();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		Book book = new Book(title,author,publisher,publisherDate,price);
		return book;
	}
	// 4. 도시 정보(아이디)
	public int bookId() {
		System.out.print("도서 번호 입력 : ");
		return Integer.parseInt(sc.nextLine());
	}
	// 5. 도서 정보(아이디)
	public String bookTitle() {
		System.out.print("도서 제목 입력 : ");
		return sc.nextLine();
	}
}
