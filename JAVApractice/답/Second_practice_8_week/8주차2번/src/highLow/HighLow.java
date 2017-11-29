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
				int ranNum = ran.nextInt((maxNum-minNum)+1)+minNum; // 범위 안에 있는 랜덤 값
				System.out.println(minNum+" ~ "+maxNum);
				if (ranNum > inputNum) {
					jta.append(ranNum + "은 정답보다 큽니다\r\n");
					maxNum = ranNum - 1;
					count++;
					lb.setText("시도횟수 : "+count);
				} else if (ranNum < inputNum) {
					jta.append(ranNum + "은 정답보다 작습니다\r\n");
					minNum = ranNum + 1;
					count++;
					lb.setText("시도횟수 : "+count);
				} else if (ranNum == inputNum) {
					jta.append(ranNum + "은 정답입니다");
					count++;
					lb.setText("시도횟수 : "+count);
					stop();
				}
				sleep(2000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
