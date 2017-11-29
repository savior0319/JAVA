package Ex2;

import java.io.FileReader;
import java.io.FileWriter;

public class FileManager {
	FileReader fr;
	String text;
	int i;
	
	public FileManager() {
		try {
			fr = new FileReader("test.txt");
			System.out.println("=> n파일입력 완료..");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeText() {
		try {
			while ((i = fr.read()) != -1) {
				System.out.print((char)i);
			}System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
