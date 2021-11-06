package priorityQueues;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class K_largestElements {
    public static ArrayList<Integer> kLargest(int arr[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        for(;i < k;i++){
            pq.add(arr[i]);
        }

        for(;i < arr.length; i++){
            int temp = pq.peek();
            if(temp < arr[i]){
                pq.remove();
                pq.add(arr[i]);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int j = 0;j < k;j++){
            ans.add(pq.remove());
        }
        return ans;
    }
}

 class Runner21 {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = s.nextInt();
        int input[] = new int[n];
        for(int j = 0; j < n; j++) {
            input[j] = s.nextInt();
        }
        int k = s.nextInt();
        ArrayList<Integer> output = K_largestElements.kLargest(input, k);
        for(int i : output) {
            System.out.println(i);
        }

    }
}