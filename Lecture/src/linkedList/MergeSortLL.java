package linkedList;
/*
Given a singly linked list of integers, sort it using 'Merge Sort.'
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSortLL {
    public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
        //Your code goes here
        if(head==null ){
            return head;
        }
        if(head.next==null) {
            return head;
        }
        LinkedListNode<Integer> mid = midpoint(head);
        LinkedListNode<Integer> secondPart = mid.next;
        mid.next = null;
        LinkedListNode<Integer> firstPart = head;
        LinkedListNode<Integer> firstHalf = mergeSort(firstPart);
        LinkedListNode<Integer> secondHalf = mergeSort(secondPart);
        return mergeTwoSortedLinkedLists(firstHalf,secondHalf);
    }
    public static LinkedListNode<Integer> midpoint(LinkedListNode<Integer> head){
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static LinkedListNode<Integer> mergeTwoSortedLinkedLists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2){
        if(head1==null) {
            return head2;
        }
        if(head2==null) {
            return head1;
        }
        LinkedListNode<Integer> tail1 = head1,tail2 = head2,head3 = null, tail3 = null;
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
        while(tail1!=null && tail2 != null){
            if(tail1.data <= tail2.data){
                tail3.next = tail1;
                tail3 = tail3.next;
                tail1 = tail1.next;
            }
            else{
                tail3.next = tail2;
                tail3 = tail3.next;
                tail2 = tail2.next;
            }
        }
        if(tail1==null){
            tail3.next = tail2;
        }
        else{
            tail3.next = tail1;
        }
        return head3;
    }

}


 class Runner11 {

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

    public static void print(LinkedListNode<Integer> head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {

            LinkedListNode<Integer> head = takeInput();

            LinkedListNode<Integer> newHead = MergeSortLL.mergeSort(head);
            print(newHead);

            t -= 1;
        }

    }
}