package book.model.dao;

import static book.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import book.model.vo.Book;
public class BookDAO {
	
	// 도서 목록 전체 조회
	public List<Book> bookSelectAll(Connection conn) {
		String query = "select * from book";
		Statement stmt = null;
		ResultSet rs = null;
		List<Book> bookList = new ArrayList<>(); // 책 전체정보 담기 위한 컬렉션
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				int bookid = rs.getInt("book_id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				String publisherDate = rs.getString("publisher_date");
				int price = rs.getInt("price");
				
				Book book = new Book(bookid,title,author,publisher,publisherDate,price);
				bookList.add(book);
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		return bookList;
	}
	// 도서 추가
	public int bookInsert(Connection conn , Book b) {
		String query = "INSERT INTO BOOK "
			     + "VALUES(customer_seq.nextval, ?, ?, ?, TO_DATE(?, 'RRRR/MM/DD'), ?)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getAuthor());
			pstmt.setString(3, b.getPublisher());
			pstmt.setString(4, b.getPublisherDate());
			pstmt.setInt(5, b.getPrice());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	// 도서 삭제
	public int bookDelete(Connection conn, int bookid) {
		String query = "delete from book where book_id = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookid);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	// 2. 도서 정보 수정
	public int bookUpdate(Connection conn , Book book) {
		String query = "update book set title =? , author =? , publisher =? , publisher_date = "
				+ "to_date(?,'RRRR/MM/DD'), price = ? "+"where book_id=?";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1,book.getTitle());
				pstmt.setString(2, book.getAuthor());
				pstmt.setString(3,book.getPublisher());
				pstmt.setString(4, book.getPublisherDate());
				pstmt.setInt(5, book.getPrice());
				pstmt.setInt(6, book.getBookid());
			
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace(); 
		} finally {
			close(pstmt);
		}
		return result;
	}
	// 4. 도서 아이디로 조회
	public Book bookSelectId(Connection conn, int bookId) {
		String query = "select * from book where book_id = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Book book = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				book = new Book(rs.getInt("book_id"),
						rs.getString("title"),
						rs.getString("author"),
						rs.getString("publisher"),
						rs.getString("publisher_date"),
						rs.getInt("price"));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return book;
	}
	// 5.도서 제목으로 조회
	public List<Book> bookSelectTitle(Connection conn, String bookTitle) {
		String query ="select * from book where title like ( '%' || ? || '%')";
		
		PreparedStatement pstmt = null;
		ResultSet rs=  null;
		List<Book> listBook = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookTitle);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Book b = new Book();
				b.setBookid(rs.getInt("book_id"));
				b.setTitle(rs.getString("title"));
				b.setAuthor(rs.getString("author"));
				b.setPublisher(rs.getString("publiser"));
				b.setPublisherDate("publisher_date");
				b.setPrice(rs.getInt("price"));
				
				listBook.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return listBook;
	}
}
