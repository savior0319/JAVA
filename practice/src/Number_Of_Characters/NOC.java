package Number_Of_Characters;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class NOC extends JFrame implements Runnable{
	
	private int count = 0;
	private int space = 0;
	private JTextArea jta = new JTextArea();
	private JScrollPane jsp = new JScrollPane(jta);
	private Container ct = getContentPane();
	private JLabel jlb1 = new JLabel("���ڼ� : " + count +"��", JLabel.LEFT);
	private JLabel jlb2 = new JLabel("���� ���� ���ڼ� : " + count +"��", JLabel.LEFT);
	private JLabel jlb3 = new JLabel("����� : " + space +"��", JLabel.LEFT);
	private JPanel jp = new JPanel();
	private Thread T;
	
	public NOC(){
		setTitle("Number Of Characters");
		setSize(700,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		ct.setLayout(new BorderLayout());
		jta.setLineWrap(true);   
		jlb1.setFont(new Font("�������", Font.BOLD, 15));
		jlb2.setFont(new Font("�������", Font.BOLD, 15));
		jlb3.setFont(new Font("�������", Font.BOLD, 15));
		jp.setLayout(new GridLayout(1,3));
		
		jp.add(jlb1);
		jp.add(jlb3);
		jp.add(jlb2);

		ct.add(jsp, BorderLayout.CENTER);
		ct.add(jp, BorderLayout.SOUTH);
		
		T= new Thread(this);
		T.start();
	}
	
	public static void main(String args[]) {
		new NOC().setVisible(true);
	}
	@Override
	public void run() {
		try {
			while(true) {
		Thread.sleep(1); // 1ms ���� ���ڼ� �˻� ������ ����
		String getText = jta.getText(); 
		count = getText.length(); // ��ü ���ڼ�
			for(int i=0; i<count; i++){
			      if(getText.charAt(i)==' '){ // ���� ���� space++
			    	  space++;			     
			      }      
			}		     
			int MaxEnter = Integer.MAX_VALUE; // �ִ� ������ ����
		    String nextline[] = getText.split("\n",MaxEnter); 
		    // �����ٷ� �Ѿ �� �и��ؼ� nextline �迭�� ����
		    int nlc = nextline.length; // nextline �迭�� ���� (�ִ� int max��)
			jlb1.setText("���ڼ� : " + count +"��"); // ���� + ������ + ���ڼ� ���� ����
			jlb3.setText("����� : " + (space+nlc-1) +"��"); // ���� + ������ ����
			jlb2.setText("�������� ���ڼ� : " + (count-space-nlc+1) +"��"); // ���ڼ� ������
			space = 0; // ���� �� 0 �ʱ�ȭ
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}