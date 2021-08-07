package linkedList;
/*
You have been given a singly linked list of integers along with two integers, 'i,' and 'j.'
Swap the nodes that are present at the 'i-th' and 'j-th' positions.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwaptwoNodesofLL {
    public static LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int i, int j) {
        //Your code goes here
        LinkedListNode<Integer> prev1 = null, prev2 = null, curr1 = head, curr2 = head;
        int k = 0;
        while(k < i){
            prev1 = curr1;
            curr1 = curr1.next;
            k++;
        }
        int l = 0;
        while(l < j){
            prev2 = curr2;
            curr2 = curr2.next;
            l++;
        }
        prev1.next = curr2;
        prev2.next = curr1;
        LinkedListNode<Integer> temp = curr2.next;
        curr2.next = curr1.next;
        curr1.next = temp;

        return head;
    }


}



 class Runner18 {

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
            String[] i_j = br.readLine().trim().split("\\s");

            int i = Integer.parseInt(i_j[0]);
            int j = Integer.parseInt(i_j[1]);

            LinkedListNode<Integer> newHead = SwaptwoNodesofLL.swapNodes(head, i, j);
            print(newHead);

            t -= 1;
        }

    }
}