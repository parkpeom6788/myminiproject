package model.ObjectFileIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

// FileOutputStream 을 생성
// ObjectOutputStream 을 생성
// 객체를 저장
// ObjectOutputStream 을 클로즈 
public class Test {
	public static void main(String[] args) throws IOException {
		FileOutputStream fileStream = new FileOutputStream("C:\\javafiletest\\memo.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileStream);
		HashMap userInfoMap = new HashMap();
		userInfoMap.put("tel", "02-324-2424");
		userInfoMap.put("phone", "010-9999-9999");
		userInfoMap.put("tel", "02-324-2424");
		userInfoMap.put("age", "43");
		userInfoMap.put("birthday", "19330101");
		objectOutputStream.writeObject(userInfoMap);
		objectOutputStream.close();
	}
}
