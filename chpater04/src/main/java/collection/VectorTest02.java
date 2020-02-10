package collection;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorTest02 {

	public static void main(String[] args) {
		List<String> list = new Vector<>();
		
		list.add("둘리");
		list.add("마이클");
		list.add("도우넛");

//		순회1
		int count = list.size();
		for (int i = 0; i < count; i++) {
			String s = list.get(i);
			System.out.println(s);
		}
		
		list.remove(1);
		
//		순회2
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		
//		순회3(for~each)
		for(String s : list) {
			System.out.println(s);
		}
		
		

	}

}
