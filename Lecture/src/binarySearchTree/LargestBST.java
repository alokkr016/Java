package binarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
Given a Binary tree, find the largest BST subtree.
 That is, you need to find the BST with maximum height in the given binary tree.
 You have to return the height of largest BST.
 */
public class LargestBST {
    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
        // Write your code here
        Help ans = new Help();
        ans = largestBST(root);
        return ans.height;
    }

    public static Help largestBST(BinaryTreeNode<Integer> root) {
        if (root == null) {
            Help ans = new Help();
            ans.min = Integer.MIN_VALUE;
            ans.max = Integer.MAX_VALUE;
            ans.isBst = true;
            ans.height = 0;
            return ans;
        }

        Help rightAns = largestBST(root.right);
        Help leftAns = largestBST(root.left);

        if(!(leftAns.isBst && leftAns.max < root.data)){
            leftAns.isBst = false;
        }

        if(!(rightAns.isBst && rightAns.min > root.data)){
            rightAns.isBst = false;
        }
        if(!leftAns.isBst || !rightAns.isBst || root.data < leftAns.max || root.data > rightAns.min){
            if(leftAns.height > rightAns.height){
                leftAns.isBst = false;
                return leftAns;
            }
            else{
                rightAns.isBst = false;
                return rightAns;
            }
        }
        Help output = new Help();
        output.min = Math.max(leftAns.min, Math.max(rightAns.min, root.data));
        output.max = Math.max(leftAns.max, Math.max(rightAns.max, root.data));
        output.isBst = true;
        output.height = Math.max(leftAns.height, rightAns.height) + 1;

        return output;


    }

    //  isBst check
    public static int height(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int height1 = height(root.left);
        int height2 = height(root.right);

        return Math.max(height1 + 1, height2 + 1);
    }

    public static boolean isBst(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return true;
        }

        if (root.left != null && root.left.data > root.data) {
            return false;
        }

        if (root.right != null && root.right.data < root.data) {
            return false;
        }

        if (!isBst(root.left) || !isBst(root.right)) {
            return false;
        }
        return true;
    }
}

class Help{
    int min;
    int max;
    boolean isBst;
    int height;
}

 class Main29 {

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
        System.out.println(LargestBST.largestBSTSubtree(root));
    }

}