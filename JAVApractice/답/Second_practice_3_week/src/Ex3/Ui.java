package Ex3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ui extends JFrame {

	public Ui() {
		Container ct = getContentPane();
		BorderLayout bl = new BorderLayout();
		GridLayout gl = new GridLayout(2,2);
		JPanel pane_button = new JPanel();
		JTextField tf_input = new JTextField("���� �ݾ�");
		JTextField tf_output = new JTextField("��ȯ �ݾ�");
		JButton btn_coke = new JButton("�ݶ�(1000)");
		JButton btn_sprite = new JButton("���̴�(800)");
		JButton btn_fanta = new JButton("ȯŸ(700)");
		JButton btn_empty = new JButton();
		
		ct.setLayout(bl);
		pane_button.setLayout(gl);
		
		ct.add(tf_input, BorderLayout.NORTH);
		pane_button.add(btn_coke);
		pane_button.add(btn_sprite);
		pane_button.add(btn_fanta);
		pane_button.add(btn_empty);
		ct.add(pane_button, BorderLayout.CENTER);
		ct.add(tf_output, BorderLayout.SOUTH);	
		
		setTitle("���Ǳ� UI �����");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
	}
	
}
