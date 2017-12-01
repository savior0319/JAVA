package _03;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Star extends JFrame {
	
	Container ct = getContentPane();

	public Star(){
		
		System.out.println("단수 입력");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		
		setTitle("별찍기 응용");
		setVisible(true);
		setSize(300,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ct.setLayout(new GridLayout(num,num*2-1,10,10));

		for (int i = num; i > 0; i--) {
			for (int j = num - i; j > 0; j--) {
				JPanel jp1 = new JPanel();
				jp1.setBackground(Color.WHITE);
				ct.add(jp1);
			}
			for (int k = i * 2 - 1; k > 0; k--) {
				JPanel jp2 = new JPanel();
				jp2.setBackground(Color.BLACK);
				ct.add(jp2);
			}
			for (int j = num - i; j > 0; j--) {
				JPanel jp1 = new JPanel();
				jp1.setBackground(Color.WHITE);
				ct.add(jp1);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Star();
	}
}
