package model.vo;

import model.exception.NameCheckException;
import model.exception.TelCheckException;

public class Teacher extends Member {
	private String subject;
	public Teacher() {}
	public Teacher(String tel, String name, String address, String subject) throws NameCheckException, TelCheckException {
		super(tel, name, address);
		this.subject = subject;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Teacher [ "+ super.toString() + "  subject=" + subject + "]";
	}
	
}
