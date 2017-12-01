package _07;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;

public class MemoPad extends JFrame implements ActionListener {
	private String[] btext = {"저장","열기","지우기"};
	private JTextArea jta = new JTextArea();
	private JButton jb[] = new JButton[3];
	private Container ct = getContentPane();
	private JPanel jp = new JPanel();

	public MemoPad() {
		setTitle("간단한 메모장");
		setSize(400,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		ct.setLayout(new BorderLayout());
		ct.add(jta, BorderLayout.CENTER);
		
		jp.setLayout(new GridLayout(1,3));
		for(int i = 0; i<jb.length; i++) {
		jp.add(jb[i] = new JButton(btext[i]));
		jb[i].addActionListener(this);
		}
		ct.add(jp, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MemoPad().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb[0]) {
			
			String str;
			str = jta.getText();
			 try {
				FileWriter fw = new FileWriter(new File("메모.txt"));
				fw.write(str);
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if(e.getSource()==jb[1]) {
			try {
			FileReader fr = new FileReader("메모.txt");
			BufferedReader br = new BufferedReader(fr);
			String read = "";
			String save = new String();
			
			 while((read = br.readLine()) != null){
				save += read + System.lineSeparator();
				}
			
			jta.setText(save);
			fr.close();
	
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
				}
			} else {
			jta.setText(null);
		}	
	}
}
