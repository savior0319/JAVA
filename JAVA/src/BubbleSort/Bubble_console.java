package BubbleSort;

import java.util.*;

public class Bubble_console {

	Scanner sc = new Scanner(System.in);
	boolean start = true;

	public Bubble_console() {
		System.out.println("정렬 할 숫자 입력 (※띄어쓰기로 숫자 구분)");
		String input = sc.nextLine();
		String split[] = input.split(" ");
		int before[] = new int[split.length];

		for (int i = 0; i < split.length; i++) {
			before[i] = Integer.parseInt(split[i]);
		}

		while (start) {
			System.out.println("선택  : 1. 오름차순 , 2. 내림차순, 3. 종료 ");
			int choice = sc.nextInt();

			if (choice == 1) { // ASC

				int temp;
				// long time1 = System.currentTimeMillis();
				for (int i = 0; i < before.length - 1; i++) {
					for (int j = 0; j < before.length - 1; j++) {
						if (before[j] > before[j + 1]) {
							temp = before[j];
							before[j] = before[j + 1];
							before[j + 1] = temp;
						}
					}
				}
				// long time2 = System.currentTimeMillis();
				System.out.print("정렬된 숫자 : ");
				for (int i = 0; i < before.length; i++) {
					System.out.print(before[i] + " ");
				}
				// System.out.print("\n");
				// System.out.print( "실행 시간 : " + ( time2 - time1 )/1000.0 + "ms");
				System.out.print("\n");

			} else if (choice == 2) { // DESC

				int temp;
				// long time1 = System.currentTimeMillis();
				for (int i = 0; i < before.length - 1; i++) {
					for (int j = 0; j < before.length - 1; j++) {
						if (before[j] < before[j + 1]) {
							temp = before[j];
							before[j] = before[j + 1];
							before[j + 1] = temp;
						}
					}
				}
				// long time2 = System.currentTimeMillis();
				System.out.print("정렬된 숫자 : ");
				for (int i = 0; i < before.length; i++) {
					System.out.print(before[i] + " ");
				}
				// System.out.print("\n");
				// System.out.print( "실행 시간 : " + ( time2 - time1 )/1000.0 + "ms");
				System.out.print("\n");

			} else { // TERMINATE
				System.out.print("종료되었습니다.");
				start = false;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Bubble_console();
	}
}