package common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
public class JDBCTemplate {
	public static Connection getConnection() {
		Connection con = null;
		Properties prop = new Properties();
		try {
			// 오라클 드라이브 연결할때 properties 파일에서 정보들을 불러와 연결하고있다.
			// 나중에 관리하기가 편해짐
			prop.load(new FileReader("driver.properties")); //  // 파일 읽어오기
			Class.forName(prop.getProperty("driver"));
				con = DriverManager.getConnection(prop.getProperty("url"),
						prop.getProperty("user"), prop.getProperty("password"));
				// 자동 커밋 방지
				con.setAutoCommit(false);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void close(Connection con) {
		try {
			if(con != null && !con.isClosed()) 
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			if(stmt!=null && !stmt.isClosed()) 
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {		
		try {
			if(rs != null && !rs.isClosed()) 
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void commit(Connection con) {
		try {
			if(con != null & !con.isClosed()) 
				con.commit();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void rollback(Connection con) {
		try {
			if(con != null & !con.isClosed())
				con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
