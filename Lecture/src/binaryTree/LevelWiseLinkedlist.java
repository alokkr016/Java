package binaryTree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.*;
 //10 9 11 8 -1 -1 12 7 -1 -1 13 -1 -1 -1 -1   4 2 6 1 3 5 7 -1 -1 -1 -1 -1 -1 -1 -1
class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}

class Node<T> {
    T data;
    Node<T> next;
    Node(T data){
        this.data = data;
    }
}

public class LevelWiseLinkedlist {

    public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){
        if(root==null) {
            return null;
        }

        QueueUsingLL<BinaryTreeNode<Integer>> queue = new QueueUsingLL<>();
        queue.enqueue(root);
        queue.enqueue(null);

        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> tail = null;

        ArrayList<LinkedListNode<Integer>> output = new ArrayList<>();

        while(!queue.isEmpty()){

            BinaryTreeNode<Integer> temp = null;

            try {
                temp = queue.dequeue();
            } catch (QueueEmptyException e) {
                e.printStackTrace();
            }

            LinkedListNode<Integer> node = null;

            if(temp == null){
                output.add(head);
                head = null;
                tail = null;
                continue;
            }

            if(temp != null){
                node = new LinkedListNode<>(temp.data);
            }

            if(head == null){
                head = node;
                tail = node;
            }
            else{
                tail.next = node;
                tail = tail.next;
            }

            if(temp.left != null){
                queue.enqueue(temp.left);
            }
            if(temp.right != null){
                queue.enqueue(temp.right);
            }
            queue.enqueue(null);



        }
        return output;
    }
}

    class Main123 {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;

        public static BinaryTreeNode<Integer> takeInput() throws IOException {
            st = new StringTokenizer(br.readLine());
            int rootData = Integer.parseInt(st.nextToken());
            if (rootData == -1) {
                return null;
            }
            QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>();
            BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
            pendingNodes.enqueue(root);

            while (!pendingNodes.isEmpty()) {
                BinaryTreeNode<Integer> currentNode;
                try {
                    currentNode = pendingNodes.dequeue();
                } catch (QueueEmptyException e) {
                    return null;
                }
                int leftChildData = Integer.parseInt(st.nextToken());
                if (leftChildData != -1) {
                    BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
                    currentNode.left = leftChild;
                    pendingNodes.enqueue(leftChild);
                }
                int rightChildData = Integer.parseInt(st.nextToken());
                if (rightChildData != -1) {
                    BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
                    currentNode.right = rightChild;
                    pendingNodes.enqueue(rightChild);
                }
            }
            return root;
        }

        private static void print(LinkedListNode<Integer> temp)
        {
            while(temp != null){
                System.out.print(temp.data + " ") ;
                temp = temp.next;
            }
            System.out.println();
        }

        public static void main(String[] args) throws IOException {
            BinaryTreeNode<Integer> root = takeInput();
            ArrayList<LinkedListNode<Integer>> output = LevelWiseLinkedlist.constructLinkedListForEachLevel(root);
            if(output!=null)
            {
                for(LinkedListNode<Integer> head : output){
                    print(head);

                }
            }
        }

    }