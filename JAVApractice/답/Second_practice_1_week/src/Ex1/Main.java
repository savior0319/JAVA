package Ex1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println(" * ������� ���α׷� *");
		
		// ���� ����
		String text;
		
		// ��ü ����
		FileManager fileManager = new FileManager();
		Scanner sc = new Scanner(System.in);
		
		// ���ڿ� ����
		System.out.println("1. ����� ������ �Է��Ͻÿ�");
		text = sc.nextLine();
		fileManager.writeText(text);
		System.out.println(" * ���α׷� ����...*");
	}
}
