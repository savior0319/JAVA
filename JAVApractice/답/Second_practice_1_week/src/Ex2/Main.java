package Ex2;

import java.util.Scanner;

import Ex1.FileManager;

public class Main {
	public static void main(String[] args) {
		System.out.println(" * �����Է� ���α׷� *");
		
		// ���� ����
		
		// ��ü ����
		Ex2.FileManager fileManager;
		Scanner sc = new Scanner(System.in);
		
		// ���ڿ� ����
		System.out.println("1. ������ �Է��մϴ�");
		fileManager = new Ex2.FileManager();
		System.out.println("2. ���ڿ��� ����մϴ�");
		fileManager.writeText();
		System.out.println(" * ���α׷� ����...*");
	}
}
