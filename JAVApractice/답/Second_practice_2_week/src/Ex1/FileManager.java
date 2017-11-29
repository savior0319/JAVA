package Ex1;

import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
	FileWriter fw;

	public FileManager() {
		try {
			fw = new FileWriter("result.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveResult(String result) {
		try {
			fw.write(result);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
