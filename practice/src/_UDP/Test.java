package _UDP;

import java.net.*;
import java.util.*;

public class Test implements Runnable {

	private Thread t;
	private String ip;
	/*private int getyouport;
	private int getmyport;*/
	private String send;
	
	Scanner sc = new Scanner(System.in);
	
	public Test() {

		t = new Thread(this);
		t.start();
		
		System.out.printf("���� ������ �Է�   \n");
		System.out.printf("ex)127.0.0.1 \n");
		System.out.printf(": ");
		ip = sc.nextLine();
		/*
		System.out.print("���� ��Ʈ �Է� \n");
		System.out.printf("ex)9999 \n");
		System.out.printf(": ");
		getyouport = sc.nextInt();
		System.out.print("�� ��Ʈ �Է� \n");
		System.out.printf("ex)9999 \n");
		System.out.printf(": ");
		getmyport = sc.nextInt();*/
	

		DatagramSocket socket;
		try {
			
			System.out.printf("���� ���� �Է� : ");
		
			while(true) {
			send = sc.nextLine();
			socket = new DatagramSocket();
			byte[] buffer = send.getBytes();
			InetAddress address = InetAddress.getByName(ip);
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 9999);
			socket.send(packet);
			System.out.print("�������� : " + send + "\n");
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		DatagramSocket socket;		
		try {
			socket = new DatagramSocket(9999);
			while (true) {				
				byte[] rebuffer = new byte[100];
				DatagramPacket packet = new DatagramPacket(rebuffer, rebuffer.length);
				socket.receive(packet);
				String receive = new String(packet.getData());
				System.out.printf("�������� : " + receive + "\n");
				System.out.printf("���� ���� �Է� : ");	
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
}
