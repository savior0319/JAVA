package _13;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

public class TCP_chat extends JFrame implements ActionListener, Runnable {

	private Container ct = getContentPane();
	private JLabel jl_sip = new JLabel("Server IP", JLabel.CENTER);
	private JLabel jl_spo = new JLabel("Server Port", JLabel.CENTER);
	private JLabel jl_null = new JLabel();
	private JLabel jl_con = new JLabel("ä��");
	private JTextArea con = new JTextArea();
	private JScrollPane jsp = new JScrollPane(con, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	private JTextField send_con = new JTextField();
	private JTextField jtf_sip = new JTextField();
	private JTextField jtf_spo = new JTextField();
	private JButton jb_conn = new JButton("����");
	private JButton jb_send = new JButton("������");
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();

	private String ip;
	private int port;
	private String receive;
	private Thread t;
	ServerSocket serverSocket = null;

	public TCP_chat() {

		setLocation(750, 300);
		setTitle("TCP ä��");
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
		// TODO Auto-generated stub
		new TCP_chat().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getActionCommand() == "����") {

			ip = jtf_sip.getText();
			port = Integer.parseInt(jtf_spo.getText());

			jb_conn.setEnabled(false);
			jb_send.setEnabled(true);

			System.out.println("������ ������ : " + ip);
			System.out.println("������ ��Ʈ : " + port);

			t = new Thread(this);
			t.start();
				
		} else if (arg0.getActionCommand() == "������"){
			try {
				Socket socket = new Socket(ip, port);
				while (true) {
					InputStream in = socket.getInputStream();
					DataInputStream dis = new DataInputStream(in);
					receive = dis.readUTF();
					con.setText("Ŭ���̾�Ʈ : " + receive + "\r\n");
					dis.close();
					socket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.print("����1");
			}		
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("���� �غ� �Ϸ�");
		} catch (Exception e) {
			System.out.print("����2");
		}
		while (true) {
			try {
				Socket socket = serverSocket.accept();
				System.out.println("Ŭ���̾�Ʈ ���� ��û" + "\r\n");
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				dos.writeUTF(send_con.getText());
				con.append("���� : " + send_con.getText());
				//dos.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.print("����3");
			}
		}
	}
}