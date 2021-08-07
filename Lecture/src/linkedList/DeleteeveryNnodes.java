package linkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeleteeveryNnodes {
    public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> temp, int M, int N) {
        //Your code goes here
        if(M ==0){
            return null;
        }
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> head = temp;
        while(head != null){
            int i = 1;
            while(i < M && head != null){
                head = head.next;
                prev = head;
                i++;
            }
            if(head == null){
                return temp;
            }
            int k = 1;
            while(k <= N && head != null){
                head = head.next;
                k++;
            }
            if(k != N + 1){
                prev.next = null;
                return temp;
            }

            if(head != null) {
                prev.next = head.next;
                head = head.next;
            }



        }
        return temp;
    }
}





 class Runner17 {

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
            String[] m_n = br.readLine().trim().split("\\s");

            int m = Integer.parseInt(m_n[0]);
            int n = Integer.parseInt(m_n[1]);

            LinkedListNode<Integer> newHead = DeleteeveryNnodes.skipMdeleteN(head, m, n);
            print(newHead);

            t -= 1;
        }

    }
}