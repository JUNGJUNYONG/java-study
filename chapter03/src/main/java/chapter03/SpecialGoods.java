package chapter03;

import mypackage.Goods;

public class SpecialGoods extends Goods {
	public void test() {
		// protected는 패키지 상관없이 자식에서는 무조건 접근이 가능하다. 
		System.out.println(price);
	}
}
