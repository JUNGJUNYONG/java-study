package chapter04;

import java.util.Vector;

public class VectorTest01 {
	
	public static void main(String args[]) {
		Vector<String> v = new Vector<>();
		
		v.addElement("둘리");
		v.addElement("마이콜");
		v.addElement("도우넛");
		
//		순회
		int count = v.size();
		for (int i = 0; i < count; i++) {
			String s = v.elementAt(i);
			System.out.println(s);
		}
	}
}
