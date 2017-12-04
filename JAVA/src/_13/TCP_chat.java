package _13;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

public class TCP_chat extends JFrame implements ActionListener, KeyListener, Runnable {

	private Container ct = getContentPane();
	private JLabel jl_mp = new JLabel("My Port", JLabel.CENTER);
	private JLabel jl_yp = new JLabel("Your Port", JLabel.CENTER);
	private JLabel jl_yip = new JLabel("Your IP", JLabel.CENTER);
	private JLabel jl_null = new JLabel();
	private JLabel jl_con = new JLabel("채팅");
	private JTextArea con = new JTextArea();
	private JScrollPane jsp = new JScrollPane(con, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	private JTextField send_con = new JTextField();
	private JTextField jtf_mp = new JTextField();
	private JTextField jtf_yp = new JTextField();
	private JTextField jtf_yip = new JTextField();
	private JButton jb_set = new JButton("설정");
	private JButton jb_send = new JButton("보내기");
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();


	//private Thread t;

	public TCP_chat() {

		setLocation(750, 300);
		setTitle("TCP 채팅");
		setResizable(false);
		setSize(350, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ct.setLayout(new BorderLayout());
		jp1.setLayout(new GridLayout(2, 4));

		jp1.add(jl_mp);
		jp1.add(jl_yp);
		jp1.add(jl_yip);
		jp1.add(jl_null);
		jp1.add(jtf_mp);
		jp1.add(jtf_yp);
		jp1.add(jtf_yip);
		jp1.add(jb_set);

		jp2.setLayout(new BorderLayout());
		jp2.add(jl_con, BorderLayout.WEST);
		jp2.add(send_con, BorderLayout.CENTER);
		jp2.add(jb_send, BorderLayout.EAST);

		// con.setLineWrap(true);
		con.setEditable(false);
		jb_send.setEnabled(false);
		ct.add(jp1, BorderLayout.NORTH);
		ct.add(jsp, BorderLayout.CENTER);
		ct.add(jp2, BorderLayout.SOUTH);

		jb_set.addActionListener(this);
		jb_send.addActionListener(this);
		send_con.addKeyListener(this);
		jb_send.addKeyListener(this);
		jtf_yip.addKeyListener(this);
		jb_set.addKeyListener(this);

	}

	public static void main(String[] args) {
		// TODO Auto-generated stub
		new TCP_chat().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	
	}
}