package linkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
Given a singly linked list of integers and an integer n,
 find and return the index for the first occurrence of 'n' in the linked list. -1 otherwise.
 */
public class FindaNodeInLL {
    public static int findNodeRec(LinkedListNode<Integer> head, int n) {
        //Your code goes here
        return findNodeRec(head,n,0);
    }
    public static int findNodeRec(LinkedListNode<Integer> head, int n,int index) {
        if(head == null){
            return -1;
        }
        if(head.data == n){
            return index;
        }
        return findNodeRec(head.next,n,index + 1);
    }

}

 class Runner16 {

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
            int n = Integer.parseInt(br.readLine().trim());

            System.out.println(FindaNodeInLL.findNodeRec(head, n));

            t -= 1;
        }

    }
}