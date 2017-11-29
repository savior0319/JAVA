package Ex2;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("단수를 입력하시오");
		int floor = sc.nextInt();
		new UI(floor).setVisible(true);
	}
}

class UI extends JFrame{
	Container ct = getContentPane();
	
	public UI(int floor) {
		setTitle("별찍기 응용");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,400);
		ct.setLayout(new GridLayout(floor,2*floor-1,10,10));
		
		for (int i = floor; i > 0; i--) {
			for (int j = floor - i; j > 0; j--) {
				JPanel whitePanel = new JPanel();
				whitePanel.setBackground(Color.WHITE);
				ct.add(whitePanel);
			}
			for (int k = i * 2 - 1; k > 0; k--) {
				JPanel blackPanel = new JPanel();
				blackPanel.setBackground(Color.black);
				ct.add(blackPanel);
			}
			for (int j = floor - i; j > 0; j--) {
				JPanel whitePanel = new JPanel();
				whitePanel.setBackground(Color.WHITE);
				ct.add(whitePanel);
			}
		}
	}
}
