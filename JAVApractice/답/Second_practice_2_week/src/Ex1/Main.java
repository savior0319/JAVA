package Ex1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		WordCounter wordCounter = new WordCounter();
		FileManager fileManager = new FileManager();
		
		System.out.println(" ### WordCounter ###");
		System.out.println("���ڿ��� �Է��Ͻÿ�...");
		String str = sc.nextLine();
		String result = wordCounter.countWord(str);
		fileManager.saveResult(result);
		
	}
}
