package _ID_PW;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IDPW extends JFrame implements ActionListener {

	private Container ct = getContentPane();
	private JTextField jtf1 = new JTextField(); // ID
	private JPasswordField jpf = new JPasswordField(); // PW
	private JLabel jl1 = new JLabel("아이디");
	private JLabel jl2 = new JLabel("비밀번호");
	private JButton jb = new JButton("로그인");
	private JLabel jl3 = new JLabel("");

	public IDPW() {
		setTitle("ID & PW");
		setSize(290, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);

		jl1.setBounds(23, 10, 40, 30);
		jtf1.setBounds(80, 12, 100, 25);
		jl2.setBounds(10, 50, 60, 30);
		jpf.setBounds(80, 52, 100, 25);
		jb.setBounds(185, 12, 75, 65);
		jl3.setBounds(75, 85, 200, 20);
		jl3.setFont(new Font("맑은고딕", Font.PLAIN, 12));
		ct.add(jl1);
		ct.add(jtf1);
		ct.add(jl2);
		ct.add(jpf);
		ct.add(jb);
		ct.add(jl3);

		jb.addActionListener(this);
	}

	public static void main(String args[]) {
		new IDPW().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String ID = jtf1.getText();
		char[] pass = jpf.getPassword(); // getPassword(JPasswordField)
		String PW = new String(pass); // char[] pass -> Sting PW
		String CID = "admin"; // ID 지정
		String CPW = "admin"; // PW 지정

		if (arg0.getSource() == jb) {
			if (ID.equals("") || PW.equals("")) {
				jl3.setText("아이디 / 비밀번호를 입력해주세요.");
			} else if (!ID.equals("") || !PW.equals("")) {
				if (!ID.equals(CID)) {
					jl3.setText("등록된 아이디가 아닙니다.");
				} else if (ID.equals(CID) || !ID.equals(CPW)) {
					jl3.setText("비밀번호를 다시 확인하세요.");
					if (ID.equals(CID) && PW.equals(CPW)) {
						jl3.setText("로그인 성공");
						JOptionPane.showMessageDialog(null, CID + "님 로그인 성공", "로그인 메세지",
								JOptionPane.INFORMATION_MESSAGE, null); // 로그인 팝업 메세지
					}
				}
			}
		}
	}
}