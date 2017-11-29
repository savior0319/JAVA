package _07;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Conversion extends JFrame implements KeyListener{
	
	private JLabel[] jl = new JLabel[3];
	private JTextField[] jt = new JTextField[2];
	private JComboBox<String> jbox = new JComboBox<String>();
	private Container ct = getContentPane();
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	
	public Conversion(){
		setTitle("진법 변환기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200,200);
		setResizable(false);
		
		ct.setLayout(new BorderLayout());
		
		jp1.setLayout(new GridLayout(3,1));
		jp1.add(jl[0] = new JLabel(" 지수 선택"), JLabel.CENTER);
		jl[0].setFont(new Font("맑은 고딕",Font.BOLD,13));
		jp1.add(jl[1] = new JLabel(" 입력 숫자"), JLabel.CENTER);
		jl[1].setFont(new Font("맑은 고딕",Font.BOLD,13));
		jp1.add(jl[2] = new JLabel(" 출력 결과"), JLabel.CENTER);
		jl[2].setFont(new Font("맑은 고딕",Font.BOLD,13));
		jp2.setLayout(new GridLayout(3,1));
		jbox.addItem("2진수");
		jbox.addItem("10진수");
		jbox.addItem("16진수");
		jp2.add(jbox);
		jp2.add(jt[0] = new JTextField(10));
		jp2.add(jt[1] = new JTextField(10));

		ct.add(jp1, BorderLayout.WEST);
		ct.add(jp2, BorderLayout.EAST);
		
		jt[0].addKeyListener(this);
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		new Conversion().setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(jbox.getSelectedIndex()==0) {
					int get = Integer.parseInt(jt[0].getText());
					String binary = Integer.toBinaryString(get);
					jt[1].setText(binary);
			} 	else if(jbox.getSelectedIndex()==1) {
					jt[1].setText(jt[0].getText());
			}	else if(jbox.getSelectedIndex()==2) {
					int get = Integer.parseInt(jt[0].getText());
					String binary = Integer.toHexString(get);
					jt[1].setText(binary);
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}
}