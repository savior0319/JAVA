package _05;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Vending_machine_combobox extends JFrame implements ActionListener {

	private JLabel jl = new JLabel("����� ���Ǳ�");
	private JComboBox<String> jbb = new JComboBox<String>();
	private JButton jb = new JButton();
	private JTextField jf = new JTextField(20);
	private Container ct = getContentPane();
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	private JPanel jp3 = new JPanel();
	
	public Vending_machine_combobox() {
		setTitle("���Ǳ�");
		setSize(250,180);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ct.setLayout(new GridLayout(4,1,0,0));
		
		jbb.addItem("�ݶ�");
		jbb.addItem("���̴�");
		jbb.addItem("ȯŸ");
		jbb.addItem("����");
		jb.setText("���� ");
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
			if(jbb.getSelectedItem()=="�ݶ�") {
			jf.setText("�ݶ�� 1200���Դϴ�.");
			} else if(jbb.getSelectedItem()=="���̴�") {
			jf.setText("���̴ٴ� 1000���Դϴ�.");
			} else if(jbb.getSelectedItem()=="ȯŸ") {
			jf.setText("ȯŸ 800���Դϴ�.");
			} else if(jbb.getSelectedItem()=="����") {
			jf.setText("���� 500���Դϴ�.");
			}
		}
	}
}
