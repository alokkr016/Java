package temp;

import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int num = s.nextInt();
        while (n > 0) {
            int ans = divSum(num);
            System.out.println(ans);
            n--;
        }
    }
    public static int divSum(int a)
    {


        int sum = 0;
        for(int i = 1;i < a;i++){
                if(a % i == 0){
                    sum += i;
                }

            }
        return sum;

    }
}