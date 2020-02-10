package chapter04;

public class MyClassTest {

	public static void main(String[] args) {
		// new MyClass();
		
		MyClass myClass1 = MyClass.getInstance();
		MyClass myClass2 = MyClass.getInstance();
		MyClass myClass3 = MyClass.getInstance();
		
		System.out.println(myClass1 == myClass2);
		System.out.println(myClass2 == myClass3);
	}

}
