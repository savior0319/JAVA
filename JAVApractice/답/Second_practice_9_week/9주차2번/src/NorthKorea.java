
public class NorthKorea extends Thread{

	Rice rice;
	
	public NorthKorea(Rice rice) {
		this.rice = rice;
	}
	
	@Override
	public void run() {
		while(true) {
			rice.useRice(1);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
