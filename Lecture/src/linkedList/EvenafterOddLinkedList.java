package linkedList;
/*
For a given singly linked list of integers,
arrange the elements such that all the even numbers are placed after the odd numbers.
The relative order of the odd and even terms should remain unchanged.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
For a given singly linked list of integers, arrange the elements such that all the even numbers are placed after the odd numbers.
 The relative order of the odd and even terms should remain unchanged.
 */
public class EvenafterOddLinkedList {
    public static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {
        //Your code goes here
        LinkedListNode<Integer> evenHead = null, oddHead = null,evenTail = null,oddTail = null, temp = head;
        while(temp != null){
            if(temp.data % 2 != 0){
                if(oddHead == null && oddTail == null){
                    oddHead = temp;
                    oddTail = temp;
                }
                else {
                    oddTail.next = temp;
                    oddTail = temp;
                }


            }
            else{
                if(evenHead == null && evenTail == null){
                    evenHead = temp;
                    evenTail = temp;
                }
                else {
                    evenTail.next = temp;
                    evenTail = temp;
                }

            }
            temp = temp.next;

        }
        if(evenTail != null && oddTail != null){
            evenTail.next = null;
            oddTail.next = null;
            oddTail.next = evenHead;
            head = oddHead;
        }
        else if(evenTail == null){
            head = oddHead;
        }
        else{
            head = evenHead;
        }
        return head;
    }
}


 class Runner15 {

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

            LinkedListNode<Integer> newHead = EvenafterOddLinkedList.evenAfterOdd(head);
            print(newHead);

            t -= 1;
        }

    }
}