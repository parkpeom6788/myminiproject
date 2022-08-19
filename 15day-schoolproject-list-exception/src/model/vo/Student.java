package model.vo;

import model.exception.NameCheckException;
import model.exception.TelCheckException;

public class Student extends Member {
	private String stuid;
	public Student() {
	}
	public Student(String tel, String name, String address, String stuid) throws NameCheckException, TelCheckException {
		super(tel, name, address);
		this.stuid = stuid;
	}
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	@Override
	public String toString() {
		return "Student [" + super.toString() + " stuid=" + stuid + "]";
	}
}
