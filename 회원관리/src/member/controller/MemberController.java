package member.controller;

import java.util.List;

import member.model.service.MemberService;
import member.model.vo.Member;
import member.view.MemberView;

/*
Controller > Service > Dao 순으로 차근차근 데이터를 주고받는다 
Controller같은겨우는 왕복후 입력 성공하였는지 실패하였는지 판단하는 클래스
*/
public class MemberController {
	
	private MemberService ms = new MemberService();
	private MemberView mv = new MemberView();
	
	// 1. 새 회원 등록
	public void insertMember(Member m) {
		int result = ms.insertMember(m);
		
		if(result > 0) {
			mv.displaySuccess("insert");
		} else {
			mv.displayError("insert");
		}
	}
	
	// 2. 모든 회원 조회
	public void selectAll() {
		List<Member> mList= ms.selectAll();
		mv.displayList(mList);
	}
	
	// 3. 아이디로 회원 조회
	public void selectMemberId(String memberId) {
		Member member = ms.selectMemberId(memberId);
		mv.displaySuccess(memberId);
	}
	// 4. 성별로 회원 조회
	public void selectGender(String gender) {
		List<Member> mList = ms.selectGender(gender);
		mv.displayList(mList);
	}
	
	//5. 회원 암호 변경
	public void updatePassword(String memberId , String memberPwd) {
		int result = ms.updatePassword(memberId, memberPwd);
		
		if(result > 0) {
			mv.displaySuccess("updatePassword");
		} else {
			mv.displayError("updatePassword");
		}
	}
	//6. 회원 이메일 변경
	public void updateEmail(String memberId,String email) {
		int result = ms.updateEmail(memberId, memberId);
		
		if(result > 0) {
			mv.displaySuccess("updateEmail");
		} else {
			mv.displayError("updateEmail");
		}
	}
	// 7. 회원 전화번호 변경
	public void updatePhone(String memberId,String phone) {
		int result = ms.updatePhone(memberId, memberId);
		
		if(result > 0 ) {
			mv.displaySuccess("updatePhone");
		} else {
			mv.displayError("updatePhone");
		}
	}
	// 8. 회원 주소 변경
	public void updateAddress(String memberId,String address) {
		int result = ms.updateAddress(memberId, address);
		
		if(result > 0) {
			mv.displaySuccess("updateAddress");
		} else {
			mv.displayError("updateAddress");
		}
	}
	// 9. 회원탈퇴
	public void deleteMember(String memberId) {
		int result = ms.deleteMember(memberId);
		
		if(result > 0) {
			mv.displaySuccess("delete");
		} else {
			mv.displayError("delete");
		}
	}
}
