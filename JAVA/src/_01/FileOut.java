package _01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FileOut {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String text;

		System.out.println("����� ���� �Է�");
		System.out.print("->");
		text = sc.nextLine();
		sc.close();
		writeText(text);
	}

	private static void writeText(String text) {

		try {
			FileWriter fw = new FileWriter("test.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(text);
			bw.close();
		} catch (Exception e) {
			System.out.println("���� ���� ����");
		}
		System.out.println("�Է��� ���� ���� �Ϸ�");
		System.out.println("���α׷� ����");
	}
}
