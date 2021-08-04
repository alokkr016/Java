package linkedList;

import java.util.Scanner;

public class InsertRecursively {
    public static LinkedListNode<Integer> takeInput(){
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        LinkedListNode<Integer> head = null,tail = null;
        while(data != -1){
            LinkedListNode<Integer> newNode = new LinkedListNode<>(data);
            if(head == null){
                head = newNode;
                tail = newNode;
            }
            else{
                tail.next = newNode;
                tail = tail.next;
            }
            data = s.nextInt();
        }
        return head;
    }
    public static void print(LinkedListNode<Integer> head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static LinkedListNode<Integer> insertAtGivenIndex(LinkedListNode<Integer> head,int pos,int element){
        if(pos == 0){
            LinkedListNode<Integer> newNode = new LinkedListNode<>(element);
            newNode.next = head;
            return newNode;
        }
        head.next = insertAtGivenIndex(head.next, pos - 1,element);
        return head;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = takeInput();
        print(head);
        head = insertAtGivenIndex(head,2,10);
        print(head);
    }
}
