/*
 * 자바 Swing 메모장 메뉴바 사용
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
	private JMenuBar jmb = new JMenuBar(); // 메뉴바 추가
	private JMenu m1 = new JMenu("메뉴 (A)"); // 메뉴 목록 추가
	private JMenu m2 = new JMenu("정보 (I)");
	private JMenuItem item0, item1, item2, item3, item4; // m1(메뉴) 목록의 아이템 추가
	private JLabel jl1 = new JLabel("메모장");
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

		jta.setFont(new Font("맑은고딕", Font.BOLD, 13));
		jta.setLineWrap(true);
		ct.add(jsp, BorderLayout.CENTER);
		jl1.setFont(new Font("맑은고딕", Font.PLAIN, 13));
		ct.add(jl1, BorderLayout.SOUTH);

		jmb.add(m1); // 메뉴바에 m1 메뉴 삽입
		jmb.add(m2);
		m1.setMnemonic(KeyEvent.VK_A); // 단축키 설정 ALT + A
		item0 = new JMenuItem("새 문서");
		item0.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		m1.add(item0);

		item1 = new JMenuItem("열 기");
		item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK)); // item1 단축키 설정
		m1.add(item1); // m1 에 아이템1 삽입

		item2 = new JMenuItem("저 장");
		item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK)); // item2 단축키 설정
		m1.add(item2);
		m1.addSeparator();
		item3 = new JMenuItem("종 료");
		item3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK)); // item3 단축키 설정
		m1.add(item3); // m1 에 아이템2 삽입
		setJMenuBar(jmb); // 메뉴바를 프레임에 추가

		item4 = new JMenuItem("프로그램 정보");
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
		if (arg0.getActionCommand() == "새 문서") {
			if (nostring != check.length()) { // 내용이 있을 경우 열기전에 저장
				jl1.setText("내용이 있음. (새로 만들기 전 저장)");
				if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
					fn = jfc.getSelectedFile();
					try {
						fw = new FileWriter(fn + ".txt");
					} catch (IOException e) {
						jl1.setText("쓰기에러.");
					}
					String str = jta.getText();
					bw = new BufferedWriter(fw);
					try {
						for (int i = 0; i < str.length(); i++) { // 띄어쓰기시 줄 바꿈
							if (str.charAt(i) == '\n') {
								bw.newLine();
							} else
								bw.write(str.charAt(i));
						}
						bw.close();
						jl1.setText("파일저장 완료.");
					} catch (IOException e) {
						jl1.setText("쓰기에러.");
					}
				}
				jta.setText(null);
			} else if (nostring == check.length()) {
				jl1.setText("새 문서");
				jta.setText(null);
			}
		}

		else if (arg0.getActionCommand() == "열 기") {
			if (nostring != check.length()) { // 내용이 있을 경우 열기전에 저장
				jl1.setText("내용이 있음. (새로 열기 전 저장)");
				if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
					fn = jfc.getSelectedFile();
					try {
						fw = new FileWriter(fn + ".txt");
					} catch (IOException e) {
						jl1.setText("쓰기에러.");
					}
					String str = jta.getText();
					bw = new BufferedWriter(fw);
					try {
						for (int i = 0; i < str.length(); i++) { // 띄어쓰기시 줄 바꿈
							if (str.charAt(i) == '\n') {
								bw.newLine();
							} else
								bw.write(str.charAt(i));
						}
						bw.close();
						jl1.setText("파일저장 완료.");
					} catch (IOException e) {
						jl1.setText("쓰기에러.");
					}
				}

			} else if (nostring == check.length()) { // 내용이 없을 경우 열기
				jl1.setText("열기");
				if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { // 열기 chooser 생성
					fn = jfc.getSelectedFile();
					try {
						fr = new FileReader(fn);
					} catch (FileNotFoundException e) {
						jl1.setText("파일이 없습니다.");
					}
					br = new BufferedReader(fr);
					String save = new String();
					String read = "";
					try {
						while ((read = br.readLine()) != null) {
							save += read + "\r\n";
							jta.setText(save);
							jl1.setText("파일열기 완료.");
						}
					} catch (IOException e) {
						jl1.setText("파일이 없습니다.");
					}
				}

			}
		} else if (arg0.getActionCommand() == "저 장") {
			jl1.setText("저장");
			if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				fn = jfc.getSelectedFile();
				try {
					fw = new FileWriter(fn + ".txt");
				} catch (IOException e) {
					jl1.setText("쓰기에러.");
				}
				String str = jta.getText();
				bw = new BufferedWriter(fw);
				try {
					for (int i = 0; i < str.length(); i++) { // 띄어쓰기시 줄 바꿈
						if (str.charAt(i) == '\n') {
							bw.newLine();
						} else
							bw.write(str.charAt(i));
					}
					bw.close();
					jl1.setText("파일저장 완료.");
				} catch (IOException e) {
					jl1.setText("쓰기에러.");
				}
			}
		} else if (arg0.getActionCommand() == "종 료") {
			System.exit(0); // 프로그램 종료
		} else if (arg0.getActionCommand() == "프로그램 정보") {
			JOptionPane optionPane = new JOptionPane(new JLabel("2017-12-03 - AHJ", JLabel.CENTER));
			JDialog dialog = optionPane.createDialog("프로그램 정보");
			dialog.setModal(true);
			dialog.setVisible(true);
		}
	}
}