import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainUI extends JFrame {

	public MainUI() {
		Container ct = getContentPane();
		ct.setLayout(new GridLayout(2, 3));

		JLabel label1 = new JLabel("∫œ«— Ω“ : ",JLabel.RIGHT);
		JLabel label2 = new JLabel("0", JLabel.RIGHT);
		JLabel label3 = new JLabel(" kg");
		JLabel label4 = new JLabel("Ω“ ∫∏≥ª±‚ : ", JLabel.RIGHT);
		JTextField tf = new JTextField();
		JButton button = new JButton("∫∏≥ª±‚");
		
		Rice rice = new Rice(label2);
		NorthKorea nk = new NorthKorea(rice);
		nk.start();
		
		button.addActionListener(e -> {
			int amountOfRice = Integer.parseInt(tf.getText());
			rice.sendRice(amountOfRice);
		});
		
		ct.add(label1);
		ct.add(label2);
		ct.add(label3);
		ct.add(label4);
		ct.add(tf);
		ct.add(button);
		
		setTitle("∫œ«— Ω“ ¡÷±‚");
		setSize(300, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainUI();
	}

}
