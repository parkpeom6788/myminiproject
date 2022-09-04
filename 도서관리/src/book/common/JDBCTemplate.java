package book.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	// JDBC 기본설정값
	// 오라클 연결
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver"); // 클래스 로딩 
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
			conn.setAutoCommit(false); // 자동커밋설정 안하기
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	// 열린객체 닫기
		public static void close(ResultSet rset) {
			try {
				if(rset != null && !rset.isClosed()) {   // null 이 아닐 때와 isClosed 안닫혔을때 두가지 모두 조건 검사 
					rset.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		// PreparedStatement, Statement 둘다사용가능
		// 상속관계임, Statement 가 부모여서 다형성사용가능!
		public static void close(Statement stmt) {
			try {
				if(stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		public static void close(Connection conn) {
			try {
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		// 커밋/롤백
		public static void commit(Connection conn) {
			try {
				if(conn != null && !conn.isClosed()) {
					conn.commit(); // commit() 메서드 사용
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public static void rollback(Connection conn) {
			try {
				if(conn != null && !conn.isClosed()) {
					conn.rollback(); // rollback() 메서드 사용
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
