package practice02;

import java.util.Scanner;

public class Prob02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] intArray = new int[5];
		int input = 0;
		double sum = 0;
		double avg = 0;

		System.out.println("5개의 숫자를 입력하세요.");
		
		for(int i = 0; i < intArray.length; i++)
		{
			input = scanner.nextInt();
			intArray[i] = input;
		}
		for(int j = 0; j < intArray.length; j++)
		{
			sum += intArray[j];
		}
		avg = sum / intArray.length;
		System.out.println("평균은 " + avg + " 입니다.");
	}

}
