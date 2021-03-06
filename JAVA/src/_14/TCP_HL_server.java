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
	private JButton jb_start = new JButton("서버 시작");
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
	private int conreceive;

	public TCP_HL_server() {

		setLocation(750, 300);
		setTitle("TCP 하이로우 서버");
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
			con.append("서버 아이피 : " + getip + "\r\n");
		} catch (Exception e) {
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		new TCP_HL_server().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand() == "서버 시작") {

			port = Integer.parseInt(jtf_spo.getText());
			jb_start.setEnabled(false);

			try {
				while (true) {
					System.out.print(port + "번 포트 서버 대기중");
					serverSocket = new ServerSocket(port); // 서버 대기할 포트
					socket = serverSocket.accept(); // 서버 대기
					con.append("클라이언트 접속 완료\r\n");
					in = new DataInputStream(socket.getInputStream()); // 받음
					out = new DataOutputStream(socket.getOutputStream()); // 보냄
					con.transferFocus();
				}
			} catch (IOException e) {
			}

			t = new Thread(this);
			t.start();
		}
	}

	public void run() {
		rannum();
		try {
			while (true) {

				while (count < 5) {
					receive = in.readUTF();
					conreceive = Integer.parseInt(receive);
					if (ran > conreceive) {
						out.writeUTF(count + 1 + "번째  : " + receive + "는  정답보다 작습니다");
						out.flush();
						send_con.setText("");
						count++;
					} else if (ran < conreceive) {
						out.writeUTF(count + 1 + "번째 : " + receive + "는  정답보다 큽니다");
						out.flush();
						send_con.setText("");
						count++;
					} else if (ran == conreceive) {
						out.writeUTF(count + 1 + "번째 : " + receive + "는  정답입니다");
						out.flush();
						send_con.setText("");
						out.writeUTF("다시 시작 하시겠습니까?");
						pause();
						if (receive == "시작") {
							restart();
						}
					}
					if (count == 5) {
						receive = in.readUTF();
						if (ran > conreceive) {
							out.writeUTF(count + 1 + "번째  : " + receive + "는  정답보다 작습니다");
							out.flush();
							send_con.setText("");
							count++;
						} else if (ran < conreceive) {
							out.writeUTF(count + 1 + "번째 : " + receive + "는  정답보다 큽니다");
							out.flush();
							send_con.setText("");
							count++;
						} else if (ran == conreceive) {
							out.writeUTF(count + 1 + "번째 : " + receive + "는  정답입니다");
							out.flush();
							send_con.setText("");
							out.writeUTF("다시 시작 하시겠습니까?");
							pause();
							if (receive == "시작") {
								restart();
							}
						}
						out.writeUTF("--6번 끝-- 다시 하려면 \'시작\' 단어 전송");
						pause();
						if (receive == "시작") {
							restart();
						}
					}
				}
			}

		} catch (Exception e) {
			try {
				socket.close();
				out.close();
			} catch (IOException e1) {
				System.out.println("오류1");
			}
		}
	}

	private void rannum() {
		ran = (int) (Math.random() * 10) + 1;
		convert = String.valueOf(ran);
		con.append("정답 : " + convert + "\n");
	}

	public void pause() {
		count = 0;
		t.interrupt();
		rannum();
		try {
			receive = in.readUTF();
		} catch (IOException e) {
			System.out.println("오류2");
		}
	}

	public void restart() {
		t = new Thread(this);
		t.start();

	}
}