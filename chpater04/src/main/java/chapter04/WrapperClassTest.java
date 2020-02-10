package chapter04;

public class WrapperClassTest {
	public static void main(String[] args) {
		Integer i = new Integer(10);
		Character c = new Character('A');
		Boolean b = new Boolean(true);
		
		System.out.println(i);
		System.out.println(c);
		System.out.println(b);
		
		// Auto Boxing
		Integer j1 = 10;
		Integer j2 = 10;
		System.out.println(j1 + ":" + j2);
		System.out.println(j1 == j2);
		System.out.println(i == j1);
		
		// Auto Unboxing
		// int j3 = 20 + i.intValue();
		int j3 = 20 + i;
		
	}
}
