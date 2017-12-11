package _14;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

public class TCP_HL_server extends JFrame implements ActionListener, Runnable {

	private Container ct = getContentPane();
	private JLabel jl_spo = new JLabel("Server Port", JLabel.CENTER);
	private JLabel jl_null = new JLabel();
	private JTextArea con = new JTextArea();
	private JTextField send_con = new JTextField();
	private JTextField jtf_spo = new JTextField();
	private JButton jb_start = new JButton("���� ����");
	private JPanel jp1 = new JPanel();
	private int port;
	private DataInputStream in;
	private DataOutputStream out;
	private Socket socket;
	private ServerSocket serverSocket;
	private String receive;
	private Thread t;
	private int ran;
	private String convert;
	private int count = 0;
	private boolean start = true;
	int i;

	public TCP_HL_server() {

		setLocation(750, 300);
		setTitle("TCP ���̷ο� ����");
		setResizable(false);
		setSize(200, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ct.setLayout(new BorderLayout());
		jp1.setLayout(new GridLayout(2, 2));

		jp1.add(jl_spo);
		jp1.add(jl_null);
		jp1.add(jtf_spo);
		jp1.add(jb_start);

		ct.add(jp1, BorderLayout.NORTH);
		ct.add(con, BorderLayout.CENTER);

		jb_start.addActionListener(this);

		try {
			InetAddress ip = InetAddress.getLocalHost();
			String getip = String.valueOf(ip.getHostAddress());
			con.append("���� ������ : " + getip + "\r\n");
		} catch (Exception e) {
			System.out.println("");
		}

	}

	public static void main(String[] args) {
		new TCP_HL_server().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand() == "���� ����") {

			port = Integer.parseInt(jtf_spo.getText());
			jb_start.setEnabled(false);

			try {
				while (true) {
					System.out.print(port + "�� ��Ʈ ���� �����");
					serverSocket = new ServerSocket(port); // ���� ����� ��Ʈ
					socket = serverSocket.accept(); // ���� ���
					con.append("Ŭ���̾�Ʈ ���� �Ϸ�\r\n");
					in = new DataInputStream(socket.getInputStream()); // ����
					out = new DataOutputStream(socket.getOutputStream()); // ����
					con.transferFocus();
				}
			} catch (IOException e) {
				System.out.println("����1");
			}

			t = new Thread(this);
			t.start();
		}
	}

	public void run() {
		while (start) {
			ran = (int) (Math.random() * 10) + 1;
			convert = String.valueOf(ran);
			System.out.print("������ ���� ���� : " + ran + "\n");

			try {
				con.append("���� : " + convert);

				while (count < 6) {
					receive = in.readUTF();
					int conreceive = Integer.parseInt(receive);
					if (ran > conreceive) {
						out.writeUTF(count + 1 + "��°  : " + receive + "��  ���亸�� �۽��ϴ�");
						out.flush();
						send_con.setText("");
					} else if (ran < conreceive) {
						out.writeUTF(count + 1 + "��° : " + receive + "��  ���亸�� Ů�ϴ�");
						out.flush();
						send_con.setText("");
					} else if (ran == conreceive) {
						out.writeUTF(count + 1 + "��° : " + receive + "��  �����Դϴ�");
						out.flush();
						send_con.setText("");
					}
					count++;
					if (count == 6) {
						out.writeUTF("--6�� ��-- �ٽ� �Ϸ��� \'����\' �ܾ� ����");
						pause();
					} else if (receive.equals("����")) {
						out.writeUTF("���ڰ� �缳�� �Ǿ����ϴ�.");
						t.start();
					}
				}
			} catch (Exception e) {
				try {
					socket.close();
					out.close();
				} catch (IOException e1) {
					System.out.println("����3");
				}
			}
		}
	}
	public void pause() {
		t.interrupt();
	}
}