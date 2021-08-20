package testTwoLevel;
/*
Given a Singly Linked List of integers, delete all the alternate nodes in the list.
 */

import java.util.Scanner;

public class DeleteAlternateNodes {
    public static void deleteAlternateNodes(Node1<Integer> head) {
        //Your code goes here
        if(head==null){
            return ;
        }
        Node1<Integer> temp = head;
        while (temp != null && temp.next != null   ){
            temp.next = temp.next.next;
            temp = temp.next;
        }
    }
}
class Node1<T> {
    public T data;
    public Node1<T> next;

    public Node1(T data) {
        this.setData(data);
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}

 class Runner3 {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        Node1<Integer> list = input();
        DeleteAlternateNodes.deleteAlternateNodes(list);
        print(list);
    }

    public static void print(Node1<Integer> head) {
        while (head != null) {
            System.out.print(head.getData() + " ");
            head = head.next;
        }
    }

    public static Node1<Integer> input() {
        int data = s.nextInt();

        Node1<Integer> head = null;
        Node1<Integer> tail = null;
        while (data!=-1) {
            Node1<Integer> newNode = new Node1<Integer>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            data = s.nextInt();
        }
        return head;
    }

}