package binarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BSTtoSortedLL {
    public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
        Pair<LinkedListNode<Integer>,LinkedListNode<Integer>> result = construct(root);
        return result.first;
    }
    public static Pair<LinkedListNode<Integer>,LinkedListNode<Integer>> construct(BinaryTreeNode<Integer> root){
        if(root == null){
            Pair<LinkedListNode<Integer>,LinkedListNode<Integer>> ans = new Pair<>();
            ans.first = null;
            ans.second = null;
            return ans;
        }
        LinkedListNode<Integer> node = new LinkedListNode<>(root.data);
        Pair<LinkedListNode<Integer>,LinkedListNode<Integer>> leftNode = construct(root.left);
        Pair<LinkedListNode<Integer>,LinkedListNode<Integer>> rightNode = construct(root.right);

        Pair<LinkedListNode<Integer>,LinkedListNode<Integer>> pair = new Pair<>();

        if(leftNode.second != null){
            leftNode.second.next = node;
        }
        node.next = rightNode.first;

        if(leftNode.first != null){
            pair.first = leftNode.first;
        }
        else{
            pair.first = node;
        }

        if(rightNode.second != null){
            pair.second = rightNode.second;
        }
        else{
            pair.second = node;
        }

        return pair;
    }
}

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}

class Main19 {

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

    public static void main(String[] args) throws IOException {
        BinaryTreeNode<Integer> root = takeInput();
        LinkedListNode<Integer> head = BSTtoSortedLL.constructLinkedList(root);
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

}