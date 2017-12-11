package _14;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

public class TCP_HL_client extends JFrame implements ActionListener, KeyListener, Runnable {

	private Container ct = getContentPane();
	private JLabel jl_sip = new JLabel("Server IP", JLabel.CENTER);
	private JLabel jl_spo = new JLabel("Server Port", JLabel.CENTER);
	private JLabel jl_null = new JLabel();
	private JLabel jl_con = new JLabel("채팅");
	private JTextArea con = new JTextArea();
	private JScrollPane jsp = new JScrollPane(con, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	private JTextField send_con = new JTextField();
	private JTextField jtf_sip = new JTextField();
	private JTextField jtf_spo = new JTextField();
	private JButton jb_conn = new JButton("접속");
	private JButton jb_send = new JButton("보내기");
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	private String ip;
	private int port;
	private DataInputStream in;
	private DataOutputStream out;
	private Socket socket;
	private String receive;
	private Thread t;

	public TCP_HL_client() {

		setLocation(750, 300);
		setTitle("TCP 하이로우 클라이언트");
		setResizable(false);
		setSize(350, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ct.setLayout(new BorderLayout());
		jp1.setLayout(new GridLayout(2, 3));

		jp1.add(jl_sip);
		jp1.add(jl_spo);
		jp1.add(jl_null);
		jp1.add(jtf_sip);
		jp1.add(jtf_spo);
		jp1.add(jb_conn);

		jp2.setLayout(new BorderLayout());
		jp2.add(jl_con, BorderLayout.WEST);
		jp2.add(send_con, BorderLayout.CENTER);
		jp2.add(jb_send, BorderLayout.EAST);

		// con.setLineWrap(true);
		jb_send.setEnabled(false);
		ct.add(jp1, BorderLayout.NORTH);
		ct.add(jsp, BorderLayout.CENTER);
		ct.add(jp2, BorderLayout.SOUTH);

		jb_conn.addActionListener(this);
		jb_send.addActionListener(this);
		send_con.addKeyListener(this);
		jb_send.addKeyListener(this);

	}

	public static void main(String[] args) {
		new TCP_HL_client().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand() == "접속") {

			ip = jtf_sip.getText();
			port = Integer.parseInt(jtf_spo.getText());
			jb_conn.setEnabled(false);
			jb_send.setEnabled(true);

			try {
				socket = new Socket(ip, port); // 접속할 서버 아이피, 포트
				in = new DataInputStream(socket.getInputStream()); // 받음
				out = new DataOutputStream(socket.getOutputStream()); // 보냄
				con.append("서버 " + ip + " 에 접속 완료.\r\n");
				con.append("하이로우 게임 - 숫자 1~10까지 입력(기회 6번)\n");
				con.transferFocus();
			} catch (Exception e) {
				System.out.println("오류1");
			}

			t = new Thread(this);
			t.start();

		} else if (arg0.getActionCommand() == "보내기") {
			try {
				if(!send_con.getText().equals("")) {
				out.writeUTF(send_con.getText());
				out.flush();
				con.append("나 : " + send_con.getText() + "\r\n");
				send_con.setText("");
				jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
				} else if(send_con.getText().equals("시작")) {
					out.writeUTF("시작");
				}
			} catch (IOException e) {
				System.out.println("오류2");
			}
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				receive = in.readUTF();
				con.append("SYSTEM : " + receive + "\r\n");
				jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
			}
		} catch (Exception e) {
			try {
				socket.close();
				out.close();
			} catch (IOException e1) {
				System.out.println("오류3");
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			try {
				if(!send_con.getText().equals("")) {
				out.writeUTF(send_con.getText());
				out.flush();
				con.append("나 : " + send_con.getText() + "\r\n");
				send_con.setText("");
				jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
				} else if(send_con.getText().equals("시작")) {
					out.writeUTF("시작");
				}
			} catch (IOException e) {
				System.out.println("오류2");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}
}