package dynamicProgramming;

public class Staircase {
    public static int stairCase(int n){
        if(n <= 0 ){
            return 1;
        }
        if(n == 1 || n == 2){
            return n;
        }
        int sub1 = stairCase(n - 1);
        int sub2 = stairCase(n - 2);
        int sub3 = stairCase(n - 3);

        return sub1 + sub2 + sub3;
    }

    public static int stairCaseM(int n) {
        int dp[] = new int[n + 1];
        return stairCaseM(n,dp);
    }

    public static int stairCaseM(int n, int[]dp){
        if(n <= 0 ){
            return 1;
        }
        if(n == 1 || n == 2){
            return n;
        }
        int sub1, sub2, sub3;
        if(dp[n-1] == 0){
            sub1 = stairCaseM(n - 1);
        }else{
            sub1 = dp[n - 1];
        }
        if(dp[n-2] == 0){
            sub2 = stairCaseM(n - 2);
        }else{
            sub2 = dp[n - 2];
        }
        if(dp[n-3] == 0){
            sub3 = stairCaseM(n - 3);
        }else{
            sub3 = dp[n - 3];
        }

        return sub1 + sub2 + sub3;
    }

    public static int stairCaseDP(int n) {
        int []dp = new int[n + 1];

        if(n <= 0 ){
            return 1;
        }
        if(n == 1 || n == 2){
            return n;
        }

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        for (int i = 0;i <= 10;i++) {
            System.out.print(stairCase(i) + " ");
        }
        System.out.println();
        for (int i = 0;i <= 10;i++) {
            System.out.print(stairCaseM(i) + " ");
        }
        System.out.println();
        for (int i = 0;i <= 10;i++) {
            System.out.print(stairCaseDP(i) + " ");
        }
        System.out.println();
    }
}
