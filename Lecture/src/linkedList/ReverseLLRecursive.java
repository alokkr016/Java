package linkedList;
/*
Given a singly linked list of integers, reverse it using recursion and return the head to the modified list.
You have to do this in O(N) time complexity where N is the size of the linked list.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ReverseLLRecursive {
    public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head) {
        //Your code goes here
        if(head == null || head.next == null){
            return head;
        }
        LinkedListNode<Integer> tail = head.next;
        LinkedListNode<Integer> finalAns = reverseLinkedListRec(head.next);
        tail.next = head;
        head.next = null;
        return finalAns;
    }
    public static LinkedListNode<Integer> reverseLinkedListRec2(LinkedListNode<Integer> head) {
        if(head == null || head.next == null){
            return head;
        }
        LinkedListNode<Integer> finalHead = reverseLinkedListRec2(head.next);
        LinkedListNode<Integer> temp = finalHead;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        head.next = null;
        return finalHead;
    }
    public static LinkedListNode<Integer> reverseLinkedListRec3(LinkedListNode<Integer> head) {
        DoubleNode node = new DoubleNode();
        node = reverseLinkedListRec4(head);
        return node.head;
    }
    public static DoubleNode reverseLinkedListRec4(LinkedListNode<Integer> head) {
        if(head == null || head.next == null){
            DoubleNode ans = new DoubleNode();
            ans.head = head;
            ans.tail = head;
            return ans;
        }
        DoubleNode smallAns = reverseLinkedListRec4(head.next);
        smallAns.tail.next = head;
        head.next = null;
        DoubleNode ans = new DoubleNode();
        ans.head = smallAns.head;
        ans.tail = head;
        return ans;
    }
}


 class Runner12 {

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

            LinkedListNode<Integer> newHead = ReverseLLRecursive.reverseLinkedListRec3(head);
            print(newHead);

            t -= 1;
        }

    }
}