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
	private JLabel jlb1 = new JLabel("글자수 : " + count +"개", JLabel.LEFT);
	private JLabel jlb2 = new JLabel("공백 제외 글자수 : " + count +"개", JLabel.LEFT);
	private JLabel jlb3 = new JLabel("공백수 : " + space +"개", JLabel.LEFT);
	private JPanel jp = new JPanel();
	private Thread T;
	
	public NOC(){
		setTitle("Number Of Characters");
		setSize(700,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		ct.setLayout(new BorderLayout());
		jta.setLineWrap(true);   
		jlb1.setFont(new Font("맑은고딕", Font.BOLD, 15));
		jlb2.setFont(new Font("맑은고딕", Font.BOLD, 15));
		jlb3.setFont(new Font("맑은고딕", Font.BOLD, 15));
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
		Thread.sleep(1); // 1ms 마다 글자수 검사 쓰레드 실행
		String getText = jta.getText(); 
		count = getText.length(); // 전체 글자수
			for(int i=0; i<count; i++){
			      if(getText.charAt(i)==' '){ // 띄어쓰기 개수 space++
			    	  space++;			     
			      }      
			}		     
			int MaxEnter = Integer.MAX_VALUE; // 최대 다음줄 개수
		    String nextline[] = getText.split("\n",MaxEnter); 
		    // 다음줄로 넘어갈 때 분리해서 nextline 배열에 저장
		    int nlc = nextline.length; // nextline 배열의 개수 (최대 int max값)
			jlb1.setText("글자수 : " + count +"개"); // 띄어쓰기 + 다음줄 + 글자수 전부 포함
			jlb3.setText("공백수 : " + (space+nlc-1) +"개"); // 띄어쓰기 + 다음줄 포함
			jlb2.setText("공백제외 글자수 : " + (count-space-nlc+1) +"개"); // 글자수 개수만
			space = 0; // 띄어쓰기 값 0 초기화
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}