package highLow;

import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class HighLow extends Thread {
	int inputNum;
	int randomNum;
	int minNum = 1;
	int maxNum = 100;
	int count = 0;
	JTextArea jta;
	JLabel lb;
	Random ran = new Random();

	public HighLow(int inputNum, JTextArea jta, JLabel lb) {
		this.inputNum = inputNum;
		this.jta = jta;
		this.lb = lb;
	}

	public void run() {
		try {
			while (true) {
				int ranNum = ran.nextInt((maxNum-minNum)+1)+minNum; // ���� �ȿ� �ִ� ���� ��
				System.out.println(minNum+" ~ "+maxNum);
				if (ranNum > inputNum) {
					jta.append(ranNum + "�� ���亸�� Ů�ϴ�\r\n");
					maxNum = ranNum - 1;
					count++;
					lb.setText("�õ�Ƚ�� : "+count);
				} else if (ranNum < inputNum) {
					jta.append(ranNum + "�� ���亸�� �۽��ϴ�\r\n");
					minNum = ranNum + 1;
					count++;
					lb.setText("�õ�Ƚ�� : "+count);
				} else if (ranNum == inputNum) {
					jta.append(ranNum + "�� �����Դϴ�");
					count++;
					lb.setText("�õ�Ƚ�� : "+count);
					stop();
				}
				sleep(2000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
