package hashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
Given a random integer array A of size N.
Find and print the count of pair of elements in the array which sum up to 0.
*/
public class PairSumToZero {
    public static int PairSum(int[] input, int size) {
    HashMap<Integer,Integer> hm = new HashMap<>();
    for(int i = 0;i < input.length;i++){
        if(!hm.containsKey(input[i])){
            hm.put(input[i],1);
        }
        else{
            hm.put(input[i],hm.get(input[i]) + 1);
        }
    }
    int count = 0;
    for(int i = 0;i < input.length;i++){
        if(hm.containsKey(-input[i])){
            int times;
            if(input[i] == -input[i]){
                int occ = hm.get(input[i]);
                times = (occ * (occ - 1)) / 2;
                count += times;
                hm.put(input[i],0);
                continue;
            }
            times = hm.get(input[i]) * hm.get(-input[i]);
            count += times;
            hm.put(input[i],0);
            hm.put(-input[i],0);
        }
    }
    return count;
}



class Runner3 {

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
        System.out.print(PairSumToZero.PairSum(arr,arr.length));


    }
}