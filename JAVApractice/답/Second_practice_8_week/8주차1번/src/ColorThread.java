import javax.swing.JTextField;

public class ColorThread extends Thread {
	
	int color = 255;
	JTextField tf;
	
	public ColorThread(JTextField tf) {
		this.tf = tf;
	}

	@Override
	public void run() {
		try {
			while (true) {
				color--;
				tf.setText(String.valueOf(color));
				sleep(1000);  // 1초에 한번씩 sleep
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
