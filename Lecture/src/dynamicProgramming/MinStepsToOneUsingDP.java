package dynamicProgramming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class MinStepsToOneUsingDP {

    public static int countMinStepsToOne(int n){
        int storage[] = new int[n + 1];
        storage[1] = 0;
        for(int i = 2; i <= n; i++){
            int min = storage[i - 1];
            if(i % 3 == 0){
                if(min > storage[i / 3]){
                    min = storage[i / 3];
                }
            }

            if(i % 2 == 0){
                if(min > storage[i / 2]){
                    min = storage[i / 2];
                }
            }

            storage[i] = 1 + min;

        }
        return storage[n];
    }


    public static int countMinStepsToOneM(int n) {
        int dp[] = new int[n + 1];
        return min(n,dp);
    }

    public static  int min(int n,int[] dp){
        if(n == 1){
            dp[n] = 0;
            return dp[n];
        }

        if(dp[n] != 0){
            return dp[n];
        }

        int subByOne = min(n - 1,dp);
        int min = subByOne;
        if(n % 2 == 0){
            int divideBy2 = min(n/2,dp);
            if(divideBy2 < min){
                min  = divideBy2;
            }
        }
        if(n % 3 == 0){
            int divideBy3 = min(n/3,dp);
            if(divideBy3 < min){
                min = divideBy3;
            }
        }


        dp[n] = 1 + min;
        return  dp[n];
    }
}


 class Runner2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine().trim());
        System.out.println(MinStepsToOneUsingDP.countMinStepsToOne(n));
    }
}