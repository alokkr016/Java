package linkedList;
/*
You have been given a singly linked list of integers. Write a function that returns the index/position of integer data denoted by 'N' (if it exists). Return -1 otherwise.
Note :
Assume that the Indexing for the singly linked list always starts from 0.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindANodeInLinkedList {
    public static int findNode(LinkedListNode<Integer> head, int n) {
        // Write your code here.
        LinkedListNode<Integer> temp = head;
        int count = 0;
        boolean found = false;
        while(!found && temp != null){
            if(temp.data == n){
                found = true;
                break;
            }
            count++;
            temp = temp.next;
        }
        if(!found){
            return -1;
        }
        return count;
    }
}

 class Runner4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static LinkedListNode<Integer> takeInput() throws IOException {
        LinkedListNode<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            LinkedListNode<Integer> newNode = new LinkedListNode<>(data);
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
            int n = Integer.parseInt(br.readLine().trim());

            System.out.println(FindANodeInLinkedList.findNode(head, n));

            t -= 1;
        }

    }
}