package member.model.dao;

import static common.JDBCTemplate.close; // close 

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import member.model.vo.Member;

public class MemberDao {
	private Properties query = new Properties();

	public MemberDao() {
		try {
			query.loadFromXML(new FileInputStream("member-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 1. 새회원등록
	public int insertMember(Connection con, Member m) {

		String sql = query.getProperty("insertMember");
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getGender());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getPhone());
			pstmt.setString(7, m.getAddress());
			pstmt.setInt(8, m.getAge());
			result = pstmt.executeUpdate(); // 추가 완료 시 1 반환
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 2. 모든회원조회
	public List<Member> selectAll(Connection con) {
		String sql = query.getProperty("selectList");
		Statement stmt = null;
		ResultSet rs = null;
		List<Member> mList = new ArrayList<>();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Member m = new Member(rs.getString("member_id"), rs.getString("member_pwd"),
						rs.getString("member_name"), rs.getString("gender"), rs.getString("email"),
						rs.getString("phone"), rs.getString("address"), rs.getInt("age"), rs.getDate("enroll_date"));
				mList.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		return mList;
	}

	// 3. 아이디로 회원 조회
	public Member selectMemberId(Connection con, String memberId) {
		String sql = query.getProperty("selectMemberId");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPwd(rs.getString("member_pwd"));
				member.setMemberName(rs.getString("member_name"));
				member.setGender(rs.getString("gender"));
				member.setEmail(rs.getString("email"));
				member.setPhone(rs.getString("phone"));
				member.setAddress(rs.getString("address"));
				member.setAge(rs.getInt("age"));
				member.setEnrollDate(rs.getDate("enroll_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return member;
	}

	// 4. 성별로 회원 조회
	public List<Member> selectGender(Connection con, String gender) {
		String sql = query.getProperty("selectGender");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> mList = new ArrayList<>();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, gender);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Member m = new Member();
				m = new Member();
				m.setMemberId(rs.getString("member_id"));
				m.setMemberPwd(rs.getString("member_pwd"));
				m.setMemberName(rs.getString("member_name"));
				m.setGender(rs.getString("gender"));
				m.setEmail(rs.getString("email"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
				m.setAge(rs.getInt("age"));
				m.setEnrollDate(rs.getDate("enroll_date"));
				mList.add(m); // 리스트에 추가함
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return mList;
	}

	// 5. 회원 암호 변경
	public int updatePassword(Connection con, String memberId, String memberPwd) {
		String sql = query.getProperty("updatePassword");
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberPwd);
			pstmt.setString(2, memberId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 6. 회원 이메일 변경
	public int updateEmail(Connection con, String memberId, String email) {
		String sql = query.getProperty("updateEmail");
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, memberId);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 7. 회원 전화번호 변경
	public int updatePhone(Connection con, String memberId, String phone) {
		String sql = query.getProperty("updatePhone");
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, phone);
			pstmt.setString(2, memberId);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 8. 회원 주소 변경
	public int updateAddress(Connection con, String memberId, String address) {
		String sql = query.getProperty("updateAddress");
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, address);
			pstmt.setString(2, memberId);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 9. 회원 탈퇴
	public int deleteMember(Connection con, String memberId) {
		String sql = query.getProperty("deleteMember");
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
