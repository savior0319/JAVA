package _06;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grade extends JFrame implements ActionListener{
	
	String domain[] = {"이름","국어","영어","수학","평균"};
	String data[][] = new String[0][0];
	String subject[] = {"이름","국어","영어","수학",""};

	private DefaultTableModel model = new DefaultTableModel(data,domain);
	private JTable jt = new JTable(model);
	private JScrollPane jp = new JScrollPane(jt);
	private JLabel jl[] = new JLabel[5];
	private JTextField jf[] = new JTextField[4];
	private JButton  jb = new JButton();
	private Container ct = getContentPane();
	private JPanel pan = new JPanel();
	
	public Grade() {
		setTitle("점수 관리 프로그램");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		ct.setLayout(new BorderLayout());
		pan.setLayout(new GridLayout(2,5));
		
		for(int i = 0; i<subject.length; i++) {
		pan.add(jl[i] = new JLabel(subject[i], JLabel.CENTER));
		}
		for(int i = 0; i<subject.length-1; i++) { 
		pan.add(jf[i] = new JTextField());
		}
		jb.setText("추가");
		pan.add(jb);
		
		ct.add(jp, BorderLayout.CENTER);
		ct.add(pan, BorderLayout.SOUTH);
		
		jb.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Grade().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb) {
			String name = jf[0].getText();
			String korean = jf[1].getText();
			String english = jf[2].getText();
			String math = jf[3].getText();
			int koreanint = Integer.parseInt(korean);
			int englishint = Integer.parseInt(english);
			int mathint = Integer.parseInt(math);
			double avg = ((double)koreanint + (double)englishint + (double)mathint)/3;
			model.addRow(new Object[]{name,korean,english,math,(int)avg});
		    jt.updateUI();
		}
	}
}
