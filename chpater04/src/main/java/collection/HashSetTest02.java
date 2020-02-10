package collection;

import java.util.HashSet;

public class HashSetTest02 {

	public static void main(String[] args) {
		HashSet<Gugudan> s = new HashSet<>();
		
		s.add(new Gugudan(2,3));
		s.add(new Gugudan(9,9));
		s.add(new Gugudan(3,2));
		s.add(new Gugudan(2,3));
		
		for (Gugudan g : s) {
			System.out.println(g);
		}

	}

}
