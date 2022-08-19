package model.ObjectFileIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import model.vo.Member;

public class FileObjectInput {
	FileInputStream fileStream;
	ObjectInputStream objectInputStream;
	
	public FileObjectInput() throws IOException {
	}
	public ArrayList<Member> input() throws ClassNotFoundException, IOException {
		fileStream = new FileInputStream("C:\\kosta250\\se-workspace\\15day-schoolproject-list-exception\\src\\save.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileStream);
		Object object = objectInputStream.readObject();
		ArrayList<Member> list2 = (ArrayList<Member>)object;
		objectInputStream.close();
		return  list2;
	}
}
