package _04;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Even_odd extends JFrame implements ActionListener {

	private JTextField jf = new JTextField();
	private JButton jb = new JButton("�Ǻ�");
	private JLabel jl = new JLabel("Ȧ¦�Ǻ�");
	private Container ct = getContentPane();
	
	public Even_odd(){
		
	setTitle("Ȧ¦ �Ǻ�");
	setBounds(0,0,250,100);
	setLayout(null);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(false);
	
	jb.setBounds(119,0,115,32);
	jf.setBounds(0,0,119,32);
	jl.setBounds(5,22,125,50);
	ct.add(jb);
	ct.add(jf);
	ct.add(jl);
	
	jb.addActionListener(this);
		
	}

	public static void main(String[] args) {
		new Even_odd();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb) {
			int num = Integer.parseInt(jf.getText());
			if(num%2==0) 
				jl.setText("¦���Դϴ�.");
			else
				jl.setText("Ȧ���Դϴ�.");
			}
		}	
	}


