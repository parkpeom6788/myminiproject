package member.view;

import java.util.Scanner;

import member.controller.MemberController;
import member.model.vo.Member;

public class MemberMenu {
	Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public void displayMenu() {
		
		while(true) {
			System.out.println("\n *** 회원 관리 프로그램 *** \n");
			System.out.println("1. 새 회원 등록");
			System.out.println("2. 모든 회원 조회");
			System.out.println("3. 아이디로 회원 조회");
			System.out.println("4. 성별로 회원 조회");
			System.out.println("5. 암호 변경");
			System.out.println("6. 이메일 변경");
			System.out.println("7. 전화번호 변경");
			System.out.println("8. 주소 변경");
			System.out.println("9. 회원 탈퇴");
			System.out.println("0. 프로그램 종료");
			int no = Integer.parseInt(sc.nextLine());
			
			switch(no) {
			case 0: return;
			case 1:
				mc.insertMember(inputMember());
				break;
			case 2:
				mc.selectAll();
				break;
			case 3:
				mc.selectMemberId(inputMemberId()); 
				break;
			case 4:
				mc.selectGender(inputGender());
				break;
			case 5:
				mc.updatePassword(inputMemberId(), inputMemberPwd());
				break;
			case 6:
				mc.updateEmail(inputMemberId(), inputEmail());
				break;
			case 7:
				mc.updatePhone(inputMemberId(), inputPhone());
				break;
			case 8:
				mc.updateAddress(inputMemberId(), inputAddress());
				break;
			case 9:
				mc.deleteMember(inputMemberId());
				break;
			default :
				System.out.println("잘못된 번호 입니다 다시 입력해 주세요");
			}
		}
	}
	// 회원 정보 입력
	public Member inputMember() {
		System.out.print("회원 아이디 : ");
		String memberId = sc.nextLine();
		
		System.out.print("암호 : ");
		String memberPwd= sc.nextLine();
	
		System.out.print("이름 : ");
		String memberName = sc.nextLine();
		
		System.out.print("성별(M/F)");
		String gender = sc.next().toLowerCase();
		
		System.out.print("이메일 : ");
		String email = sc.next();
	
		System.out.print("전화번호 : ");
		String phone = sc.next();
		
		sc.nextLine();
		System.out.print("주소 : ");
		String address = sc.nextLine();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();
		
		Member m = new Member(memberId, memberPwd, memberName, gender, email, phone, address, age);
		return m;
	}
	// 회원아이디 입력
	public String inputMemberId() {
		System.out.print("아이디 입력");
		return sc.nextLine();
	}
	// 회원 비밀번호 입력
	public String inputMemberPwd() {
		System.out.print("수정할 비밀번호 입력");
		return sc.nextLine();
	}
	// 회원 성별 입력
	public String inputGender() {
		System.out.print("조회할 성별 : ");
		return sc.nextLine().toUpperCase(); 
	}
	// 회원 이메일 입력
	public String inputEmail() {
		System.out.println("수정할 이메일 입력 : ");
		return sc.nextLine();
	}
	// 회원 전화번호 입력
	public String inputPhone() {
		System.out.println("수정할 전화번호 입력 : ");
		return sc.nextLine();
	}
	// 회원 주소 입력
	public String inputAddress() {
		System.out.print("수정할 주소 입력 : ");
		return sc.nextLine();
	}
}
