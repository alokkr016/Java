package queue;

public class QueueUse {
    public static void main(String[] args) throws QueueEmptyException {
        QueueUsingArray queue = new QueueUsingArray(3);
        for (int i = 1; i <= 5; i++) {
            try {
                queue.enqueue(i);
            } catch (QueueFullException e) {
            }
        }
        while (!queue.isEmpty()) {
            try {
                System.out.println(queue.dequeue());
            } catch (QueueEmptyException e) {
                e.printStackTrace();
            }
        }
        /*
        =============================================================
         */
        QueueUsingLinkedListGeneric<Integer> queue2 = new QueueUsingLinkedListGeneric<>();
        for (int i = 1; i <= 5; i++) {
            queue2.enqueue(i);
        }
        while (!queue2.isEmpty()) {
            try {
                System.out.println(queue2.dequeue());
            } catch (QueueEmptyException e) {
                e.printStackTrace();
            }
        }
    }
}
