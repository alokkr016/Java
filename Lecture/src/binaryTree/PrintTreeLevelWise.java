package binaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class PrintTreeLevelWise {
    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if(root == null){
            return;
        }
        QueueUsingLL<BinaryTreeNode<Integer>> pending = new QueueUsingLL<>();
        pending.enqueue(root);
        while (!pending.isEmpty()) {
            BinaryTreeNode<Integer> ans;
            try {
                ans = pending.dequeue();
            } catch (QueueEmptyException e) {
                return;
            }
            String s = ans.data + ":";
            if (ans.left != null) {
                s += "L:" + ans.left.data + ",";
                pending.enqueue(ans.left);
            } else {
                s += "L:" + "-1" + ",";
            }

            if (ans.right != null) {
                s += "R:" + ans.right.data;
                pending.enqueue(ans.right);
            } else {
                s += "R:" + "-1";
            }
            System.out.println(s);

        }
    }
}

class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static BinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
        QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>();
        int start = 0;

        String[] nodeDatas = br.readLine().trim().split(" ");

        if (nodeDatas.length == 1) {
            return null;
        }

        int rootData = Integer.parseInt(nodeDatas[start]);
        start += 1;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        pendingNodes.enqueue(root);

        while(!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.dequeue();
            } catch (QueueEmptyException e) {
                return null;
            }

            int leftChildData = Integer.parseInt(nodeDatas[start]);
            start += 1;

            if(leftChildData != -1){
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
                currentNode.left = leftChild;
                pendingNodes.enqueue(leftChild);
            }

            int rightChildData = Integer.parseInt(nodeDatas[start]);
            start += 1;

            if(rightChildData != -1){
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
                currentNode.right = rightChild;
                pendingNodes.enqueue(rightChild);
            }
        }

        return root;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BinaryTreeNode<Integer> root = takeInput();

        PrintTreeLevelWise.printLevelWise(root);
    }
}