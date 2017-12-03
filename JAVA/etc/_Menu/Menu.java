/*
 * 자바 Swing 메뉴바 연습
 * 17-12-03
 */
package _Menu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener {

	private Container ct = getContentPane();
	private JLabel jl = new JLabel(" ", JLabel.CENTER);
	private JMenuBar jmb = new JMenuBar(); // 메뉴바 추가
	private JMenu m1 = new JMenu("메뉴 (A)"); // 메뉴 목록 추가
	private JMenuItem item1, item2; // m1(메뉴) 목록의 아이템 추가
	private JLabel jl1 = new JLabel("상태표시줄");

	public Menu() {
		setTitle("메뉴바");
		setSize(300, 200);
		setResizable(false);
		setLocation(800, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ct.setLayout(new BorderLayout());
		jl.setOpaque(true); // JLabel 색상 변경하기 위해 불투명도 값 true로 변경
		jl.setBackground(Color.WHITE);
		jl.setFont(new Font("맑은고딕", Font.BOLD, 20));

		ct.add(jl, BorderLayout.CENTER);
		jl1.setFont(new Font("맑은고딕", Font.PLAIN, 13));
		ct.add(jl1, BorderLayout.SOUTH);

		jmb.add(m1); // 메뉴바에 m1 메뉴 삽입
		m1.setMnemonic(KeyEvent.VK_A); // 단축키 설정 ALT + A
		item1 = new JMenuItem("확 인");
		item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK)); // item1 단축키 설정
		m1.add(item1); // m1 에 아이템1 삽입
		m1.addSeparator();
		item2 = new JMenuItem("종 료");
		item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK)); // item2 단축키 설정
		m1.add(item2); // m1 에 아이템2 삽입
		setJMenuBar(jmb); // 메뉴바를 프레임에 추가

		item1.addActionListener(this);
		item2.addActionListener(this);
	}

	public static void main(String[] args) {
		new Menu().setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand() == "확 인") {
			jl.setText("확인");
			jl1.setText("확인이 선택되었습니다.");
		} else if (arg0.getActionCommand() == "종 료") {
			System.exit(0); // 프로그램 종료
		}
	}
}
