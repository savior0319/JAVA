package week1_3;

public class Main {

	public static void main(String[] args) {
		
		
		System.out.println("* ��������� ���α׷� *");
		System.out.println("1. ������ �Է��մϴ�.");
		FileManager manager = new FileManager();
		
		System.out.println("=> �����Է� �Ϸ�..");
		System.out.println("2. ���ڿ��� ����մϴ�.");
		String text = manager.readText();
		System.out.println(text);
		
		System.out.println("3. �ܾ��� ������ Ȯ���մϴ�.");
		int count = manager.checkWords(text);
		System.out.println("�ܾ� ���� : " + count);
		
		System.out.println("4. ������ ����Ͽ����ϴ�...");
		manager.writeText(text + "\r\n �ܾ� ���� : " + count);
		
		System.out.println("* ���α׷� ����...");
		
	}

}
