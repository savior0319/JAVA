package Ex3;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main {
	public static void main(String[] args) {
		new WindowFrame();
	}
}

class WindowFrame extends JFrame implements ActionListener {
	JTextArea taGameResult;
	JLabel lblComResult;
	JLabel lblUserResult;
	JComboBox<String> cbPlayGame;
	JButton btnPlayGame;
	String history = "";

	public WindowFrame() {
		setTitle("가위바위보 게임");
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100, 50);
		setSize(320, 400);

		Container ct = getContentPane();

		JLabel lblCom = new JLabel("Com", JLabel.CENTER);
		JLabel lblUser = new JLabel("User", JLabel.CENTER);
		lblComResult = new JLabel("보", JLabel.CENTER);
		lblUserResult = new JLabel("가위", JLabel.CENTER);

		lblComResult.setFont(new Font("궁서체", Font.BOLD, 40));
		lblUserResult.setFont(new Font("궁서체", Font.BOLD, 40));

		lblCom.setBounds(0, 10, 150, 20);
		lblUser.setBounds(150, 10, 150, 20);
		lblComResult.setBounds(0, 30, 150, 50);
		lblUserResult.setBounds(150, 30, 150, 50);

		ct.add(lblCom);
		ct.add(lblUser);
		ct.add(lblComResult);
		ct.add(lblUserResult);

		JLabel lblPlayGame = new JLabel("Play Game", JLabel.RIGHT);
		lblPlayGame.setBounds(10, 100, 80, 20);
		ct.add(lblPlayGame);

		String[] strArr = { "가위", "바위", "보" };
		cbPlayGame = new JComboBox<String>(strArr);
		cbPlayGame.setBounds(100, 100, 80, 20);
		ct.add(cbPlayGame);

		btnPlayGame = new JButton("Play Game");
		btnPlayGame.setBounds(190, 100, 100, 20);
		btnPlayGame.addActionListener(this);
		add(btnPlayGame);

		JLabel lblGameResult = new JLabel("※ Game Result");
		lblGameResult.setBounds(10, 140, 100, 20);
		ct.add(lblGameResult);

		taGameResult = new JTextArea();
		JScrollPane scrollPanel = new JScrollPane(taGameResult);
		scrollPanel.setBounds(2, 160, 310, 210);
		ct.add(scrollPanel);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Random rd = new Random();
		int com = rd.nextInt(3) + 1;
		int user = cbPlayGame.getSelectedIndex()+1;
		String strCom = getText(com);
		String strUser = getText(user);
		int result = com-user;
		
		lblComResult.setText(strCom);
		lblUserResult.setText(strUser);
		
		String str = null;
		if(result == 0) {
			str = getCurrentTime()+"\t비김 (Com:"+strCom+", User:"+strUser+")\r\n";
		} else if(result == -1) {
			str = getCurrentTime()+"\t승리 (Com:"+strCom+", User:"+strUser+")\r\n";
		} else if(result == -2) {
			str = getCurrentTime()+"\t패배 (Com:"+strCom+", User:"+strUser+")\r\n";
		} else if(result > 0) {
			str = getCurrentTime()+"\t패배 (Com:"+strCom+", User:"+strUser+")\r\n";
		}
		history += str;
		taGameResult.setText(history);
		try {
			FileWriter fw = new FileWriter(new File("가위바위보.txt"));
			fw.write(history);
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private String getText(int num) {
		String str = null;
		switch (num) {
		case 1:
			str = "가위";
			break;
		case 2:
			str = "바위";
			break;
		case 3:
			str = "보";
			break;
		default:
			break;
		}
		return str;
	}
	
	private String getCurrentTime() {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		return format.format(new Date());
	}

}