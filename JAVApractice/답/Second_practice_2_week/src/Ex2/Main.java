package Ex2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try {
			FileManager fileManager = new FileManager();
			RankManager rankManager = new RankManager();
			System.out.println("### �߱��� �·�/���� ���ϱ� ###");
			String rank = fileManager.readResult();
			System.out.println(rank);
			rankManager.getRank(rankManager.getOdds(rank));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
