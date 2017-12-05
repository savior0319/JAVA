package _13;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

public class TCP_chat_server extends JFrame implements ActionListener, Runnable {

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
	private JButton jb_start = new JButton("���� ����");
	private JButton jb_send = new JButton("������");
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	private String ip;
	private int port;
	private String receive;
	private Thread t;

	public TCP_chat_server() {

		setLocation(750, 300);
		setTitle("TCP ä�� ����");
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
		jp1.add(jb_start);

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

		jb_start.addActionListener(this);
		jb_send.addActionListener(this);

	}

	public static void main(String[] args) {
		new TCP_chat_server().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand() == "���� ����") {
			ip = jtf_sip.getText();
			port = Integer.parseInt(jtf_spo.getText());

			jb_start.setEnabled(false);
			jb_send.setEnabled(true);

			System.out.println("������ ������ : " + ip);
			System.out.println("������ ��Ʈ : " + port);

			t = new Thread(this);
			t.start();
			con.append("���� �غ��\r\n");
			con.transferFocus();

		} else if (arg0.getActionCommand() == "������") {
			/*try {
				Socket socket = new Socket(ip, port);
				InputStream in = socket.getInputStream();
				DataInputStream dis = new DataInputStream(in);
				receive = dis.readUTF();
				con.append("Ŭ���̾�Ʈ : " + receive + "\r\n");
				send_con.setText("");
				dis.close();
				socket.close();
			} catch (IOException e) {
				System.out.print("����1");
			} finally {
				send_con.setText("");
			}*/
		}
	}

	@Override
	public void run() {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port);
		} catch (Exception e) {
			System.out.println("����2");
		}
		try {
			//con.append("Ŭ���̾�Ʈ ���� ��ٸ��� ��  \r\n");
			//while (true) {		
				Socket socket = serverSocket.accept();	
				con.append("Ŭ�󸮾�Ʈ�� ���ӵ�\r\n");
			  /*OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				dos.writeUTF(send_con.getText());
				con.append("���� : " + send_con.getText() + "\r\n");
				socket.close();
				dos.close();*/
			//}
		} catch (IOException e) {
			System.out.print("����3");
		} finally {
			send_con.setText("");
		}

	}
}