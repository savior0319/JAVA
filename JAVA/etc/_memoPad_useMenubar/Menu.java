/*
 * 자바 Swing 메뉴바 연습
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
	private JMenuBar jmb = new JMenuBar(); // 메뉴바 추가
	private JMenu m1 = new JMenu("메뉴 (A)"); // 메뉴 목록 추가
	private JMenuItem item1, item2, item3; // m1(메뉴) 목록의 아이템 추가
	private JLabel jl1 = new JLabel("상태표시줄");
	private String fn;
	private String readtxt = "";
	private FileReader fr;
	private FileWriter fw;

	public Menu() {
		setTitle("메뉴바");
		setSize(400, 300);
		setResizable(false);
		setLocation(750, 380);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ct.setLayout(new BorderLayout());

		jta.setFont(new Font("맑은고딕", Font.BOLD, 13));
		jta.setLineWrap(true);
		ct.add(jsp, BorderLayout.CENTER);
		jl1.setFont(new Font("맑은고딕", Font.PLAIN, 13));
		ct.add(jl1, BorderLayout.SOUTH);

		jmb.add(m1); // 메뉴바에 m1 메뉴 삽입
		m1.setMnemonic(KeyEvent.VK_A); // 단축키 설정 ALT + A
		item1 = new JMenuItem("열 기");
		item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK)); // item1 단축키 설정
		m1.add(item1); // m1 에 아이템1 삽입
		m1.addSeparator();
		item2 = new JMenuItem("저 장");
		item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK)); // item2 단축키 설정
		m1.add(item2);
		m1.addSeparator();
		item3 = new JMenuItem("종 료");
		item3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK)); // item3 단축키 설정
		m1.add(item3); // m1 에 아이템2 삽입
		setJMenuBar(jmb); // 메뉴바를 프레임에 추가

		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
	}

	public static void main(String[] args) {
		new Menu().setVisible(true);
	}
	
	


	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand() == "열 기") {
			FileDialog fileOpen = new FileDialog(this, "파일 열기", FileDialog.LOAD);
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

		} else if (arg0.getActionCommand() == "저 장") {
			FileDialog fileSave = new FileDialog(this, "다른 이름으로 저장", FileDialog.SAVE);
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
			jl1.setText("파일저장 완료.");

		} else {
			System.exit(0); // 프로그램 종료
		}

	}
}
