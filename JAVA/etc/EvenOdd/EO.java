package EvenOdd;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EO extends JFrame implements ActionListener, Runnable, KeyListener {

	private Container ct = getContentPane();
	private JLabel jl1 = new JLabel("¼ýÀÚÀÔ·Â : ", JLabel.CENTER);
	private JLabel jl2 = new JLabel(" ", JLabel.CENTER);
	private JTextField jtf = new JTextField();
	private JButton jtb = new JButton("ÆÇº°");
	private JPanel jp1 = new JPanel();
	private Thread t;

	public EO() {

		setTitle("È¦Â¦ÆÇº°");
		setSize(300, 100);
		setLocation(800, 450);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ct.setLayout(new BorderLayout());
		jp1.setLayout(new GridLayout(1, 3));
		jp1.add(jl1);
		jl1.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 15));
		jp1.add(jtf);
		jtf.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 15));
		jp1.add(jtb);
		jtb.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 15));
		jl2.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 20));

		ct.add(jp1, BorderLayout.CENTER);
		ct.add(jl2, BorderLayout.SOUTH);

		jtb.addActionListener(this);
		jtb.addKeyListener(this);
	}

	public static void main(String[] args) {
		new EO().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand() == "ÆÇº°") {
			t = new Thread(this);
			t.start();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			int get = Integer.parseInt(jtf.getText());
			if (get % 2 == 0) {
				jl2.setText(get + "Àº(´Â) Â¦¼öÀÔ´Ï´Ù.");
			} else {
				jl2.setText(get + "Àº(´Â) È¦¼öÀÔ´Ï´Ù.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			t = new Thread(this);
			t.start();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}