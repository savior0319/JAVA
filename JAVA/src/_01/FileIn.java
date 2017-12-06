package _01;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileIn {

	public static void main(String[] args) {

		System.out.println("출력할 파일 입력");
		System.out.println("파일 출력 완료");
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
				System.out.println("파일 쓰기 오류");
			}
		} catch (Exception e) {
			System.out.println("파일이 없습니다");
		}
		System.out.print(save);
		System.out.println("프로그램 종료");
	}
}
