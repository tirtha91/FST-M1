package InterviewProgram;

public class LetterCount {

	public static void main(String[] args) {
//		input string =aaabccddddeea
//		output should be a3b1c2d4e2a1
		
		String input = "bbyeeweeggfdddf";
		char[] ch = input.toCharArray();
		Integer count = 1;
		char last = ch[0];
		
		StringBuilder str = new StringBuilder();
		str.append(ch[0]);
		
		for(int i = 1; i < ch.length; i++)
		{
			if(last == ch[i])
			{
				count++;
			}
			else
			{
				str.append(count.toString().charAt(0));
				str.append(ch[i]);
				count = 1;
				last = ch[i];
			}
			if(i == ch.length - 1)
			{
				str.append(count.toString().charAt(0));
			}
			
		}
		
		System.out.println(str);

	}

}
