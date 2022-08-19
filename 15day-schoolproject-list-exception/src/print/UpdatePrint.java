package print;

import java.util.Scanner;

import model.exception.NameCheckException;
import model.exception.TelCheckException;
import model.vo.Member;
import model.vo.SchoolServiceImpl;
import schoolInterFace.SchoolService;

public class UpdatePrint {
	private Scanner sc;
	ChoicePrint choiceprint;
	SchoolService service;

	public UpdatePrint() {
		sc = new Scanner(System.in);
		choiceprint = new ChoicePrint();
		service = new SchoolServiceImpl();
	}
	public Member updateprint() throws NameCheckException, TelCheckException {
		Member member = null;
		System.out.println("정말 수정 하겠습니까 ? 1. 네 2. 아니오 > ");
		int choice = sc.nextInt();
	switch(choice) {
			case 1:
				member = choiceprint.add();
				break;
			case 2:
				member = null;
				break;
			}
		return member;
	}
}
