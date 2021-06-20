package stringAnd2Darray;
import java.util.Scanner;
/*
6
3 12 34 2 0 -1
5
13 17 5 4 6

 */
/*
Output:
34 2 0 -1
17 6
 */

public class LeadersInArray {
    public static void leaders(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            int j;
            for (j = i + 1; j < size; j++) {
                if (arr[i] < arr[j]) {
                    break;
                }
            }
                if (j == size) {
                    System.out.print(arr[i] + " ");
                }
            }


        }
    }



 class Runner21 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int input[] = new int[n];
        for(int i = 0; i < n; i++){
            input[i] = s.nextInt();
        }
        LeadersInArray.leaders(input);
    }

}
