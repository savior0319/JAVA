package FWFR;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		String write;
		try {
			FileWriter fw = new FileWriter("test.txt");
			Scanner sc = new Scanner(System.in);
			write = sc.next();
			fw.write(write);
			fw.close();
			sc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
