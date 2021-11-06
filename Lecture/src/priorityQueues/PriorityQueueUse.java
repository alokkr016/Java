package priorityQueues;


import java.util.Comparator;
import java.util.PriorityQueue;

class MinPriorityQueueComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1 < o2){
            return -1;
        }
        else if(o1 > o2){
            return 1;
        }
        else{
            return 0;
        }
    }
}
class MaxPriorityQueueComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1 < o2){
            return 1;
        }
        else if(o1 > o2){
            return -1;
        }
        else{
            return 0;
        }
    }
}

class StringLengthCompapator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        if(o1.length() < o2.length()){
            return -1;
        }else if(o1.length() > o2.length()){
            return 1;
        } else{
            return 0;
        }
    }
}
public class PriorityQueueUse {
    public static void main(String[] args) throws PriorityQueueException {
        StringLengthCompapator stringComparator = new StringLengthCompapator();
        PriorityQueue<String> pq = new PriorityQueue<String>(stringComparator);
//        MinPriorityQueues pq = new MinPriorityQueues();
//        MaxPriorityQueueComparator maxComparator = new MaxPriorityQueueComparator();
//        PriorityQueue<Integer> pq = new PriorityQueue<>(maxComparator);
//        int arr[] = {5, 1, 9, 2, 0};
        String arr[] = {"I", "Boy", "Good", "AM"};
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.remove() + " ");
        }
        System.out.println();
    }

}
