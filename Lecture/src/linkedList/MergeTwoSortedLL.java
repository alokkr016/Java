package linkedList;
/*
You have been given two sorted(in ascending order) singly linked lists of integers.
Write a function to merge them in such a way that the resulting
singly linked list is also sorted(in ascending order) and return the new head to the list.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class MergeTwoSortedLL {
    public static LinkedListNode<Integer> mergeTwoSortedLinkedLists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        //Your code goes here
        if(head1==null) {
            return head2;
        }
        if(head2==null) {
            return head1;
        }
        LinkedListNode<Integer> tail1 = head1;
        LinkedListNode<Integer> tail2 = head2;
        LinkedListNode<Integer> tail3 = null;
        LinkedListNode<Integer> head3 = null;

        if(tail1.data <= tail2.data){
            head3 = tail1;
            tail3 = tail1;
            tail1 = tail1.next;
        }
        else{
            head3 = tail2;
            tail3 = tail2;
            tail2 = tail2.next;
        }
        while(tail1 != null && tail2 != null){
            if(tail1.data <= tail2.data){
                tail3.next = tail1;
                tail1 = tail1.next;
                tail3 = tail3.next;

            }
            else{
                tail3.next = tail2;
                tail2 = tail2.next;
                tail3 = tail3.next;
            }
        }
        if(tail1 == null){
            tail3.next = tail2;
        }
        else{
            tail3.next = tail1;
        }
        return head3;
    }

}



 class Runner10 {

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

        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {

            LinkedListNode<Integer> head1 = takeInput();
            LinkedListNode<Integer> head2 = takeInput();

            LinkedListNode<Integer> newHead = MergeTwoSortedLL.mergeTwoSortedLinkedLists(head1, head2);
            print(newHead);

            t -= 1;
        }

    }
}