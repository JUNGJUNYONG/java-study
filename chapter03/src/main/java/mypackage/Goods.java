package mypackage;

public class Goods {
	public static int countOfGoods;
	
	public Goods() {
		countOfGoods++;
	}
	
	
	public String name;     // 모든 접근 가능(접근 제한이 없음)
	protected int price;    // 같은 패키지 + 자시 접근 가능
	int countSold;          // 같은 패키지  
	private int countStock; // 하나의 클래스에서만 접근가능
}
