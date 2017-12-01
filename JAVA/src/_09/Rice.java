package _09;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Rice extends JFrame implements ActionListener{
	
	private Container ct = getContentPane();
	private JLabel jlb1 = new JLabel("∫œ«— Ω“ : ");
	private JLabel jlb2 = new JLabel("0 kg");
	private JLabel jlb3 = new JLabel("Ω“ ∫∏≥ª±‚ :");
	private JTextField jtf = new JTextField();
	private JButton jbt = new JButton("∫∏≥ª±‚");

	
	public Rice() {
		setTitle("∫œ«— Ω“ ¡÷±‚");
		setSize(300,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		
		jlb1.setBounds(40,10,60,20);
		jlb2.setBounds(200,10,60,20);
		jlb3.setBounds(27,40,90,20);
		jtf.setBounds(100,35,100,30);
		jbt.setBounds(203,35,80,29);
		
		ct.add(jlb1);
		ct.add(jlb2);
		ct.add(jlb3);
		ct.add(jtf);
		ct.add(jbt);
		
		jbt.addActionListener(this);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Rice().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		RiceConsume rc = new RiceConsume(jlb2, jtf);
		if(arg0.getSource()==jbt) {
		jbt.setEnabled(false);
		rc.start();
		}
	}

}
