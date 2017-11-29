package week1_3;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
	
	FileWriter fw;
	FileReader fr;
	
	File file = new File("test.txt");
	
	public void writeText(String text) {
		try {
			fw = new FileWriter("test2.txt");
			
			fw.write(text);
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String readText() {
		String temp = "";
		
		try {			
			fr = new FileReader(file);
			
			int ch;
			while ((ch = fr.read()) != -1) {
				temp += (char)ch;
			}
			
			fr.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return temp;
	}
	
	public int checkWords(String text) {
		return text.split(" ").length;
	}
}
