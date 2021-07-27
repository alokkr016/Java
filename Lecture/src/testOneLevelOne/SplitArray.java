package testOneLevelOne;

import java.util.Scanner;
public class SplitArray {
    public static boolean splitArray(int array[]) {
    return splitArray(array,0,0,0);
    }
    public static boolean splitArray(int array[],int index, int sum1,int sum2){
        if(array.length == index){
            return sum1 == sum2;
        }
        if(array[index] % 5 == 0){
            sum1 += array[index];
        }
        else if(array[index] % 3 == 0){
            sum2 += array[index];
        }
        else {
            return splitArray(array,index+1,sum1+array[index],sum2) || splitArray(array,index+1,sum1,sum2 + array[index]) ;
        }
        return splitArray(array,index + 1,sum1,sum2);
    }


}



 class runner2 {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = s.nextInt();
        int input[] = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        System.out.println(SplitArray.splitArray(input));
    }
}
