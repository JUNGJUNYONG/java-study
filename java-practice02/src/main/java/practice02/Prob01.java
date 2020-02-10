package practice02;

import java.util.Scanner;

public class Prob01 {

	public static void main(String[] args) {
		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		int i = 0;
		Scanner scanner = new Scanner(System.in);

		System.out.print("금액:");

		int coin = scanner.nextInt();
		for(i = 0; i < MONEYS.length; i++)
		{
			System.out.println(MONEYS[i] + "원 : " + coin / MONEYS[i] + "개");
			coin %= MONEYS[i];
		}
		scanner.close();
	}

}
