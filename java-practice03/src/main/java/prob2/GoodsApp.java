package prob2;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
	
		Goods[] goods = new Goods[COUNT_GOODS];
		
		for(int i = 0; i < COUNT_GOODS; i++)
		{
			goods[i] = new Goods();
			goods[i].setName(scanner.next());
			goods[i].setPrice(scanner.nextInt());
			goods[i].setCount(scanner.nextInt());
		}
		for(int i = 0; i < COUNT_GOODS; i++)
		{
			goods[i].show();
		}
		scanner.close();
	}
}
