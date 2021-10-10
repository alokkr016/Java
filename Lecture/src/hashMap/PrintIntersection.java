package hashMap;
/*
You have been given two integer arrays/lists (ARR1 and ARR2)
of size N and M, respectively. You need to print their intersection;
 An intersection for this problem can be defined when both the arrays/lists
 contain a particular value or to put it in other words, when there is a
 common value that exists in both the arrays/lists.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;


public class PrintIntersection {
    public static void printIntersection(int[] arr1,int[] arr2){
        if(arr1 == null || arr2 == null){
            return;
        }
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i : arr1){
            if(!hm.containsKey(i)){
                hm.put(i,1);
            }
            else{
                hm.put(i,hm.get(i) + 1);
            }
        }

        for(int x : arr2){
            if(hm.containsKey(x) && hm.get(x) != 0){ //if(hm.getValue(x) != 0)
                System.out.println(x);
                hm.put(x,hm.get(x) - 1);
            }
            else{
                continue;
            }
        }

    }
}

class Runner2 {

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


        int[] arr1 = takeInput();
        int[] arr2 = takeInput();
        PrintIntersection.printIntersection(arr1,arr2);


    }
}