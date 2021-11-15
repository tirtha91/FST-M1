package InterviewProgram;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortingElements {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(6);
		list.add(2);
		list.add(3);
		list.add(9);
		
		Set<Integer> s = new TreeSet<Integer>();
		for ( Integer i : list)
		{
			s.add(i);
		}
		
		System.out.println("Sorted");
		for (Integer j: s)
		{
			System.out.println(j);
		}
	}

}
