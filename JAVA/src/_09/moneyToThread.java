package _09;

import javax.swing.JLabel;

class moneyToThread extends Thread {
	
	money m;
	JLabel jlb;
	String s;
	
	public moneyToThread(JLabel jlb, String s, money m) {
		this.jlb = jlb;
		this.s = s;
		this.m = m;
	}
	
	@Override
	public void run() {
		while(true) {
			if(s.equals("Korea")) {
				jlb.setText("Korea money : "+m.koreamoney());
			} else if(s.equals("Japan")) {
				jlb.setText("Japan money : "+m.japanmoney());
			} else if(s.equals("China")) {
				jlb.setText("China money : "+m.chinamoney());
			}
		}
	}
}