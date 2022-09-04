package book.model.vo;
public class Book {
	private int bookid; // 도서 번호
	private String title; // 도서명
	private String author; // 작가명
	private String publisher; // 출판사
	private String publisherDate; // 출판일 - String형식으로 받아 입력예정
	private int price;

	public Book() {
	}
	public Book(int bookid, String title, String author, String publisher, String publiisherDate, int price) {
		this.bookid = bookid;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.publisher = publiisherDate;
		this.price = price;
	}
	// 매개변수 생성자
	public Book(String title,String author, String publisher, String publisherDate, int price) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.publisherDate = publisherDate;
		this.price = price;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublisherDate() {
		return publisherDate;
	}
	public void setPublisherDate(String publisherDate) {
		this.publisherDate = publisherDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	// 북정보 
	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", publisherDate=" + publisherDate + ", price=" + price + "]";
	}
}
