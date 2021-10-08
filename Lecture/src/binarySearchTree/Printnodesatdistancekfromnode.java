package binarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
You are given a Binary Tree of type integer, a target node, and an integer value K.
Print the data of all nodes that have a distance K from the target node.
 The order in which they would be printed will not matter.
 */
public class Printnodesatdistancekfromnode {
    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
        //Your code goes here
    }

}





 class Runner33 {

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
        String[] target_k = br.readLine().trim().split(" ");

        int target = Integer.parseInt(target_k[0].trim());
        int k = Integer.parseInt(target_k[1].trim());

        Printnodesatdistancekfromnode.nodesAtDistanceK(root, target, k);
    }
}
