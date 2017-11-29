package _08;

import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class Highlow extends Thread {

	private int count = 0;
	Random rd = new Random();
	
	JTextArea jta;
	JLabel jb;
	int input;
	
	public Highlow(int input, JTextArea jta, JLabel jb) {
		this.input = input;
		this.jta = jta;
		this.jb = jb;
	}
	
	public void run() {
		try {
			while (true) {
				int ran = (int)(Math.random()*100)+1; 
				System.out.println(ran);
				if(input < ran) {
					jta.append(ran+"��(��) ���亸�� Ů�ϴ�. \r\n");
					++count;
					jb.setText("�õ� Ƚ�� : �� "+ count + "ȸ");
				} else if(input > ran){
					jta.append(ran+"��(��)���亸�� �۽��ϴ�. \r\n");
					++count;
					jb.setText("�õ� Ƚ�� : �� "+ count + "ȸ");
				} else if(input == ran){
					jta.append(ran+"��(��)�����Դϴ�. \r\n");
					++count;
					jb.setText("�õ� Ƚ�� : �� "+ count + "ȸ");
					interrupt();
				}
			sleep(100);
		}
	} catch (Exception e) {
		e.printStackTrace();
		}
	}
}