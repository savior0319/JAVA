package _03;
import java.awt.*;
import javax.swing.*;

public class Vending_machine extends JFrame {
	
	private JTextField jf1 = new JTextField("���Աݾ�");
	private JButton jb1 = new JButton("�ݶ�(1000)");
	private JButton jb2 = new JButton("���̴�(800)");
	private JButton jb3 = new JButton("ȯŸ(700)");
	private JButton jb4 = new JButton("");
	private JTextField jf2 = new JTextField("��ȯ�ݾ�");
	private JPanel jp1 = new JPanel(); // ��ư 4�� �г�
	private Container ct = getContentPane();
	
	public Vending_machine() {
		setTitle("���Ǳ� UI �����");
		setSize(300,200);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ct.setLayout(new BorderLayout()); // ��ü  ���̾ƿ� -border

		jp1.setLayout(new GridLayout(2,2,0,0)); // ��ư ���̾ƿ� 2*2 -grid
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		jp1.add(jb4);
	
		/*��ġ*/
		ct.add(jf1, BorderLayout.NORTH); 
		ct.add(jf2, BorderLayout.SOUTH);
		ct.add(jp1, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Vending_machine();
	}

}
