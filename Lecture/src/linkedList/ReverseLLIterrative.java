package linkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class ReverseLLIterrative {
    public static LinkedListNode<Integer> reverse_I(LinkedListNode<Integer> head){
        if(head == null || head.next == null){
            return head;
        }
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> cur = head;

        LinkedListNode<Integer> temp;
        while(cur != null){
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}




 class Runner13 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static LinkedListNode<Integer> takeInput() throws IOException {
        LinkedListNode<Integer> head = null, tail = null;
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int data = Integer.parseInt(tk.nextToken());
        while(data != -1) {
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
            if(head == null) {
                head = newNode;
                tail = newNode;
            }
            else {
                tail.next = newNode;
                tail = newNode;
            }
            data = Integer.parseInt(tk.nextToken());
        }
        return head;
    }

    public static void print(LinkedListNode<Integer> head){
        while(head != null){
            System.out.print(head.data +" ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException{
        int t = Integer.parseInt(br.readLine().trim());
        while (t != 0){
            LinkedListNode<Integer> head = takeInput();
            LinkedListNode<Integer> ans = ReverseLLIterrative.reverse_I(head);
            print(ans);

            t--;
        }

    }
}