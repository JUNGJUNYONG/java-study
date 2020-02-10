package practice01;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int sum = 0;
		
		while (true) {
			System.out.print( "숫자를 입력하세요 : ");
			int a = scanner.nextInt();
	
			
			if(a % 2 == 1)
			{
				for(int i = 1; i <= a; i+=2)
				{
					sum += i;
				}
			}
			else
			{
				for(int i = 0; i <= a; i+=2)
				{
						sum += i;
				}
			}
			System.out.println("결과 값 : " + sum);
		}
		
	}
}
