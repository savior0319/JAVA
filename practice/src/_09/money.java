package _09;

import javax.swing.JLabel;

class money{

	private int total = 0;
	private int koreaM = 0 ;
	private int chinaM = 0 ;
	private int japanM = 0 ;
	private int s = 0;
	private JLabel jlb;
	
	
	public money(JLabel jlb, String total) {
		// TODO Auto-generated constructor stub
		this.jlb = jlb;
		this.s = Integer.parseInt(total);
	}

	public int koreamoney() {
		koreaM++;
		totalmoney();
		return koreaM;
	}
	
	public int japanmoney() {
		japanM++;
		totalmoney();
		return japanM;
	}
	
	public int chinamoney() {
		chinaM++;
		totalmoney();
		return chinaM;
	}
	
	private synchronized void totalmoney() {
			if(total>=s) {
				try {
				wait();
		}  catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		total++;
		jlb.setText("Total money : " + total);
	}
}
