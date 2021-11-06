package priorityQueues;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
Given an array of integers, check whether it
represents max-heap or not. Return true if the given array represents max-heap, else return false.
Input Format:
The first line of input contains an integer,
that denotes the value of the size of the array. Let us denote it with the symbol N.
The following line contains N space separated
integers, that denote the value of the elements of the array.
Output Format :
The first and only line of output contains true
if it represents max-heap and false if it is not a max-heap.
Constraints:
1 <= N <= 10^5
1 <= Ai <= 10^5
Time Limit: 1 sec
Sample Input 1:
8
42 20 18 6 14 11 9 4
Sample Output 1:
true
 */
public class CheckMaxHeap {
    public static boolean checkMaxHeap(int arr[]) {

        int n = arr.length;
        for(int i = 0;i < arr.length; i++){
            if(2*i + 1 < n && arr[i] < arr[2*i + 1]){
                return false;
            }
            if(2*i + 2 < n && arr[i] < arr[2*i + 2]){
                return false;
            }
        }
        return true;
    }
}


 class Main22 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int input[] = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(CheckMaxHeap.checkMaxHeap(input));
    }
}