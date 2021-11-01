package priorityQueues;

public class PriorityQueueUse {
    public static void main(String[] args) throws PriorityQueueException {
        MinPriorityQueues pq = new MinPriorityQueues();
        int arr[] = {5, 1, 9, 2, 0};
        for (int i = 0; i < arr.length; i++) {
            pq.insert(arr[i]);
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.delete() + " ");
        }
        System.out.println();
    }

}
