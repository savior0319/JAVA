import javax.swing.JLabel;
import javax.swing.JPanel;

public class Rice {
	JLabel label;
	int amountOfRice = 0;
	public Rice(JLabel label){
		this.label = label;
	}
	public synchronized void useRice(int amount){
		if(amountOfRice <= 0){
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		amountOfRice -= amount;
		label.setText(String.valueOf(amountOfRice));
	}
	public synchronized void sendRice(int amount){
		amountOfRice += amount;
		label.setText(String.valueOf(amountOfRice));
		notify();
	}
}
