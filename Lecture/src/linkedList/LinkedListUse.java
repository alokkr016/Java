package linkedList;

import java.util.Scanner;

public class LinkedListUse {
    public static LinkedListNode<Integer> deleteAtN(LinkedListNode<Integer> head,int pos){
        LinkedListNode<Integer> temp = head;
        if(pos == 0){
            head = head.next;
            return head;
        }
        int i = 0;
        while (i < pos - 1){
            temp = temp.next;
            i++;
        }
        LinkedListNode<Integer> temp2 = temp.next;
        temp.next = temp2.next;
        return head;
    }
    public static LinkedListNode<Integer> insertAtN(LinkedListNode<Integer> head,int element,int pos){
        LinkedListNode<Integer> newNode = new LinkedListNode<>(element);
        if (pos == 0){
            newNode.next = head;
            return newNode;
        }
        int i = 0;
//
        LinkedListNode<Integer> temp = head;
        while (i < pos - 1){
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        return temp;
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
        head = deleteAtN(head,0);
        head = deleteAtN(head,0);
        print(head);
//        head = insertAtN(head,15,2);
//        print(head);
        }
    }
