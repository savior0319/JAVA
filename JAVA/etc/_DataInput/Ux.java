package _DataInput;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ux extends JFrame implements ActionListener {
	
	private Container ct = getContentPane();
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	private JLabel jl1 = new JLabel("¹øÈ£", JLabel.CENTER);
	private JLabel jl2 = new JLabel("ÀÌ¸§", JLabel.CENTER);
	private JLabel jl3 = new JLabel("»ýÀÏ", JLabel.CENTER);
	private JLabel jl4 = new JLabel("", JLabel.CENTER);
	
	private JTextField jtf1 = new JTextField();
	private JTextField jtf2 = new JTextField();
	private JTextField jtf3 = new JTextField();
	private JButton jbt = new JButton("ÀÔ·Â");
	
	
	
	public Ux() {
		setVisible(true);
		setTitle("DB input");
		setSize(250,250);
		setLocation(500,300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ct.setLayout(new BorderLayout());
		jp1.setLayout(new GridLayout(3,2));
		jp2.setLayout(new GridLayout(2,1));
		jl1.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 15));
		jl2.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 15));
		jl3.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 15));
		jl4.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 15));
		jtf1.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 15));
		jtf2.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 15));
		jtf3.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 15));
		jp1.add(jl1);
		jp1.add(jtf1);
		jp1.add(jl2);
		jp1.add(jtf2);
		jp1.add(jl3);
		jp1.add(jtf3);
		jp1.add(jl4);
		jp2.add(jl4);
		jp2.add(jbt);
		
		ct.add(jp1, BorderLayout.CENTER);
		ct.add(jp2, BorderLayout.SOUTH);
		
		jbt.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO ¹öÆ° µ¿ÀÛ
		String getno = jtf1.getText();
		String getname = jtf2.getText();
		String getbirth = jtf3.getText();
		
		if(arg0.getActionCommand()=="ÀÔ·Â") {
			if((getno.equals("") || getname.equals("") || getbirth.equals(""))){
				jl4.setText("ÀüºÎ ´Ù ÀÔ·ÂÇÏ¼¼¿ä");				
			}
			else {
				new Database(getno, getname, getbirth, jl4);
			}
		}
	}

	

}
