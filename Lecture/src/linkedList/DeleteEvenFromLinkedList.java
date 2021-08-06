package linkedList;

public class DeleteEvenFromLinkedList {
    public static LinkedListNode<Integer> deleteEven(LinkedListNode<Integer> head){
        if(head == null){
            return head;
        }
        if(head.next == null){
            if(head.data % 2 == 0){
                return null;
            }
            return head;
        }
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> curr = head;
        while(curr != null){
            if(curr.data % 2 != 0){
                prev = curr;
                curr = curr.next;
            }
            curr = curr.next;
            prev.next = curr;
        }
        return head;
    }
    public static void main(String[] args) {
        LinkedListNode<Integer> head = LinkedListUse.takeInput();
        head = deleteEven(head);
        LinkedListUse.print(head);
    }
}
