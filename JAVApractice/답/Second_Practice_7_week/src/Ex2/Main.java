package Ex2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Main {
	public static void main(String[] args) {
		new WindowFrame().setVisible(true);
	}
}

class WindowFrame extends JFrame implements ActionListener{
	JTextArea ja = new JTextArea();
	JButton save = new JButton("저장");
	JButton open = new JButton("열기");
	JButton clean = new JButton("지우기");
	public WindowFrame() {
		
		Container con = getContentPane();
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(1, 3));
		con.setLayout(new BorderLayout());
		
		jp.add(save);
		jp.add(open);
		jp.add(clean);
		
		con.add(ja, BorderLayout.CENTER);
		con.add(jp,BorderLayout.SOUTH);
		
		save.addActionListener(this);
		open.addActionListener(this);
		clean.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,600);
		setTitle("간단한 메모장");
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == save){
			String str = ja.getText();
			try {
				FileWriter fw = new FileWriter(new File("test.txt"));
				fw.write(str);
				fw.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			ja.setText("");
		}
		if(e.getSource() == open){
			String temp = new String();
			try {
				BufferedReader br = new BufferedReader(new FileReader(new File("test.txt")));
				String str = "";
				while((str = br.readLine()) != null){
					temp += str;
					temp += "\r\n";
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
			ja.setText(temp);
			System.out.println("출력 되었습니다.");
		}
		if(e.getSource() == clean){
			ja.setText("");
		}
	}
	
}