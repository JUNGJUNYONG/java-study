package chapter04;

import java.util.List;
import java.util.Vector;

public class VectorTest02 {

	public static void main(String[] args) {
		List<String> list = new Vector<>();
		
		list.add("둘리");
		list.add("마이클");
		list.add("도우넛");
		
		int count = list.size();
		for (int i = 0; i < count; i++) {
			String s = list.get(i);
			System.out.println(s);
		}

	}

}
