package model.ObjectFileIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Iterator;
public class Test2 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		/* 역직렬화 : 객체 복구 순서
		 *  FileInputStream 을 생성
		 *  ObjectInputStream 생성
		 *  객체를 읽는다
		 *  객체를 캐스트 한다
		 *  ObjectInputStream 클로즈 
		 */
		// 파일로부터 역직렬화 해서 object를 읽어옴 
		FileInputStream fileStream = new FileInputStream("C:\\javafiletest\\memo.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileStream);
		
		Object object = objectInputStream.readObject();
		objectInputStream.close();
		
		// map을 만들어서 object의 객체를 형변환 한다.
		System.out.println("읽어온 객체의 type -> " + object.getClass());
		HashMap hashMap = (HashMap)object; 
		
		Iterator<String> it = hashMap.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next(); // 맵키를 꺼냄 
			String value = (String)hashMap.get(key); // 키에 해당하는 객체를 꺼낸다 
			System.out.println(key + "->" + value);	
		}
	}
}
