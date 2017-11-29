package _06;

import java.awt.*;
import javax.swing.*;

public class CalculatorUI extends JFrame{

	private String[] bt = {
			 "+","-","*","/"
			,"7","8","9","%"
			,"4","5","6","("
			,"1","2","3",")"
			,"0",".","=","¡ç"};
	private JList<String> jl = new JList<String>();
	private JTextField jf = new JTextField(); 
	private Container ct = getContentPane();
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	private JButton[] jb = new JButton[20];

	public CalculatorUI() {
		setTitle("°è»ê±â UI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,400);
		setResizable(false);

		ct.setLayout(new GridLayout(2,1));
		
		jp1.setLayout(new BorderLayout());
		jp1.add(jl, BorderLayout.CENTER);
		jp1.add(jf, BorderLayout.SOUTH);
		ct.add(jp1);
		
		jp2.setLayout(new GridLayout(5,4));
		for(int i = 0; i<jb.length; i++) {
		jp2.add(jb[i] = new JButton(bt[i]));
		jb[i].setFont(new Font("¸¼Àº°íµñ",Font.BOLD,20));
		}
		ct.add(jp2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CalculatorUI().setVisible(true);
	}

}
