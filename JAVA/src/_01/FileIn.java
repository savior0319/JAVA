package _01;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileIn {

	public static void main(String[] args) {

		System.out.println("����� ���� �Է�");
		System.out.println("���� ��� �Ϸ�");
		System.out.print("-> ");
		readtext();

	}

	private static void readtext() {
		String text = "";
		String save = new String();
		try {
			FileReader fr = new FileReader("test.txt");
			BufferedReader br = new BufferedReader(fr);
			try {
				while ((text = br.readLine()) != null) {
					save += text + "\r\n";
				}
				br.close();
			} catch (Exception e) {
				System.out.println("���� ���� ����");
			}
		} catch (Exception e) {
			System.out.println("������ �����ϴ�");
		}
		System.out.print(save);
		System.out.println("���α׷� ����");
	}
}
