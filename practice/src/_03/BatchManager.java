package _03;

import java.awt.*;
import javax.swing.*;

public class BatchManager extends JFrame {
	
	final String[] a = {"1","2","3","4","5","6",
			"7","8","9"};
	private JButton[] jb = new JButton[a.length];
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	private JPanel jp3 = new JPanel();
	Container ct = getContentPane();
	
	public BatchManager(){
		setVisible(true);
		setResizable(false);
		setTitle("자바 실습");
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ct.setLayout(new GridLayout(3,1));
		
		jp1.setLayout(new FlowLayout(FlowLayout.CENTER,50,30));
			  for (int i = 0; i <= 2; i++) { 
	            	jp1.add(jb[i] = new JButton(a[i])); 
		  }
		jp2.setLayout(new GridLayout(1,3));
			  for (int i = 3; i <= 5; i++) { 
		            jp2.add(jb[i] = new JButton(a[i])); 
			  }
		jp3.setLayout(new BorderLayout());
			  jp3.add(jb[6] = new JButton(a[6]), BorderLayout.WEST);
			  jp3.add(jb[7] = new JButton(a[7]), BorderLayout.CENTER);
			  jp3.add(jb[8] = new JButton(a[8]), BorderLayout.EAST);
			  
		 ct.add(jp1);
		 ct.add(jp2);
		 ct.add(jp3);		 
}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BatchManager();
	}

}
