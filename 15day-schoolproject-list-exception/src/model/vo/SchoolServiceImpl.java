package model.vo;

import java.io.IOException;
import java.util.ArrayList;

import model.ObjectFileIO.FileObjectInput;
import model.ObjectFileIO.FileObjectOutput;
import model.exception.DuplicateTelException;
import model.exception.MemberNotFoundException;
import schoolInterFace.SchoolService;
public class SchoolServiceImpl implements SchoolService {
	private ArrayList<Member> list;
	
	public SchoolServiceImpl() {
		list = new ArrayList<>();
	}
	@Override
	public void addMember(Member member) throws DuplicateTelException {
		if(findIndexByTel(member.getTel()) != -1) 
			throw new DuplicateTelException(member.getTel() + " 멤버가 중복됩니다.");
		else 
			list.add(member);
	}
	@Override
	public int findIndexByTel(String tel) {
		int position = -1;
		for(int i=0; i<list.size(); i++) {
			if(tel.equals(list.get(i).getTel()))
			position = i;
			break;
		}
		return position;
	}
	@Override
	public void printAll() {
		for(Member member : list)  System.out.println(member);
	}
	@Override
	public Member findMemberByTel(String tel) throws MemberNotFoundException {
		Member member = null;
		if(findIndexByTel(tel) != -1) {
			member = list.get(findIndexByTel(tel));
			System.out.println(member + " 를 찾았습니다.");
		}
		else throw new MemberNotFoundException(tel + "멤버를 찾지 못했습니다.");
		return member;
	}	
	@Override
	public void deleteMemberByTel(String tel) throws MemberNotFoundException {
		if(findIndexByTel(tel) != -1)  {
			list.remove(findIndexByTel(tel));
			System.out.println(tel + "정상적으로 삭제되었습니다.");
		}
		else throw new MemberNotFoundException(tel + "멤버를 찾지 못했습니다.");
	}
	@Override
	public void updateMember(Member member) throws MemberNotFoundException {
		if(findIndexByTel(member.getTel()) != -1) {
			list.set(findIndexByTel(member.getTel()), member);
			System.out.println(member.getTel() + "정상적으로 수정되었습니다.");
		}
		else throw new MemberNotFoundException(member.getTel() + "멤버를 찾지 못했습니다.");
	}
	@Override
	public void saveMember() throws IOException {
		FileObjectOutput  fileobject = new FileObjectOutput();
		fileobject.output(list);
	}
	@Override
	public void loadingMember() throws IOException, ClassNotFoundException {
		FileObjectInput fileStream = new FileObjectInput();
		list = fileStream.input();
	}
}
