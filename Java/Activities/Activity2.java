package activities;

public class Activity2 {
    public static void main(String[] args) {
        int[] ArrNum = {10, 77, 10, 54, -11, 10};
        int sum = 0;
        for (int i = 0; i < ArrNum.length; i++) {
            if(ArrNum[i]==10)
            {
                sum+= ArrNum[i];
            }
        }
        if(sum==30)
        {
            System.out.println("Value is equal to 30");
        }
        else
        {
            System.out.println("Value not equal to 30");
        }
    }
}
