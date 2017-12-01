package _03;
import java.awt.*;
import javax.swing.*;

public class Vending_machine extends JFrame {
	
	private JTextField jf1 = new JTextField("투입금액");
	private JButton jb1 = new JButton("콜라(1000)");
	private JButton jb2 = new JButton("사이다(800)");
	private JButton jb3 = new JButton("환타(700)");
	private JButton jb4 = new JButton("");
	private JTextField jf2 = new JTextField("반환금액");
	private JPanel jp1 = new JPanel(); // 버튼 4개 패널
	private Container ct = getContentPane();
	
	public Vending_machine() {
		setTitle("자판기 UI 만들기");
		setSize(300,200);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ct.setLayout(new BorderLayout()); // 전체  레이아웃 -border

		jp1.setLayout(new GridLayout(2,2,0,0)); // 버튼 레이아웃 2*2 -grid
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		jp1.add(jb4);
	
		/*배치*/
		ct.add(jf1, BorderLayout.NORTH); 
		ct.add(jf2, BorderLayout.SOUTH);
		ct.add(jp1, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Vending_machine();
	}

}
