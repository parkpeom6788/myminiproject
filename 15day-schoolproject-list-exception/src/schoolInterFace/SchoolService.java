package schoolInterFace;
import java.io.IOException;

import model.exception.DuplicateTelException;
import model.exception.MemberNotFoundException;
import model.vo.Member;
public interface SchoolService {
	void addMember(Member member) throws DuplicateTelException;
	int findIndexByTel(String tel);
	void printAll();
	Member findMemberByTel(String tel) throws MemberNotFoundException;
	void deleteMemberByTel(String tel) throws MemberNotFoundException;
	void updateMember(Member member) throws MemberNotFoundException;
	void saveMember() throws IOException;
	void loadingMember() throws IOException ,ClassNotFoundException;
}