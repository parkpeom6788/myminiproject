package regularexpression;

import java.util.regex.Pattern;
public class RegularePattern {
	// 이름 체크
	public static boolean nameCheck(String name) {
		if(Pattern.matches("^[가-힣]*$",name)) 
			return true;
		else 
			return false;
	}
	// 폰번호 체크
	public static boolean phoneCheck(String tel) {
		if(Pattern.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$",tel)) 
			return true;
		else 
			return false;
	}
}
