package _05;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Vending_machine_combobox extends JFrame implements ActionListener {

	private JLabel jl = new JLabel("음료수 자판기");
	private JComboBox<String> jbb = new JComboBox<String>();
	private JButton jb = new JButton();
	private JTextField jf = new JTextField(20);
	private Container ct = getContentPane();
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	private JPanel jp3 = new JPanel();
	
	public Vending_machine_combobox() {
		setTitle("자판기");
		setSize(250,180);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ct.setLayout(new GridLayout(4,1,0,0));
		
		jbb.addItem("콜라");
		jbb.addItem("사이다");
		jbb.addItem("환타");
		jbb.addItem("생수");
		jb.setText("선택 ");
		jf.setEditable(false);
		
		jp1.add(jl, BorderLayout.CENTER);
		ct.add(jp1);
		jp2.add(jbb, BorderLayout.CENTER);
		ct.add(jp2);
	    ct.add(jb, BorderLayout.CENTER);
	    jp3.add(jf, BorderLayout.CENTER);
	    ct.add(jp3);
	    
	    jb.addActionListener(this);
	    jbb.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new Vending_machine_combobox().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getSource()==jb) {
			if(jbb.getSelectedItem()=="콜라") {
			jf.setText("콜라는 1200원입니다.");
			} else if(jbb.getSelectedItem()=="사이다") {
			jf.setText("사이다는 1000원입니다.");
			} else if(jbb.getSelectedItem()=="환타") {
			jf.setText("환타 800원입니다.");
			} else if(jbb.getSelectedItem()=="생수") {
			jf.setText("생수 500원입니다.");
			}
		}
	}
}
