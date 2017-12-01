package _11;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class _1_BioThread extends Thread {

	private JTextField jtf;
	private JLabel jl5;
	private JLabel jl6;
	private JLabel jl7;
	private String s;
	private long diffDay;

	public _1_BioThread(JTextField jtf, JLabel jl5, JLabel jl6, JLabel jl7, String s) {
		// TODO Auto-generated constructor stub
		this.jtf = jtf;
		this.jl5 = jl5;
		this.jl6 = jl6;
		this.jl7 = jl7;
		this.s = s;
	}

	public void run() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(new Date());
		String A = jtf.getText();

		try {
			Date ED = sdf.parse(today);
			Date SD = sdf.parse(A);
			diffDay = (ED.getTime() - SD.getTime()) / (24 * 60 * 60 * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			while (true) {
				double pi = Math.PI;
				DecimalFormat f = new DecimalFormat("#.###");

				if (s.equals("body")) {
					String body = f.format(Math.sin((2 * pi * diffDay) / 23));
					jl5.setText(body);

				} else if (s.equals("sensitivity")) {
					String sensitivity = f.format(Math.sin((2 * pi * diffDay) / 28));
					jl6.setText(sensitivity);

				} else if (s.equals("verstand")) {
					String verstand = f.format(Math.sin((2 * pi * diffDay) / 33));
					jl7.setText(verstand);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
