package priorityQueues;
import java.util.PriorityQueue;
public class SortKSortedArray {
    public static  void sortKSortedArray(int []arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        for(;i < k;i++) {
            pq.add(arr[i]);
        }

        for(;i < arr.length;i++){
            arr[i - k] = pq.remove();
            pq.add(arr[i]);
        }

        for(int j = arr.length - k;j < arr.length;j++){
            arr[j] = pq.remove();
        }

    }
    public static void main(String[] args) {
        int []arr = {2,4,1,9,6,8};
        int k = 3;
        sortKSortedArray(arr,k);
        for(int x : arr){
            System.out.print(x + " ");
        }
    }
}