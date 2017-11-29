package _12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UDP_chat extends JFrame implements ActionListener, KeyListener, Runnable {

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

	private int myport;
	private int yourport;
	private String yourip;

	private Thread t;

	public UDP_chat() {

		setLocation(750, 300);
		setTitle("UDP 채팅");
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
	}

	public static void main(String[] args) {
		// TODO Auto-generated stub
		new UDP_chat().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		if (arg0.getActionCommand() == "설정") {
			myport = Integer.parseInt(jtf_mp.getText());
			yourport = Integer.parseInt(jtf_yp.getText());
			yourip = jtf_yip.getText();
			jb_send.setEnabled(true);
			jb_set.setEnabled(false);

			t = new Thread(this);
			t.start();

		} else if (arg0.getActionCommand() == "보내기") {

			DatagramSocket socket;
			try {
				socket = new DatagramSocket();
				String s = send_con.getText();
				byte[] buf = s.getBytes();
				InetAddress addr = InetAddress.getByName(yourip);
				DatagramPacket packet = new DatagramPacket(buf, buf.length, addr, myport);
				socket.send(packet);
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				String time = sdf.format(new Date());
				con.append("[" + time + "] 나 : " + s + "\r\n");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			DatagramSocket socket;
			try {
				socket = new DatagramSocket();
				String s = send_con.getText();
				byte[] buf = s.getBytes();
				InetAddress addr = InetAddress.getByName(yourip);
				DatagramPacket packet = new DatagramPacket(buf, buf.length, addr, myport);
				socket.send(packet);
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				String time = sdf.format(new Date());
				con.append("[" + time + "] 나 : " + s + "\r\n");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		DatagramSocket socket;
		try {
			socket = new DatagramSocket(yourport);
			while (true) {
				byte[] buf = new byte[50];
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				String str = new String(packet.getData());
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				String time = sdf.format(new Date());
				con.append("[" + time + "] 상대 : " + str + "\r\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}