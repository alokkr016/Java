package hashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class MaximumFrequencyNumber {
    public static int maxFrequencyNumber(int[] arr){
        ArrayList<Integer> output = new ArrayList<Integer>();
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i = 0;i < arr.length;i++){
            if(!hash.containsKey(arr[i])){
                hash.put(arr[i],1);
            }
            else{
                hash.put(arr[i],hash.get(arr[i]) + 1);
            }
        }
        int max = 0;
        int ans = Integer.MIN_VALUE;
        for(int x : arr){
            if(hash.get(x) > max){
                max = hash.get(x);
                ans = x;
            }
        }
        return ans;
    }
}

class Runner {

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

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {


        int[] arr = takeInput();
        System.out.println(MaximumFrequencyNumber.maxFrequencyNumber(arr));


    }
}