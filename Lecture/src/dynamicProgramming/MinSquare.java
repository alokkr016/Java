package dynamicProgramming;

public class MinSquare {
    public static int minSquare(int n){
        if(n == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1;i*i <= n;i++){
            int currentMin = minSquare(n - (i*i));
            if(min > currentMin){
                min = currentMin;
            }
        }

        return min + 1;
    }

    public static int minSquareM(int n){
        int dp[] = new int[n + 1];
        return minSquareM(n,dp);
    }

    public static int minSquareM(int n, int[] dp){
        if(n == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1;i*i <= n;i++){
            int currentMin;
            if(dp[n - i*i] != 0){
                currentMin = dp[n - i*i];
            }else {
                currentMin = minSquareM(n - (i * i));
                dp[n - i*i] = currentMin;
            }
            if(min > currentMin){
                min = currentMin;
            }
        }
        return min + 1;
    }
    public static int minSquareDP(int n){
        int []dp = new int [n + 1];
        return minSquareDP(n,dp);
    }

    public static int minSquareDP(int n, int[]dp){
        dp[0] = 0;

        for(int i = 1;i <= n;i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1;j*j <= i;j++){
                int currentAns = dp[i - j*j];
                if(min > currentAns){
                    min = currentAns;
                }
            }
            dp[i] = 1 + min;

        }
        return dp[n];
    }
    public static void main(String[] args) {
        for(int i = 1;i <= 10;i++) {
            System.out.print(minSquareM(i) + " ");
        }
        System.out.println();
        for(int i = 1;i <= 10;i++) {
            System.out.print(minSquare(i) + " ");
        }
        System.out.println();
        for(int i = 1;i <= 10;i++) {
            System.out.print(minSquareDP(i) + " ");
        }

    }
}
