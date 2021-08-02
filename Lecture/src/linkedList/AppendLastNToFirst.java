package linkedList;

/*
You have been given a singly linked list of integers along with an integer 'N'. Write a function to
append the last 'N' nodes towards the front of the singly linked list and returns the new head to the list.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class AppendLastNToFirst {
    public static LinkedListNode<Integer> appendLastNToFirst(LinkedListNode<Integer> head, int n) {
        if(head == null || n == 0){
            return head;
        }

        LinkedListNode<Integer> temp = head;
        int count=0;
        while(temp!=null ){
            temp=temp.next;
            count++;
        }

        LinkedListNode<Integer>temp1 = head;
        LinkedListNode<Integer> initial = head;
        int length = count - n;
        int i=0;
        while(i< length - 1)
        {
            temp1=temp1.next;
            i++;
        }
        head = temp1.next;
        temp1.next = null;
        LinkedListNode<Integer> tempHead = head;
        while(tempHead.next != null){
            tempHead = tempHead.next;
        }
        tempHead.next = initial;

        return head;
    }
}


 class Runner5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static LinkedListNode<Integer> takeInput() throws IOException {
        LinkedListNode<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while (i < datas.length && !datas[i].equals("-1")) {
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

            int n = Integer.parseInt(br.readLine().trim());
            head = AppendLastNToFirst.appendLastNToFirst(head, n);
            print(head);

            t -= 1;
        }

    }
}
