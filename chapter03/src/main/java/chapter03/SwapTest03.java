package chapter03;

public class SwapTest03 {

	public static void main(String[] args) {
		Value a = new Value();
		a.val = 10;
		Value b = new Value();
		b.val = 20;
		
		System.out.println(a.val + ":" + b.val);
		
		swap(a, b);
		
		System.out.println(a.val + ":" + b.val);
	}

	public static void swap(Value m, Value n) {
		int temp = m.val;
		m.val = n.val;
		n.val = temp;
	}
}
