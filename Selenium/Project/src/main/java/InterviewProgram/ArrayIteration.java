package InterviewProgram;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ArrayIteration {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int arrayLength = sc.nextInt();
        int elementPrintCount = sc.nextInt();
        int numberIteration = sc.nextInt();
        Queue<Integer> qu = new LinkedList<Integer>();

        for (int i = 0; i < arrayLength; i++) {
            qu.add(sc.nextInt());
        }

        for (int i = 0; i < numberIteration; i++) {
            for (int j = 0; j < elementPrintCount; j++) {
                int ele = qu.remove();
                System.out.print(ele + " ");
                qu.add(ele);
            }
            System.out.println();
        }


    }


}
