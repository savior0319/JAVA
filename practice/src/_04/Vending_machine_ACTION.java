package _04;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Vending_machine_ACTION extends JFrame implements ActionListener{

	private JTextArea ja = new JTextArea("금액을 투입 후, 음료수를 구매");
	private JButton jb1 = new JButton("콜라(1000)");
	private JButton jb2 = new JButton("사이다(800)");
	private JButton jb3 = new JButton("환타(700)");
	private JButton jb4 = new JButton("구매");
	private JTextField jf1 = new JTextField();
	private JTextField jf2 = new JTextField("잔돈");
	TextHint hint1 = new TextHint(jf1, "투입금액");
	private Container ct = getContentPane();
	private JPanel jp1 = new JPanel(); // JTextArea 패널
	private JPanel jp2 = new JPanel(); // JTextField 패널
	private int input = 0; // 투입금액
	private int output = 0; // 잔돈
	private int price = 0; // 총 금액
	private int coke = 0; // 콜라 카운트
	private int cider = 0; // 사이다 카운트
	private int fanta = 0; // 환타 카운트

	/*레이아웃*/
	public Vending_machine_ACTION() {
		setTitle("간단한 자판기");
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		ct.setLayout(new BorderLayout()); // 배치 -BorderLayout
		
		jp1.setLayout(new GridLayout(2,2,0,0)); // JTextArea 패널
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		jp1.add(jb4);
		
		jp2.setLayout(new GridLayout(2,1,0,0)); // JTextField 패널
		jp2.add(jf1); 
		jp2.add(jf2);
		
		ct.add(ja, BorderLayout.NORTH);
		ct.add(jp1, BorderLayout.CENTER);
		ct.add(jp2, BorderLayout.SOUTH);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new Vending_machine_ACTION().setVisible(true);
	}

	/*액션*/
	@Override
	public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource()==jb1) {  // 콜라 버튼
			price += 1000;
			coke++;
			} else if(arg0.getSource()==jb2) { // 사이다 버튼
			price += 800;
			cider++;
		    } else if(arg0.getSource()==jb3) { // 환타 버튼
			price += 700;
			fanta++;
			} else if(arg0.getSource()==jb4) { // 구매 버튼
				input = Integer.parseInt(jf1.getText());
				output = input - price;
			if(output>=0) { // 잔액 있을 때
			ja.setText("콜라 : " + (coke) + "개 " + " / " + 
				"사이다 : " + (cider) + "개 " + " / " +
				"환타 : " + (fanta) + "개 " + " / " + "총 금액 : " + price);
			jf2.setText("잔돈 : " + String.valueOf(output));
			} else if(output<0) { // 잔액 부족할 때
			ja.setText("잔액이 부족합니다.");
			}
		}
	}
}
