package Ex2;

import java.util.Scanner;

import Ex1.FileManager;

public class Main {
	public static void main(String[] args) {
		System.out.println(" * 파일입력 프로그램 *");
		
		// 변수 선언
		
		// 객체 생성
		Ex2.FileManager fileManager;
		Scanner sc = new Scanner(System.in);
		
		// 문자열 생성
		System.out.println("1. 파일을 입력합니다");
		fileManager = new Ex2.FileManager();
		System.out.println("2. 문자열을 출력합니다");
		fileManager.writeText();
		System.out.println(" * 프로그램 종료...*");
	}
}
