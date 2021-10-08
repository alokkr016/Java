package binarySearchTree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
/*
Given a binary search tree and data of two nodes,
find 'LCA' (Lowest Common Ancestor) of the given two nodes in the BST.
 */
public class LCAofBST {
    public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
        BinaryTreeNode<Integer> output = getLCAHelp(root,a.b);
        return (output == null) ? -1 : output.data;
    }
//        if(root == null){
//            return -1;
//        }
//        if(root.left != null && root.right != null){
//            if(root.left.data == a && root.right.data == b){
//            return root.data;
//            }
//        }
//
//        if(root.left == null || root.right == null){
//            return root.data;
//        }
//
//        if(a < root.data && b >= root.data){
//            return root.data;
//        }
//
//        if(b < root.data){
//            return getLCA(root.left,a,b);
//        }
//        if(root.data != null && a >= root.data) {
//            return getLCA(root.right, a, b);
//        }
//        return -1;
//

    }
}



 class Main25 {

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
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        System.out.println(LCAofBST.getLCA(root, a, b));
    }

}