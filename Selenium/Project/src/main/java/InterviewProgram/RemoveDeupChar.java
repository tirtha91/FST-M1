package InterviewProgram;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

public class RemoveDeupChar {

	public static void main(String[] args) {
//		input string = "India is my country"
//		remove duplicate characters from the input string
		
		String input = "India is my country";
		char[] ch = input.toLowerCase().toCharArray();
		List<Character> list = new ArrayList();
		
		StringBuilder str = new StringBuilder();
		list.add(ch[0]);
		
		for(int i = 1; i < ch.length; i++)
		{
			if(!list.contains(ch[i]))
			{
				list.add(ch[i]);
			}
		}
		for(Character c : list)
		{
			str.append(c);
		}
		System.out.println(str);
	}


}
