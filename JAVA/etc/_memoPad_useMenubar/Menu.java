/*
 * �ڹ� Swing �޸��� �޴��� ���
 * 17-12-03
 */
package _memoPad_useMenubar;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Menu extends JFrame implements ActionListener {

	private Container ct = getContentPane();
	private JTextArea jta = new JTextArea();
	private JScrollPane jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	private JMenuBar jmb = new JMenuBar(); // �޴��� �߰�
	private JMenu m1 = new JMenu("�޴� (A)"); // �޴� ��� �߰�
	private JMenuItem item1, item2, item3; // m1(�޴�) ����� ������ �߰�
	private JLabel jl1 = new JLabel("����ǥ����");
	private File fn;
	private String readtxt = "";
	private FileReader fr;
	private FileWriter fw;
	private String userDir = System.getProperty("user.home");
	private JFileChooser jfc = new JFileChooser(userDir + "/Desktop");
	private BufferedReader br;
	private BufferedWriter bw;

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
		jfc.setFileFilter(new FileNameExtensionFilter(".txt", "txt"));
	}

	public static void main(String[] args) {
		new Menu().setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getActionCommand() == "�� ��") {
			if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				fn = jfc.getSelectedFile();
				try {
					fr = new FileReader(fn);
				} catch (FileNotFoundException e) {
					jl1.setText("������ �����ϴ�.");
				}
				br = new BufferedReader(fr);
				try {
					while ((readtxt = br.readLine()) != null) {
						jta.setText(readtxt);
					}
				} catch (IOException e) {
					jl1.setText("������ �����ϴ�.");
				}
			}
			jl1.setText("���Ͽ��� �Ϸ�.");
		} else if (arg0.getActionCommand() == "�� ��") {

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
					for (int i = 0; i < str.length(); i++) {
						if (str.charAt(i) == '\n') {
							bw.newLine();
						} else
							bw.write(str.charAt(i));
					}
					bw.close();
				} catch (IOException e) {
					jl1.setText("���⿡��.");
				}
				jl1.setText("�������� �Ϸ�.");

			}
		} else {
			System.exit(0); // ���α׷� ����
		}
	}
}
