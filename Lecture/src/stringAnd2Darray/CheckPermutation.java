package stringAnd2Darray;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class CheckPermutation {

    public static boolean isPermutation(String str1, String str2) {
        //Your code goes here

        boolean bool = true;
        int arr[] = new int[256];
        for (int i = 0;i < str1.length();i++){
            int val = str1.charAt(i);

            arr[val] += 1;

        }
        for (int i = 0;i < str2.length();i++){
            int val = str2.charAt(i);
            arr[val] -= 1;
        }
        for (int i = 0; i < arr.length;i++){
            if(arr[i] != 0){
                bool = false;
            }

        }
        return bool;
    }

}


 class Runner9 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        String str1 = br.readLine();
        if (str1 != null) {
            str1 = str1.trim();
        } else {
            str1 = "";
        }

        String str2 = br.readLine();
        if (str2 != null) {
            str2 = str2.trim();
        } else {
            str2 = "";
        }

        boolean ans = CheckPermutation.isPermutation(str1, str2);

        System.out.println(ans);

    }
}