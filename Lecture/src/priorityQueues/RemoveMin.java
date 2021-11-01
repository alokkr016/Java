package priorityQueues;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RemoveMin {
    private ArrayList<Integer> heap;

    public RemoveMin() {
        heap = new ArrayList<Integer>();
    }

    boolean isEmpty() {
        return heap.size() == 0;
    }

    int size() {
        return heap.size();
    }

    int getMin() throws PriorityQueueException {
        if (isEmpty()) {
            // Throw an exception
            throw new PriorityQueueException();
        }
        return heap.get(0);
    }

    void insert(int element) {
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0) {
            if (heap.get(childIndex) < heap.get(parentIndex)) {
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

    int removeMin() throws PriorityQueueException {
        if (heap.isEmpty()) {
            throw new PriorityQueueException();
        }

        int lastElement = heap.get(heap.size() - 1);
        int ans = heap.get(0);
        heap.set(0, lastElement);
        heap.remove(heap.size() - 1);

        int index = 0;
        int minIndex = index;
        int leftIndex = 1;
        int rightIndex = 2;

        while (leftIndex < heap.size()) {
            if(heap.get(leftIndex) < heap.get(minIndex)){
                minIndex = leftIndex;
            }
            if(rightIndex < heap.size() && heap.get(rightIndex) < heap.get(minIndex)){
                minIndex = rightIndex;
            }
            if(minIndex == index){
                break;
            }
            else{
                int temp1 = heap.get(index);
                heap.set(index, heap.get(minIndex));
                heap.set(minIndex, temp1);
                index = minIndex;
                leftIndex = 2 * index  + 1;
                rightIndex = 2 * index + 2;
            }
        }

        return ans;
    }
}


class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ;
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());
        RemoveMin pq = new RemoveMin();
        int choice = Integer.parseInt(st.nextToken());
        while (choice != -1) {
            switch (choice) {
                case 1: // insert
                    int element = Integer.parseInt(st.nextToken());
                    pq.insert(element);
                    break;
                case 2: // getMin
                    try {
                        System.out.println(pq.getMin());
                    } catch (PriorityQueueException e) {
                        System.out.println(Integer.MIN_VALUE);
                        return;
                    }
                    break;
                case 3: // removeMin
                    try {
                        System.out.println(pq.removeMin());
                    } catch (PriorityQueueException e) {
                        System.out.println(Integer.MIN_VALUE);
                        return;
                    }
                    break;
                case 4: // size
                    System.out.println(pq.size());
                    break;
                case 5: // isEmpty
                    System.out.println(pq.isEmpty());
                default:
                    return;
            }
            choice = Integer.parseInt(st.nextToken());
        }
    }

}