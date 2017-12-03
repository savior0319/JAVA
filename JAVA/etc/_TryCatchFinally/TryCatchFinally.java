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
			System.out.println("Error : Array length is wrong");
		} finally {
			System.out.println(str[0]);
		}
	}

}
