package _TryCatchFinally;

public class TryCatchFinally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Hello World");
		} catch (Exception e) {
			e.printStackTrace();
		}

		String[] str = new String[1];
		str[0] = "Hello World";
		
		try {
			System.out.println(str[1]);
		} catch (Exception e) {
			System.out.println("배열 길이 오류 발생");
		} finally {
			System.out.println(str[0]);
		}
	}

}
