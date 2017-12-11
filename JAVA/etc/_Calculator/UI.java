package _Calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.StringTokenizer;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class UI extends JFrame implements ActionListener {
	
	// 간단한 계산 기능 까지 넣었습니다 
	
	
	DefaultListModel<String> dlm = new DefaultListModel<String>();
	JList<String> list = new JList<String>(dlm);
	JScrollPane scroll = new JScrollPane(list);
	JTextField field = new JTextField();
	JButton[] button = new JButton[20];
	String[] buttonStr = {
		"+", "-", "*", "/", "7", "8", "9", "%", "4", "5", "6", "(", "1", "2", "3", ")", "0", ".", "=", "←" 
	};
	
	public UI() {
		JPanel viewPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		viewPanel.setLayout(new BorderLayout());
		buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));
		viewPanel.setOpaque(false);
		buttonPanel.setOpaque(false);
		
		Container ct = getContentPane();
		ct.setLayout(new GridLayout(2, 1, 5, 5));
		//오른쪽 정렬
		field.setHorizontalAlignment(JTextField.RIGHT);
		list.setCellRenderer(new DefaultListCellRenderer() {
			@Override
			public int getHorizontalAlignment() {
				return RIGHT;
			}
		});
		viewPanel.add(scroll, BorderLayout.CENTER);
		viewPanel.add(field, BorderLayout.SOUTH);
		//버튼 
		for (int i = 0; i < button.length; i++) {
			button[i] = new JButton(buttonStr[i]);
			button[i].setFont(new Font("굴림체", Font.BOLD, 20));
			button[i].addActionListener(this);
			buttonPanel.add(button[i]);
		}
		button[11].setEnabled(false);
		button[15].setEnabled(false);
		
		ct.add(viewPanel);
		ct.add(buttonPanel);
		
		setTitle("계산기");
		setSize(300, 400);
		setResizable(false);
		setLocation(200, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		String str = field.getText();
		
		if(command.equals("←")) {
			if(str.equals("")) return;
			field.setText(str.substring(0, str.length()-1));
			
		} else if(command.equals("=")) {
			StringTokenizer st = new StringTokenizer(str, "+-*/%");
			//숫자가 2개인지 검사
			if(st.countTokens() != 2) return;
			float num1 = Float.parseFloat(st.nextToken());
			float num2 = Float.parseFloat(st.nextToken());
			char op = getOperator(str);
			if(op == 0) return;
			DecimalFormat format = new DecimalFormat("#.######");
			String result = format.format(num1)+" "+op+" "+format.format(num2)+" = "+format.format(calculate(num1, op, num2));
			//데이터 model 추가
			dlm.addElement(result);
			saveData(result);
			//스크롤바 자동으로 맨밑으로 내려감
			scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getMaximum());
			field.setText("");
			
		} else {
			field.setText(str + command);
		}
	}

	private void saveData(String result) {
		try {
			FileWriter fw = new FileWriter("Result.txt", true);
			fw.write(result);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private float calculate(float num1, char op, float num2) {
		float result = 0; 
		switch (op) {
		case '+':
			result = num1 + num2;
			break;
		case '-':
			result = num1 - num2;
			break;
		case '*':
			result = num1 * num2;
			break;
		case '/':
			result = num1 / num2;
			break;
		case '%':
			result = num1 % num2;
			break;
		default:
			break;
		}
		return result;
	}

	private char getOperator(String str) {
		char[] arr = str.toCharArray();
		char[] op = { '+', '-', '*', '/', '%' };
		for (char c : arr) {
			if(!Character.isDigit(c)) {
				for (int i = 0; i < op.length; i++) {
					if(c == op[i]) return op[i];
				}
			}
		}
		return 0;
	}
}
