package member.model.service;

import static common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;

import member.model.dao.MemberDao;
import member.model.vo.Member;

// Controller > Service > Dao 의 중간단계로써 
// Connection 연결하거나 UPDATE 구문
// 일시 commit과 rollback 트랜지션을 담당하는 클래스 라고생각하면 된다.


public class MemberService {
	private MemberDao md = new MemberDao();
	
	// 1. 새회원 등록
	public int insertMember(Member m) {
		Connection con = getConnection();
		int result = md.insertMember(con, m);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		return result;
	}
	// 2. 모든 회원 조회
	public List<Member> selectAll() {
		Connection con = getConnection();
		List<Member> mList = md.selectAll(con);
		close(con);
		return mList;
	}
	// 3. 아이디로 회원 조회
	public Member selectMemberId(String memberId){
		Connection con = getConnection();
		Member member = md.selectMemberId(con, memberId);
		close(con);
		return member;
	}
	// 4. 성별로 회원 조회
	public List<Member> selectGender(String gender) {
		Connection con = getConnection();
		List<Member> mList = md.selectGender(con, gender);
		close(con);
		return mList;
	}
	// 5. 회원 암호 변경
	public int updatePassword(String memberId,String memberPwd) {
		Connection con = getConnection();
		int result = md.updatePassword(con, memberId, memberPwd);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}
	
	// 6. 회원 이메일 변경
	public int updateEmail(String memberId,String memberEmail) {
		Connection con = getConnection();
		int result = md.updateEmail(con, memberId, memberEmail);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}
	// 7. 회원 전화번호 변경
	public int updatePhone(String memberId,String memberphone) {
		Connection con = getConnection();
		int result = md.updatePhone(con, memberId, memberphone);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}
	// 8. 회원 주소 변경
	public int updateAddress(String memberId,String address) {
		Connection con = getConnection();
		int result = md.updateAddress(con, memberId, address);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}
	// 9. 회원 탈퇴
	public int deleteMember(String memberId) {
		Connection con = getConnection();
		int result = md.deleteMember(con, memberId);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}
}
