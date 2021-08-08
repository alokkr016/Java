package linkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BubbleSortLL {
    public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head) {
        //Your code goes here
        if(head == null || head.next == null){
            return head;
        }
//        LinkedListNode<Integer> temp = head;
        for(int i=0;i<lengthLL(head)-1;i++) {
            LinkedListNode<Integer> prev = null;
            LinkedListNode<Integer> curr = head;
            LinkedListNode<Integer> forw = head.next;
            while (curr.next != null) {
                if (curr.data > curr.next.data) {
                    if (prev == null) {
                        curr.next = forw.next;
                        forw.next = curr;
                        prev = forw;
                        head = prev;
                    } else {
                        forw = curr.next;
                        curr.next = forw.next;
                        prev.next = forw;
                        forw.next = curr;
                        prev = forw;

                    }

                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }
        }
        return head;
    }
    private static int lengthLL(LinkedListNode<Integer> head){
        int count = 1;
        while(head.next != null){
            head = head.next;
            count++;
        }
        return count;
    }
}




 class Runner20 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static LinkedListNode<Integer> takeInput() throws IOException {
        LinkedListNode<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
            if(head == null) {
                head = newNode;
                tail = newNode;
            }
            else {
                tail.next = newNode;
                tail = newNode;
            }
            i += 1;
        }

        return head;
    }

    public static void print(LinkedListNode<Integer> head){
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        LinkedListNode<Integer> head = takeInput();

        head = BubbleSortLL.bubbleSort(head);
        print(head);
    }
}