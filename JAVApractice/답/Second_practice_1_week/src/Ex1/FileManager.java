package Ex1;

import java.io.FileWriter;

public class FileManager {
	FileWriter fw;

	public FileManager() {
		try {
			fw = new FileWriter("test.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeText(String text) {
		try {
			fw.write(text);
			System.out.println("2. 입력한 문장을 출력하였습니다...");
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
