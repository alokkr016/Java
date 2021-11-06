package priorityQueues;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
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