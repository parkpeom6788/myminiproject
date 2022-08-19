package main;
import java.io.IOException;
import java.util.Scanner;

import model.exception.DuplicateTelException;
import model.exception.MemberNotFoundException;
import model.exception.NameCheckException;
import model.exception.TelCheckException;
import model.vo.Member;
import model.vo.SchoolServiceImpl;
import print.ChoicePrint;
import print.TellPrint;
import print.UpdatePrint;
import schoolInterFace.SchoolService;
public class SchoolProject {
	SchoolService service;
	TellPrint tellprint;
	UpdatePrint updateprint;
	ChoicePrint choice;
	Scanner sc;
	int menu;
	public SchoolProject() {
		service = new SchoolServiceImpl();
		tellprint = new TellPrint();
		updateprint = new UpdatePrint();
		choice = new ChoicePrint();
		sc = new Scanner(System.in);
		try {
			choice();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static final int EXIT = 0 ; // 끝내기 
	private static final int ADD = 1 ; // 추가
	private static final int PRINTALL = 2 ; // 모두출력
	private static final int DELETE = 3 ; // 삭제
	private static final int FIND= 4 ; // 찾기
	private static final int UPDATE = 5 ; // 수정
	private static final int SAVE = 6; // 저장 
	private static final int LOADING = 7; // 불러오기 
	@SuppressWarnings("finally")
	public void choice() throws IOException {
		while(true) {
			System.out.println("=========================");
			System.out.println("\t\t 스쿨 프로젝트 \t\t");
			System.out.println("1. 추가");
			System.out.println("2. 모두 출력");
			System.out.println("3. 삭제");
			System.out.println("4. 찾기");
			System.out.println("5. 수정");
			System.out.println("0. 프로그램 종료");
			System.out.println("6. 자료 저장");
			System.out.println("7. 자료 불러오기");
			System.out.println("=========================");
			System.out.print(">>");
			menu = sc.nextInt();
			switch(menu) {
				case EXIT: System.exit(0);   break;
				case ADD: 	
				try {
					Member member = choice.add();	
						service.addMember(member);
					} catch (DuplicateTelException e) {
						System.out.println(e.getMessage());
					} catch (TelCheckException e) {
						System.out.println(e.getMessage());
					} catch (NameCheckException e) {
						System.out.println(e.getMessage());
					}
				break;
				case PRINTALL: 
					service.printAll();
					break;
				case DELETE:
					try {
						service.deleteMemberByTel(tellprint.tellprint());
					} catch (MemberNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				case FIND:
					try {
						service.findMemberByTel(tellprint.tellprint());
					} catch (MemberNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				case UPDATE: 
					try {
						service.updateMember(updateprint.updateprint());
					} catch (MemberNotFoundException e) {
						System.out.println(e.getMessage());
					} finally { // @SuppressWarnings("finally")
						break;
					}
				case SAVE :
					service.saveMember();
					break;
				case LOADING:
				try {
					service.loadingMember();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
					}
				}
			} 
		}
		public static void main(String[] args) {
			new SchoolProject();
		}
}
