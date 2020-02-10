package practice02;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Random r = new Random();
		int k = r.nextInt(100) + 1;
		int count = 0;
		int start = 1;
		int last = 100;
		System.out.println("수를 결정하였습니다. 맞추어 보세요");
		System.out.println("1-100");
		
		 while(true)
		 {
			 count++;
			 System.out.print(count + ">>");
			 int munber = scanner.nextInt();
			 if(munber == k)
			 {
				 System.out.println("맞았습니다.");
				 System.out.print("다시하시겠습니까(y/n) >> ");
				 String answer = scanner.next();
				 if( answer.equals("y") ){
			    //종료하도록 작성한다.
					 scanner.next();
				 }
				 else
				 {
					 break;
				 }
			 }
			 else if(munber > k)
			 {
				 System.out.println("더 낮게");
				 System.out.println(start + "-" + munber);
				 
				 last = munber;
			 }
			 else if(munber < k)
			 {
				 System.out.println("더 높게");
				 System.out.println(munber + "-" + last);
				 start = munber;
			 }
		 }

	}
}
