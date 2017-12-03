/*
 * �ڹ� Swing �޴��� ����
 * 17-12-03
 */
package _memoPad_useMenubar;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener {

	private Container ct = getContentPane();
	private JTextArea jta = new JTextArea();
	private JScrollPane jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	private JMenuBar jmb = new JMenuBar(); // �޴��� �߰�
	private JMenu m1 = new JMenu("�޴� (A)"); // �޴� ��� �߰�
	private JMenuItem item1, item2, item3; // m1(�޴�) ����� ������ �߰�
	private JLabel jl1 = new JLabel("����ǥ����");
	private String fn;
	private String readtxt = "";
	private FileReader fr;
	private FileWriter fw;

	public Menu() {
		setTitle("�޴���");
		setSize(400, 300);
		setResizable(false);
		setLocation(750, 380);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ct.setLayout(new BorderLayout());

		jta.setFont(new Font("�������", Font.BOLD, 13));
		jta.setLineWrap(true);
		ct.add(jsp, BorderLayout.CENTER);
		jl1.setFont(new Font("�������", Font.PLAIN, 13));
		ct.add(jl1, BorderLayout.SOUTH);

		jmb.add(m1); // �޴��ٿ� m1 �޴� ����
		m1.setMnemonic(KeyEvent.VK_A); // ����Ű ���� ALT + A
		item1 = new JMenuItem("�� ��");
		item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK)); // item1 ����Ű ����
		m1.add(item1); // m1 �� ������1 ����
		m1.addSeparator();
		item2 = new JMenuItem("�� ��");
		item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK)); // item2 ����Ű ����
		m1.add(item2);
		m1.addSeparator();
		item3 = new JMenuItem("�� ��");
		item3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK)); // item3 ����Ű ����
		m1.add(item3); // m1 �� ������2 ����
		setJMenuBar(jmb); // �޴��ٸ� �����ӿ� �߰�

		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
	}

	public static void main(String[] args) {
		new Menu().setVisible(true);
	}
	
	


	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand() == "�� ��") {
			FileDialog fileOpen = new FileDialog(this, "���� ����", FileDialog.LOAD);
			FilenameFilter filter = new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return name.toLowerCase().endsWith(".txt");
				}
			};
			fileOpen.setFilenameFilter(filter);
			fileOpen.setDirectory("C:\\");
			fileOpen.setVisible(true);
			fn = fileOpen.getDirectory() + fileOpen.getFile();

			try {
				fr = new FileReader(fn);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			BufferedReader br = new BufferedReader(fr);
			try {
				while ((readtxt = br.readLine()) != null) {
					jta.setText(readtxt);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else if (arg0.getActionCommand() == "�� ��") {
			FileDialog fileSave = new FileDialog(this, "�ٸ� �̸����� ����", FileDialog.SAVE);
			FilenameFilter filter = new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return name.toLowerCase().endsWith(".txt");
				}
			};
			fileSave.setFilenameFilter(filter);
			fileSave.setDirectory("C:\\");
			fileSave.setVisible(true);
			fn = fileSave.getDirectory() + fileSave.getFile();
			String str = jta.getText();

			try {
				fw = new FileWriter(fn);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fw.write(str);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			jl1.setText("�������� �Ϸ�.");

		} else {
			System.exit(0); // ���α׷� ����
		}

	}
}
