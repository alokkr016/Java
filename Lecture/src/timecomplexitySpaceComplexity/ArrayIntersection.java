package timecomplexitySpaceComplexity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrayIntersection {
    public static void intersection(int[] arr1, int[] arr2) {
        //Your code goes here
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        merge(arr1,arr2);
    }
    public static void merge(int []arr1, int[] arr2){

        int i = 0;
        int k = 0;
        while(i < arr1.length && k < arr2.length){
            if(arr1[i] == arr2[k]){
                System.out.print(arr1[i] + " ");
                i++;
                k++;
            }
            else if(arr1[i] < arr2[k]){
                i++;
            }
            else{
                k++;
            }
        }
    }

}


 class Runner51 {

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
        int t = Integer.parseInt(br.readLine().trim());

        while(t > 0) {
            int[] arr1 = takeInput();
            int[] arr2 = takeInput();
            ArrayIntersection.intersection(arr1, arr2);
            System.out.println();

            t -= 1;
        }
    }
}