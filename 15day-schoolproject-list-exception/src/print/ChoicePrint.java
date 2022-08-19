package print;

import java.util.Scanner;

import model.exception.NameCheckException;
import model.exception.TelCheckException;
import model.vo.Employee;
import model.vo.Member;
import model.vo.Student;
import model.vo.Teacher;
public class ChoicePrint {
	private static final int STUDENT = 1;
	private static final int TEACHER = 2;
	private static final int EMPLOYEE = 3;
	Scanner sc;
	String tel , name, address , stuid , subject , department;
	public ChoicePrint() {
		sc = new Scanner(System.in);
	}
	public Member add() throws NameCheckException, TelCheckException {
		Member member = null;
		System.out.print("당신의 직업은 ?  1. 학생 2. 선생님 3. 직원 > ");
		int choice = sc.nextInt();
		switch(choice) {
			case STUDENT : 
				pilsu();
				 studentPrint();
				member = new Student(tel, name, address, stuid);
				break;
			case TEACHER : 
				pilsu();
				teacherPrint();
				member = new Teacher(tel,name,address,subject);
				break;
			case EMPLOYEE :
				pilsu();
				employeePrint();
				member = new Employee(tel,name,address,department);
				break;
		}
		return member;
	}
	public void pilsu() {
		System.out.print("번호 010-0000-0000 > ");
		tel = sc.next();	
		System.out.print("이름 > ");
		name = sc.next();	
		System.out.print("지역 > ");
		address = sc.next();
	}
	public void studentPrint() {
		System.out.print("학생 번호 > ");
		stuid = sc.next();
	}
	public void teacherPrint() {
		System.out.print("과목 이름 > ");
		subject = sc.next();
	}
	public void employeePrint() {
		System.out.print("부서 이름 > ");
		department = sc.next();
	}
}
