package linkedList;

public class LinkedListUse3 {

    public static void main(String[] args) {
        LinkedListNode<Integer> node1 = new LinkedListNode<>(10);
        LinkedListNode<Integer> node2 = new LinkedListNode<>(20);
        LinkedListNode<Integer> node3 = new LinkedListNode<>(30);
        LinkedListNode<Integer> node4 = new LinkedListNode<>(40);
        LinkedListNode<Integer> node5 = new LinkedListNode<>(50);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        LinkedListNode<Integer> head = node1;

        System.out.println(head);
        System.out.println(node1);
        while (head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }
}
