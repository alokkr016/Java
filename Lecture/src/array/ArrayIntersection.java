package array;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayIntersection {
//    public static boolean elementCheck(int [] myArray,int n){
//        boolean cheak = false;
//        for(int i = 0;i < myArray.length;i++){
//            if(myArray[i] == n){
//                cheak = true;
//                break;
//            }
//        }
//        return cheak;
//    }
    public static void intersections(int arr1[], int arr2[]) {
        //Your code goes here
        int myarr[] = new int[arr1.length];
        int k = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr2[j] == arr1[i]) {
                    myarr[k] = arr2[j];
                    arr2[j] = Integer.MAX_VALUE;
                    k++;
                    break;
                }
            }
        }
        for (int i = 0; i < myarr.length; i++) {
            if (myarr[i] != 0) {
                System.out.print(myarr[i] + " ");
            }
        }
    }
}


 class Runner6 {

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

            int[] input1 = takeInput();
            int[] input2 = takeInput();
            ArrayIntersection.intersections(input1, input2);
            System.out.println();

            t -= 1;
        }
    }
}