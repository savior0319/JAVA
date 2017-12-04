/*
 * �ڹ� Swing �޸��� �޴��� ���
 * 17-12-03
 */
package MemoPad_Menubar;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MemoPad extends JFrame implements ActionListener {

	private Container ct = getContentPane();
	private JTextArea jta = new JTextArea();
	private JScrollPane jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	private JMenuBar jmb = new JMenuBar(); // �޴��� �߰�
	private JMenu m1 = new JMenu("�޴� (A)"); // �޴� ��� �߰�
	private JMenu m2 = new JMenu("���� (I)");
	private JMenuItem item0, item1, item2, item3, item4; // m1(�޴�) ����� ������ �߰�
	private JLabel jl1 = new JLabel("�޸���");
	private File fn;
	private FileReader fr;
	private FileWriter fw;
	private String userDir = System.getProperty("user.home");
	private JFileChooser jfc = new JFileChooser(userDir + "/Desktop");
	private BufferedReader br;
	private BufferedWriter bw;

	public MemoPad() {
		setTitle("Memopad");
		setSize(600, 500);
		// setResizable(false);
		setLocation(650, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ct.setLayout(new BorderLayout());

		jta.setFont(new Font("�������", Font.BOLD, 13));
		jta.setLineWrap(true);
		ct.add(jsp, BorderLayout.CENTER);
		jl1.setFont(new Font("�������", Font.PLAIN, 13));
		ct.add(jl1, BorderLayout.SOUTH);

		jmb.add(m1); // �޴��ٿ� m1 �޴� ����
		jmb.add(m2);
		m1.setMnemonic(KeyEvent.VK_A); // ����Ű ���� ALT + A
		item0 = new JMenuItem("�� ����");
		item0.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		m1.add(item0);

		item1 = new JMenuItem("�� ��");
		item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK)); // item1 ����Ű ����
		m1.add(item1); // m1 �� ������1 ����

		item2 = new JMenuItem("�� ��");
		item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK)); // item2 ����Ű ����
		m1.add(item2);
		m1.addSeparator();
		item3 = new JMenuItem("�� ��");
		item3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK)); // item3 ����Ű ����
		m1.add(item3); // m1 �� ������2 ����
		setJMenuBar(jmb); // �޴��ٸ� �����ӿ� �߰�

		item4 = new JMenuItem("���α׷� ����");
		m2.add(item4);

		item0.addActionListener(this);
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		item4.addActionListener(this);
		jfc.setFileFilter(new FileNameExtensionFilter(".txt", "txt"));
	}

	public static void main(String[] args) {
		new MemoPad().setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		String check = jta.getText();
		int nostring = 0;
		if (arg0.getActionCommand() == "�� ����") {
			if (nostring != check.length()) { // ������ ���� ��� �������� ����
				jl1.setText("������ ����. (���� ����� �� ����)");
				if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
					fn = jfc.getSelectedFile();
					try {
						fw = new FileWriter(fn + ".txt");
					} catch (IOException e) {
						jl1.setText("���⿡��.");
					}
					String str = jta.getText();
					bw = new BufferedWriter(fw);
					try {
						for (int i = 0; i < str.length(); i++) { // ����� �� �ٲ�
							if (str.charAt(i) == '\n') {
								bw.newLine();
							} else
								bw.write(str.charAt(i));
						}
						bw.close();
						jl1.setText("�������� �Ϸ�.");
					} catch (IOException e) {
						jl1.setText("���⿡��.");
					}
				}
				jta.setText(null);
			} else if (nostring == check.length()) {
				jl1.setText("�� ����");
				jta.setText(null);
			}
		}

		else if (arg0.getActionCommand() == "�� ��") {
			if (nostring != check.length()) { // ������ ���� ��� �������� ����
				jl1.setText("������ ����. (���� ���� �� ����)");
				if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
					fn = jfc.getSelectedFile();
					try {
						fw = new FileWriter(fn + ".txt");
					} catch (IOException e) {
						jl1.setText("���⿡��.");
					}
					String str = jta.getText();
					bw = new BufferedWriter(fw);
					try {
						for (int i = 0; i < str.length(); i++) { // ����� �� �ٲ�
							if (str.charAt(i) == '\n') {
								bw.newLine();
							} else
								bw.write(str.charAt(i));
						}
						bw.close();
						jl1.setText("�������� �Ϸ�.");
					} catch (IOException e) {
						jl1.setText("���⿡��.");
					}
				}

			} else if (nostring == check.length()) { // ������ ���� ��� ����
				jl1.setText("����");
				if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { // ���� chooser ����
					fn = jfc.getSelectedFile();
					try {
						fr = new FileReader(fn);
					} catch (FileNotFoundException e) {
						jl1.setText("������ �����ϴ�.");
					}
					br = new BufferedReader(fr);
					String save = new String();
					String read = "";
					try {
						while ((read = br.readLine()) != null) {
							save += read + "\r\n";
							jta.setText(save);
							jl1.setText("���Ͽ��� �Ϸ�.");
						}
					} catch (IOException e) {
						jl1.setText("������ �����ϴ�.");
					}
				}

			}
		} else if (arg0.getActionCommand() == "�� ��") {
			jl1.setText("����");
			if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				fn = jfc.getSelectedFile();
				try {
					fw = new FileWriter(fn + ".txt");
				} catch (IOException e) {
					jl1.setText("���⿡��.");
				}
				String str = jta.getText();
				bw = new BufferedWriter(fw);
				try {
					for (int i = 0; i < str.length(); i++) { // ����� �� �ٲ�
						if (str.charAt(i) == '\n') {
							bw.newLine();
						} else
							bw.write(str.charAt(i));
					}
					bw.close();
					jl1.setText("�������� �Ϸ�.");
				} catch (IOException e) {
					jl1.setText("���⿡��.");
				}
			}
		} else if (arg0.getActionCommand() == "�� ��") {
			System.exit(0); // ���α׷� ����
		} else if (arg0.getActionCommand() == "���α׷� ����") {
			JOptionPane optionPane = new JOptionPane(new JLabel("2017-12-03 - AHJ", JLabel.CENTER));
			JDialog dialog = optionPane.createDialog("���α׷� ����");
			dialog.setModal(true);
			dialog.setVisible(true);
		}
	}
}