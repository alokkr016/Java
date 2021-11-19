package dynamicProgramming;

import java.util.Scanner;

public class FibbonacciDP {
    public static int fiboM(int n,int[] dp){
        if(n == 0 || n == 1){
            return n;
        }
        int ans1;
        int ans2;

        if(dp[n - 1] == -1){
            ans1 = fiboM(n - 1, dp);
            dp[n - 1] = ans1;
        }
        else{
            ans1 = dp[n - 1];
        }

        if(dp[n -2] == -1){
            ans2 = fiboM(n - 2, dp);
            dp[n - 2] = ans2;
        }else{
            ans2 = dp[n - 2];
        }

        return ans1 + ans2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int dp[] = new int[n + 1];
        for(int i = 0;i < n + 1;i++){
            dp[i] = -1;
        }
        System.out.println(fiboM(n,dp));

    }
}
