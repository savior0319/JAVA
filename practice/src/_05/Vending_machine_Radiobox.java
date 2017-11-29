package _05;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Vending_machine_Radiobox extends JFrame implements ActionListener {

	private JLabel jl = new JLabel("음료수를 선택해 주세요.");
	private JRadioButton jrb1 = new JRadioButton("콜라");
	private JRadioButton jrb2 = new JRadioButton("사이다");
	private JRadioButton jrb3 = new JRadioButton("환타");
	private JRadioButton jrb4 = new JRadioButton("생수");
	private ButtonGroup bg = new ButtonGroup();
	private JTextField jf = new JTextField();
	private Container ct = getContentPane();
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	
	public Vending_machine_Radiobox () {
		setTitle("자판기");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(260,150);
		
		ct.setLayout(new GridLayout(3,1,0,0));
		jp1.add(jl, BorderLayout.CENTER);
		
		bg.add(jrb1);
		bg.add(jrb2);
		bg.add(jrb3);
		bg.add(jrb4);
		
		jp2.add(jrb1);
		jp2.add(jrb2);
		jp2.add(jrb3);
		jp2.add(jrb4);
		
		ct.add(jp1);
		ct.add(jp2);
		
		jf.setEditable(false);
		ct.add(jf);	
		
		jrb1.addActionListener(this);
		jrb2.addActionListener(this);
		jrb3.addActionListener(this);
		jrb4.addActionListener(this);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Vending_machine_Radiobox().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(jrb1.isSelected()) {
			jf.setText("콜라는 1200원 입니다.");
		} else if(jrb2.isSelected()) {
			jf.setText("사이다는 1000원 입니다.");
		} else if(jrb3.isSelected()) {
			jf.setText("환타는 800원 입니다.");
		} else if(jrb4.isSelected()) {
			jf.setText("생수는 500원 입니다.");
		}
	}

}
