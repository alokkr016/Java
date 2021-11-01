package priorityQueues;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MaxPriorityQueue {
    ArrayList<Integer> heap;

    public MaxPriorityQueue() {
        heap = new ArrayList<Integer>();
    }

    boolean isEmpty() {
        // Implement the isEmpty() function here
        return heap.size() == 0;
    }

    int getSize() {
        // Implement the getSize() function here
        return heap.size();
    }

    int getMax() {
        // Implement the getMax() function here
        return heap.get(0);
    }

    void insert(int element) {
        // Implement the insert() function here
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0) {
            if (heap.get(childIndex) > heap.get(parentIndex)) {
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }

    }

//    int removeMax() throws PriorityQueueException {
//          if(heap.isEmpty()){
//            throw new PriorityQueueException();
//}
//}
        int removeMax(){
        // Implement the removeMax() function here
        if(heap.isEmpty()){
//            throw new PriorityQueueException();
        return -1;
        }


        int ans = heap.get(0);
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int index = 0;
        int maxIndex = index;
        int leftIndex = 1;
        int rightIndex = 2;

        while(leftIndex < heap.size()){
            if(heap.get(leftIndex) > heap.get(maxIndex)){
                maxIndex = leftIndex;
            }

            if(rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex)){
                maxIndex = rightIndex;
            }

            if(maxIndex == index){
                break;
            }
            else{
                int temp1 = heap.get(index);
                heap.set(index,heap.get(maxIndex));
                heap.set(maxIndex,temp1);
                index = maxIndex;
                leftIndex = 2 * index  + 1;
                rightIndex = 2 * index + 2;
            }
        }
        return ans;
    }
}



 class Main2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());
        MaxPriorityQueue pq = new MaxPriorityQueue();
        int choice = Integer.parseInt(st.nextToken());
        while(choice != -1) {
            switch(choice) {
                case 1 : // insert
                    int element = Integer.parseInt(st.nextToken());
                    pq.insert(element);
                    break;
                case 2 : // getMax
                    System.out.println(pq.getMax());
                    break;
                case 3 : // removeMax
                    System.out.println(pq.removeMax());
                    break;
                case 4 : // size
                    System.out.println(pq.getSize());
                    break;
                case 5 : // isEmpty
                    System.out.println(pq.isEmpty());
                default :
                    return;
            }
            choice = Integer.parseInt(st.nextToken());
        }
    }

}