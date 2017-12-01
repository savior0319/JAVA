package _09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {
	
	
	private JLabel jlkr = new JLabel("Korea money : 0");
	private JLabel jljp = new JLabel("Japan money : 0");
	private JLabel jlcn = new JLabel("China money : 0");
	private JLabel jltt = new JLabel("Total money : 0");
	private JLabel jl = new JLabel("총 금액 : ");
	private JTextField jtf = new JTextField();
	private JButton startB = new JButton("시작");
	private JButton resetB = new JButton("리셋");
	private JPanel jp = new JPanel();
	private JPanel jp1 = new JPanel();
	private Container ct = getContentPane();
	
	public Main() {
		setTitle("멀티 쓰레딩");
		setSize(250,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		ct.setLayout(new BorderLayout());
		
		jp1.setLayout(new GridLayout(4,1));
		jp1.add(jlkr);
		jp1.add(jljp);
		jp1.add(jlcn);
		jp1.add(jltt);
		ct.add(jp1, BorderLayout.NORTH);
	
		jp.setLayout(new GridLayout(1,4));
		jp.add(jtf, JTextField.CENTER);
		jp.add(resetB, JButton.CENTER);
		jp.add(startB, JButton.CENTER);
		jp.add(jtf, JTextField.CENTER);
		jp.add(jl, JLabel.CENTER);
		ct.add(jp, BorderLayout.SOUTH);
		
		startB.addActionListener(this);
		resetB.addActionListener(this);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==startB) {
			money m = new money(jltt, jtf.getText());
			new moneyToThread(jlkr, "Korea", m).start();
			new moneyToThread(jljp, "Japan", m).start();
			new moneyToThread(jlcn, "China", m).start();
			startB.setEnabled(false);
		} else {
			jlkr.setText("Korea money : 0");
			jljp.setText("Japan money : 0");
			jlcn.setText("China money : 0");
			jltt.setText("Total money : 0");
			startB.setEnabled(true);
			jtf.setText(null);
		}
			
	}
}
