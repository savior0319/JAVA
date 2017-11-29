package _06;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class MineFindGame extends JFrame implements ActionListener {
	
	private JButton[] jb = new JButton[25];
	private String[] str = new String[25];
	private Container ct = getContentPane();
	private Random rd = new Random();
	private int i = 0;
	public MineFindGame() {
		setTitle("Áö·ÚÃ£±â");
		setSize(300,300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		for(i = 0; i<25; i++) {
			str[i] = String.valueOf(i+1);
		}
		ct.setLayout(new GridLayout(5,5));
		for(i = 0; i<jb.length; i++) {
		ct.add(jb[i] = new JButton(str[i]));
		jb[i].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		jb[i].addActionListener(this);
		}
	}
	
public static void main(String[] args) {
	 new MineFindGame().setVisible(true);
	}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub

	for(i = 0; i<jb.length; i++) {
	if(e.getSource()==jb[i]) {
		int mine = rd.nextInt(25)+1;
		int strmine = Integer.parseInt(str[i]);
		if(strmine+1==mine) {
			jb[i].setBackground(Color.BLACK);
		} else 
			jb[i].setEnabled(false);
			}
		}	
	}
}
