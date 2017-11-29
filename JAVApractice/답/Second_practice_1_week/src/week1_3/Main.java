package week1_3;

public class Main {

	public static void main(String[] args) {
		
		
		System.out.println("* 파일입출력 프로그램 *");
		System.out.println("1. 파일을 입력합니다.");
		FileManager manager = new FileManager();
		
		System.out.println("=> 파일입력 완료..");
		System.out.println("2. 문자열을 출력합니다.");
		String text = manager.readText();
		System.out.println(text);
		
		System.out.println("3. 단어의 개수를 확인합니다.");
		int count = manager.checkWords(text);
		System.out.println("단어 개수 : " + count);
		
		System.out.println("4. 파일을 출력하였습니다...");
		manager.writeText(text + "\r\n 단어 개수 : " + count);
		
		System.out.println("* 프로그램 종료...");
		
	}

}
