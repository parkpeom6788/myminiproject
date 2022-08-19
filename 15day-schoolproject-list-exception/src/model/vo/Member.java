package model.vo;

import java.io.Serializable;

import model.exception.NameCheckException;
import model.exception.TelCheckException;
import regularexpression.RegularePattern;

public abstract class Member implements Serializable {
	private String tel;
	private String name;
	private String address;
	public Member() {}
	public Member(String tel, String name, String address) throws NameCheckException, TelCheckException {
		
		if(RegularePattern.nameCheck(name))  this.name = name;			
	    else  throw new NameCheckException("이름을 제대로 입력해주세요.");
		if(RegularePattern.phoneCheck(tel))  this.tel = tel;
		else throw new TelCheckException("전화번호를 제대로 입력해주세요. 010-0000-0000");
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	// java.lang.Object 의 toString() 메서드를 오버라이드하여 주소값 대신 객체 실제내용이
	// 반환하도록 한다. 자식 클래스에서 재사용(super.toString()) 하도록 아래와 같이
	// 코드를 정리한다 
	@Override
	public String toString() {
		return " tel=" + tel + ", name=" + name + ", address=" + address + ",";
	}
}
