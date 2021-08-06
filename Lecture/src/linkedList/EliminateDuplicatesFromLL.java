package linkedList;
/*
You have been given a singly linked list of integers where the elements are sorted in ascending order. Write a function that removes the consecutive duplicate values such that the given
list only contains unique elements and returns the head to the updated list.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
public class EliminateDuplicatesFromLL {
    public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
        //Your code goes here
        LinkedListNode<Integer> temp1 = head;
        LinkedListNode<Integer> temp2 = head.next;
        LinkedListNode<Integer> initialHead = head;
        while(temp2 != null){
            if(temp1.data == temp2.data){
                temp2 = temp2.next;
            }
            else{
                temp1.next = temp2;
                temp1 = temp2;
            }
        }
        temp1.next = null;
        return head;
    }

}



 class Runner6 {

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

            LinkedListNode<Integer> head = takeInput();

            head = EliminateDuplicatesFromLL.removeDuplicates(head);
            print(head);

            t -= 1;
        }

    }
}