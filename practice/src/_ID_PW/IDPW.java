package _ID_PW;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IDPW extends JFrame implements ActionListener {

	private Container ct = getContentPane();
	private JTextField jtf1 = new JTextField(); // ID
	private JPasswordField jpf = new JPasswordField(); // PW
	private JLabel jl1 = new JLabel("���̵�");
	private JLabel jl2 = new JLabel("��й�ȣ");
	private JButton jb = new JButton("�α���");
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
		jl3.setFont(new Font("�������", Font.PLAIN, 12));
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
		String CID = "admin"; // ID ����
		String CPW = "admin"; // PW ����

		if (arg0.getSource() == jb) {
			if (ID.equals("") || PW.equals("")) {
				jl3.setText("���̵� / ��й�ȣ�� �Է����ּ���.");
			} else if (!ID.equals("") || !PW.equals("")) {
				if (!ID.equals(CID)) {
					jl3.setText("��ϵ� ���̵� �ƴմϴ�.");
				} else if (ID.equals(CID) || !ID.equals(CPW)) {
					jl3.setText("��й�ȣ�� �ٽ� Ȯ���ϼ���.");
					if (ID.equals(CID) && PW.equals(CPW)) {
						jl3.setText("�α��� ����");
						JOptionPane.showMessageDialog(null, CID + "�� �α��� ����", "�α��� �޼���",
								JOptionPane.INFORMATION_MESSAGE, null); // �α��� �˾� �޼���
					}
				}
			}
		}
	}
}