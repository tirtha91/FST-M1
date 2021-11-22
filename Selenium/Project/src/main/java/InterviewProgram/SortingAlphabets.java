package InterviewProgram;

import java.util.Arrays;

public class SortingAlphabets {

	// function to print string in sorted order
    static void sortString(String str) {
        char []arr = str.toCharArray();
        Arrays.sort(arr);
        System.out.print(String.valueOf(arr));
    }
	public static void main(String[] args) {
		String s = "MANCHESTER42234";
        sortString(s);

	}

}
