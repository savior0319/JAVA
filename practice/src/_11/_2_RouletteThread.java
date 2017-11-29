package _11;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class _2_RouletteThread extends Thread {
	private DefaultTableModel model;
	private JTextField jtf1;
	private JTextField jtf2;
	private JTextField jtf3;
	private JTextField jtf4;
	private JTextField money;
	private JLabel jl7;
	private JLabel jl8;
	private int count = 0;

	public _2_RouletteThread(DefaultTableModel model, JTextField jtf1, JTextField jtf2, JTextField jtf3,
			JTextField jtf4, JTextField jtf5, JLabel jl7, JLabel jl8) {
		// TODO Auto-generated constructor stub
		this.model = model;
		this.money = jtf5;
		this.jtf1 = jtf1;
		this.jtf2 = jtf2;
		this.jtf3 = jtf3;
		this.jtf4 = jtf4;
		this.jl7 = jl7;
		this.jl8 = jl8;
	}

	public void run() {
		// TODO Auto-generated method stub
		int a1 = Integer.parseInt(jtf1.getText());
		int a2 = Integer.parseInt(jtf2.getText());
		int a3 = Integer.parseInt(jtf3.getText());
		int a4 = Integer.parseInt(jtf4.getText());
		int remainmoney = Integer.parseInt(money.getText());
		Boolean start = true;
		try {
			while (start) {
				int num1 = (int) (Math.random() * 10) + 1;
				int num2 = (int) (Math.random() * 10) + 1;
				int num3 = (int) (Math.random() * 10) + 1;
				int num4 = (int) (Math.random() * 10) + 1;
				count++;
				remainmoney -= 100; // 투입금액
				int resultmoney = remainmoney + 1000000;
				model.addRow(new Object[] { count, num1, num2, num3, num4, resultmoney });
				if (a1 == num1 && a2 == num2 && a3 == num3 && a4 == num4) {
					jl7.setText(remainmoney + "원이 남음");
					jl8.setText(resultmoney + "원을 획득 하셨습니다.");
					start = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
