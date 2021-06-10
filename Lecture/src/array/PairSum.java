package array;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class PairSum {
    public static int pairSum(int arr[], int x) {
        //Your code goes here
        int count = 0;

        for(int i = 0;i < arr.length;i++){

            for(int j = i;j < arr.length;j++){


                if(arr[i] + arr[j] == x){

                    count++;
                }
            }
    }
        return count;
}

}



class Runner7 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[] takeInput() throws IOException {
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size];

        if (size == 0) {
            return input;
        }

        String[] strNums;
        strNums = br.readLine().split("\\s");


        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }

        return input;
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine().trim());

        while(t > 0) {

            int[] input = takeInput();
            int x = Integer.parseInt(br.readLine().trim());
            System.out.println(PairSum.pairSum(input, x));

            t -= 1;
        }
    }
}