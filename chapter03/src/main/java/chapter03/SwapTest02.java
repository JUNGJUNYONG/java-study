package chapter03;

public class SwapTest02 {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		System.out.println(a + ":" + b);

		swap(a, b);
		
		System.out.println(a + ":" + b);
	}

	public static void swap(int m, int n) {
		int temp = m;
		m = n;
		n = temp;
	}
}
