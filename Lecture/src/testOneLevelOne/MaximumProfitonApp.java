package testOneLevelOne;

import java.util.Arrays;
import java.util.Scanner;
public class MaximumProfitonApp {
    public static int maximumProfit(int budget[]) {
        // Write your code here
        Arrays.sort(budget);
        int max = 0;
        for(int i = 0;i < budget.length;i++){
            if(max < budget[i] * (budget.length - i)){
                max = budget[i] * (budget.length - i);
            }
        }
        return max;
    }

}


 class runner {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int input[] = new int[n];
        for(int i=0;i<n;i++)
            input[i] = s.nextInt();

        System.out.println(MaximumProfitonApp.maximumProfit(input));
    }

}
