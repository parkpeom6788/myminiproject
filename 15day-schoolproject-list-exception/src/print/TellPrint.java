package print;

import java.util.Scanner;

public class TellPrint {
	
	private String tel;
	private Scanner sc;
	public TellPrint() {
		sc = new Scanner(System.in);
	}
	public String tellprint() {
		System.out.print("번호 입력 010-0000-0000 > ");
		tel = sc.next();
		return tel;
	}
}
