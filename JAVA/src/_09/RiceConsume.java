package _09;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RiceConsume extends Thread {
	
	JLabel jlb2;
	JTextField jtf;

	public RiceConsume(JLabel jlb2, JTextField jtf) {
		// TODO Auto-generated constructor stub
		this.jlb2=jlb2;
		this.jtf=jtf;
	}
	public void run() {
		int A = Integer.parseInt(jtf.getText());
		try {
			while(true) {
			String B = String.valueOf(A--);
			jlb2.setText(B+"kg");
			sleep(100);
			if(A<0) {	
				break;
			}
		}
			
		}catch(Exception e) {
				e.printStackTrace();
			}
	}
}


