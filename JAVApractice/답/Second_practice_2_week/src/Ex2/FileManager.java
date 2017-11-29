package Ex2;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileManager {
	FileInputStream fis;
	FileOutputStream fos;
	String readStr = "";

	public FileManager() {
		try {
			fos = new FileOutputStream("result.txt");
			fis = new FileInputStream("baseball.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeResult(String result) {
		try {
			fos.write(result.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String readResult() {
		try {
			byte[] buffer = new byte[1024];
			fos.close();
			fis.read(buffer);
			readStr = new String(buffer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return readStr;
	}
}
