package linkedList;

import java.util.Scanner;

public class LinkedListUse {
    public static LinkedListNode<Integer> insertAtN(LinkedListNode<Integer> head,int element,int pos){
        LinkedListNode<Integer> newNode = new LinkedListNode<>(element);
        if (pos == 0){
            newNode.next = head;
            return newNode;
        }
        int i = 0;
        LinkedListNode<Integer> temp = head;
        while (i < pos - 1){
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    public static LinkedListNode<Integer> takeInput(){
       LinkedListNode<Integer> head = null;
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        while (data != -1){
            LinkedListNode<Integer> newNode = new LinkedListNode<>(data);
            if(head == null){
                head = newNode;
            }
            else {
                LinkedListNode<Integer> temp = head;
                while(temp.next != null){
                    temp = temp.next;
                }
                temp.next = newNode;
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
    public static void main(String[] args) {
        LinkedListNode<Integer> head = takeInput();
        print(head);
        head = insertAtN(head,15,2);
        print(head);
//        LinkedListNode<Integer> node1 = new LinkedListNode<>(10);
//        LinkedListNode<Integer> node2 = new LinkedListNode<>(20);
//        LinkedListNode<Integer> node3 = new LinkedListNode<>(30);
//        node1.next = node2;
//        node2.next = node3;
//        LinkedListNode<Integer> head = node1;
//        while(head != null){
//            System.out.println(head.data);
//            head = head.next;
        }
    }
