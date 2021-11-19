package dynamicProgramming;

public class LootHouses {
    public static int  loot(int []arr){
        int dp[] = new int[arr.length];
        if(arr.length == 1){
            return arr[0];
        }
        if(arr.length == 2){
            return Math.max(arr[0],arr[1]);
        }

        if(arr.length == 3){
            return Math.max((arr[0] +arr[2]),arr[1]);
        }
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);

        for(int i = 2;i < dp.length;i++){
            dp[i] = Math.max(arr[i] + dp[i - 2],dp[i - 1]);
        }

        return dp[arr.length - 1];
    }

    public static void main(String[] args) {
        int arr[] = {5,5, 10, 100, 10, 5};
        System.out.println(loot(arr));
    }
}
