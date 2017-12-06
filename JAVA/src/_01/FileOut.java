package _01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FileOut {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String text;

		System.out.println("출력할 문장 입력");
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
			System.out.println("파일 쓰기 오류");
		}
		System.out.println("입력한 문장 저장 완료");
		System.out.println("프로그램 종료");
	}
}
