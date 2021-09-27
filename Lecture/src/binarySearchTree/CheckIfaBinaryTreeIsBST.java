package binarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckIfaBinaryTreeIsBST {
    public static boolean isBST(BinaryTreeNode<Integer> root) {

        if(root==null) {
            return true;
        }

        int max=maximum(root.left);
        int min=minimum(root.right);
        if(root.data<=max || root.data>min) {
            return false;
        }

        boolean ans1=isBST(root.left);
        boolean ans2=isBST(root.right);
        return(ans1&& ans2);

    }
    public static int maximum(BinaryTreeNode<Integer> root)
    {
        if(root==null)
            return Integer.MIN_VALUE;
        return Math.max(root.data,Math.max(maximum(root.left),maximum(root.right)));


    }
    public static int minimum(BinaryTreeNode<Integer> root)
    {
        if(root==null)
            return Integer.MAX_VALUE;
        return Math.min(root.data,Math.min(minimum(root.left),minimum(root.right)));
    }


    public static Pair<Boolean,Pair<Integer,Integer>> isBST2(BinaryTreeNode<Integer> root){
        if(root==null){
            Pair<Boolean,Pair<Integer,Integer>> output = new Pair<>();
            output.first = true;
            output.second.first =  Integer.MAX_VALUE;
            output.second.second =  Integer.MIN_VALUE;
            return output;
        }

        Pair<Boolean,Pair<Integer,Integer>> leftOutput = isBST2(root.left);
        Pair<Boolean,Pair<Integer,Integer>> rightOutput = isBST2(root.right);

        int min = Math.min(root.data, Math.max(leftOutput.second.first, rightOutput.second.first));
        int max = Math.max(root.data, Math.max(leftOutput.second.second, rightOutput.second.second));
        Boolean isBST = (root.data > min && root.data <= max
                && leftOutput.first && rightOutput.first);

        Pair<Boolean,Pair<Integer,Integer>> output = new Pair<>();
        output.first = isBST;
        output.second.first =  min;
        output.second.second =  max;
        return output;
    }

    public static boolean isBST3(BinaryTreeNode<Integer> root, int min, int max){
        if(root == null){
            return true;
        }

        if(root.data < min || root.data > max){
            return false;
        }

        boolean isLeftOk = isBST3(root.left, min, root.data -1);
        boolean isRightOk = isBST3(root.right,root.data + 1, max);

        return isLeftOk && isRightOk;
    }
}


class Runner2 {

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

        boolean ans = CheckIfaBinaryTreeIsBST.isBST(root);
        Pair<Boolean,Pair<Integer, Integer>> ans2 = new Pair<>();
        ans2 = CheckIfaBinaryTreeIsBST.isBST2(root);

        System.out.println(ans);
        System.out.println(ans2.first);
    }
}