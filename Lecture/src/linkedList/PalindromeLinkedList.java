package linkedList;
/*
You have been given a head to a singly linked list of integers.
 Write a function check to whether the list given is a 'Palindrome' or not.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static linkedList.Runner9.print;

public class PalindromeLinkedList {
    public static boolean isPalindrome(LinkedListNode<Integer> head) {
        if(head == null){
            return true;
        }
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head.next;
        LinkedListNode<Integer> initial = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        head = slow.next;
        LinkedListNode<Integer> reverseList = reverseLinkedList(head);
        slow.next = null;
        head = initial;

        boolean check = true;
        while(head != null && reverseList != null) {
            if (head.data != reverseList.data){
                check = false;
                break;
            }
            else{
                head=head.next;
                reverseList = reverseList.next;

            }
        }
        return check;
    }
    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head){
        if(head == null || head.next == null){
            return head;
        }
        LinkedListNode<Integer> tail = head.next;
        LinkedListNode<Integer> finalAns = reverseLinkedList(head.next);
        tail.next = head;
        head.next = null;
        return finalAns;
    }
}

/*
static LinkedListNode<Integer> left=null;
  	public static boolean isPalindrome(LinkedListNode<Integer> head) {

      left=head;
      return find(head);

  	}
  public static boolean find(LinkedListNode<Integer> right){
   	 if(right==null){
        return true;
      }
      boolean val=find(right.next);
      if(val==true){
        if(left.data==right.data){
          left=left.next;
          return true;
        }
      }
      return false;
  }
}
 */

 class Runner8 {

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

            boolean ans = PalindromeLinkedList.isPalindrome(head);
            System.out.println(ans);

            t -= 1;

        }

    }
}