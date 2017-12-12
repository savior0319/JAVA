package _14;

import java.awt.*;
import java.awt.event.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class UDP_calculator extends JFrame implements ActionListener, Runnable {

	private Container ct = getContentPane();
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	private JPanel jp3 = new JPanel();
	private JLabel jl1 = new JLabel("Server IP", JLabel.CENTER);
	private JLabel jl2 = new JLabel("Server Port", JLabel.CENTER);
	private JLabel jl3 = new JLabel("");
	private JTextField jtf1 = new JTextField();
	private JTextField jtf2 = new JTextField();
	private JButton jbt = new JButton("Á¢¼Ó");
	private JButton[] jbt1 = new JButton[20];
	private JTextArea jta = new JTextArea();
	private JScrollPane jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	private JTextField jtf3 = new JTextField();
	private Thread t;
	private String sp[] = null;
	private String temp = "";
	private int num1;
	private int num2;
	private int result;
	private String strresult;
	private int yourport;
	// private int myport;
	private String yourip;

	String[] bt = { "+", "-", "*", "/", "7", "8", "9", "%", "4", "5", "6", "(", "1", "2", "3", ")", "0", ".", "=",
			"¡ç" };

	public UDP_calculator() {
		setTitle("UDP °è»ê±â");
		setSize(400, 700);
		setLocation(750, 150);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ct.setLayout(new BorderLayout());
		jp1.setLayout(new GridLayout(2, 3));
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jtf1);
		jp1.add(jtf2);
		jp1.add(jbt);
		jp2.setLayout(new BorderLayout());
		jtf3.setEditable(false);
		jtf3.setHorizontalAlignment(SwingConstants.RIGHT);
		jtf3.setBackground(Color.WHITE);
		jtf3.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 20));
		jta.setEditable(false);
		jp2.add(jsp, BorderLayout.CENTER);
		jp2.add(jtf3, BorderLayout.SOUTH);
		jp3.setLayout(new GridLayout(5, 4, 3, 3));
		for (int i = 0; i < bt.length; i++) {
			jbt1[i] = new JButton(bt[i]);
			jbt1[i].setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 20));
			jp3.add(jbt1[i]);
			jbt1[i].addActionListener(this);

		}

		ct.add(jp1, BorderLayout.NORTH);
		ct.add(jp2, BorderLayout.CENTER);
		ct.add(jp3, BorderLayout.SOUTH);

		jbt.addActionListener(this);

	}

	public static void main(String[] args) {
		new UDP_calculator().setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		// "+", "-", "*", "/", "7", "8", "9", "%", "4", "5", "6", "(", "1", "2", "3",
		// ")", "0", ".", "=", "¡ç"

		if (arg0.getSource() == jbt) {
			// myport = Integer.parseInt(jl2.getText());
			yourport = Integer.parseInt(jtf2.getText());
			yourip = jtf1.getText();
			jbt.setEnabled(false);

			t = new Thread(this);
			t.start();
		}

		else if (arg0.getSource() == jbt1[0]) {
			jtf3.setText(jtf3.getText() + "+");
			temp += "+";
		} else if (arg0.getSource() == jbt1[1]) {
			jtf3.setText(jtf3.getText() + "-");
			temp += "-";
		} else if (arg0.getSource() == jbt1[2]) {
			jtf3.setText(jtf3.getText() + "*");
			temp += "*";
		} else if (arg0.getSource() == jbt1[3]) {
			jtf3.setText(jtf3.getText() + "/");
			temp += "/";
		} else if (arg0.getSource() == jbt1[4]) {
			jtf3.setText(jtf3.getText() + "7");
			temp += "7";
		} else if (arg0.getSource() == jbt1[5]) {
			jtf3.setText(jtf3.getText() + "8");
			temp += "8";
		} else if (arg0.getSource() == jbt1[6]) {
			jtf3.setText(jtf3.getText() + "9");
			temp += "9";
		} else if (arg0.getSource() == jbt1[7]) {
			jtf3.setText(jtf3.getText() + "%");
			temp += "%";
		} else if (arg0.getSource() == jbt1[8]) {
			jtf3.setText(jtf3.getText() + "4");
			temp += "4";
		} else if (arg0.getSource() == jbt1[9]) {
			jtf3.setText(jtf3.getText() + "5");
			temp += "5";
		} else if (arg0.getSource() == jbt1[10]) {
			jtf3.setText(jtf3.getText() + "6");
			temp += "6";
		} else if (arg0.getSource() == jbt1[11]) {
			jtf3.setText(jtf3.getText() + "(");
			temp += "(";
		} else if (arg0.getSource() == jbt1[12]) {
			jtf3.setText(jtf3.getText() + "1");
			temp += "1";
		} else if (arg0.getSource() == jbt1[13]) {
			jtf3.setText(jtf3.getText() + "2");
			temp += "2";
		} else if (arg0.getSource() == jbt1[14]) {
			jtf3.setText(jtf3.getText() + "3");
			temp += "3";
		} else if (arg0.getSource() == jbt1[15]) {
			jtf3.setText(jtf3.getText() + ")");
			temp += ")";
		} else if (arg0.getSource() == jbt1[16]) {
			jtf3.setText(jtf3.getText() + "0");
			temp += "0";
		} else if (arg0.getSource() == jbt1[17]) {
			jtf3.setText(jtf3.getText() + ".");
			temp += ".";
		} else if (arg0.getSource() == jbt1[18]) {
			jtf3.setText(jtf3.getText() + "=");
			DatagramSocket socket;
			try {
				socket = new DatagramSocket();
				String s = temp;

				if (temp.contains("+")) {
					sp = s.split("\\+");
					num1 = Integer.parseInt(sp[0]);
					num2 = Integer.parseInt(sp[1]);
					result = num1 + num2;
					strresult = String.valueOf(result);
				} else if (temp.contains("-")) {
					sp = s.split("\\-");
					num1 = Integer.parseInt(sp[0]);
					num2 = Integer.parseInt(sp[1]);
					result = num1 - num2;
					strresult = String.valueOf(result);
				} else if (temp.contains("/")) {
					sp = s.split("\\/");
					num1 = Integer.parseInt(sp[0]);
					num2 = Integer.parseInt(sp[1]);
					result = num1 / num2;
					strresult = String.valueOf(result);
				} else if (temp.contains("*")) {
					sp = s.split("\\*");
					num1 = Integer.parseInt(sp[0]);
					num2 = Integer.parseInt(sp[1]);
					result = num1 * num2;
					strresult = String.valueOf(result);
				}
				
				byte[] buf = (temp + " = " + strresult).getBytes();
				InetAddress addr = InetAddress.getByName(yourip);
				DatagramPacket packet = new DatagramPacket(buf, buf.length, addr, 7777);
				socket.send(packet);
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				String time = sdf.format(new Date());
				jta.append("[" + time + "] ³ª(º»ÀÎ) : " + temp + "\r\n");
				jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
				temp = "";
				jtf3.setText("");
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (arg0.getSource() == jbt1[19]) {
			jtf3.setText("" + jtf3.getText().substring(0, jtf3.getText().length() - 1));
		}
	}

	public void run() {
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
				jta.append("[" + time + "] »ó´ë(¼­¹ö) : " + str + "\r\n");
				jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
