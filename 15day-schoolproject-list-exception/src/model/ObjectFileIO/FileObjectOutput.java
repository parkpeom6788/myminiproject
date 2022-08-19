package model.ObjectFileIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.vo.Member;

public class FileObjectOutput {
	
	FileOutputStream fileStream;
	ObjectOutputStream objectOutputStream;
	
	public FileObjectOutput() throws IOException {
		fileStream = new FileOutputStream("C:\\kosta250\\se-workspace\\15day-schoolproject-list-exception\\src\\save.txt");
		objectOutputStream = new ObjectOutputStream(fileStream);

	}
	public void output(ArrayList<Member> list) throws IOException {
		objectOutputStream .writeObject(list);
		objectOutputStream.close();
	}
}
