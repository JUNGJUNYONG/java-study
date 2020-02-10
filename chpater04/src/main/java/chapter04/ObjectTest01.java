package chapter04;

public class ObjectTest01 {
	public static void main(String[] args) {
		Point p = new Point(10, 20);
		
		// Class klass = p.getClass();				
		System.out.println(p.getClass());		// reflection
		System.out.println(p.hashCode());		// reference value X
												// address		   X
												// address 기반의 해싱값(int)
		System.out.println(p);
		System.out.println(p.toString());		// getClass() + "@" + hashCode()
	}
}
