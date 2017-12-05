package _13;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

public class TCP_chat_client extends JFrame implements ActionListener {

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
	private String receive;
	private Thread t;

	public TCP_chat_client() {

		setLocation(750, 300);
		setTitle("TCP 채팅 클라이언트");
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
		con.setEditable(false);
		jb_send.setEnabled(false);
		ct.add(jp1, BorderLayout.NORTH);
		ct.add(jsp, BorderLayout.CENTER);
		ct.add(jp2, BorderLayout.SOUTH);

		jb_conn.addActionListener(this);
		jb_send.addActionListener(this);

	}

	public static void main(String[] args) {
		new TCP_chat_client().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand() == "접속") {
			ip = jtf_sip.getText();
			port = Integer.parseInt(jtf_spo.getText());

			jb_conn.setEnabled(false);
			jb_send.setEnabled(true);

			try {
				Socket socket = new Socket(ip, port);
				con.append("서버할 IP : " + ip + "\r\n");
				con.append("서버할 Port : " + port + "\r\n");
				con.append("서버와 연결됨\r\n");
				/*InputStream in = socket.getInputStream();
				DataInputStream dis = new DataInputStream(in);
				receive = dis.readUTF();
				con.append("클라이언트 : " + receive + "\r\n");
				send_con.setText("");
				dis.close();
				socket.close();*/
				
			} catch (IOException e) {
				System.out.print("오류1");
			} finally {
				send_con.setText("");
			}
		}
			con.transferFocus();
	
		if (arg0.getActionCommand() == "보내기") {
		System.out.print("");
		}
	}
}

