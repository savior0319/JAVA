package Ex1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println(" * 파일출력 프로그램 *");
		
		// 변수 선언
		String text;
		
		// 객체 생성
		FileManager fileManager = new FileManager();
		Scanner sc = new Scanner(System.in);
		
		// 문자열 생성
		System.out.println("1. 출력할 문장을 입력하시오");
		text = sc.nextLine();
		fileManager.writeText(text);
		System.out.println(" * 프로그램 종료...*");
	}
}
