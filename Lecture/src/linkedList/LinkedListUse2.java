package linkedList;

import java.util.Scanner;

public class LinkedListUse2 {
    private static LinkedListNode<Integer> takeInput() {
        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> tail = null;
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        while(data != -1){
            LinkedListNode<Integer> node = new LinkedListNode<>(data);
            if(head == null){
                head = node;
                tail = node;
            }
            else {
                tail.next = node;
                tail = tail.next;
            }
            data = s.nextInt();
        }
        return head;
    }
    private static void print(LinkedListNode<Integer> head){
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = takeInput();
        print(head);
    }


}
