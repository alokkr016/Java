package binaryTree;

import java.util.Scanner;

public class BinaryTreeUse {

    public static int height(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if(root == null){
            return 0;
        }
        int height1 = height(root.left);
        int height2 = height(root.right);
        return Math.max(height1 + 1, height2 + 1);
    }

    public static int countNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int count = 1;
        count += countNodes(root.left);
        count += countNodes(root.right);

        return count;
    }
    public static BinaryTreeNode<Integer> takeInput(Scanner s){
        int data;
        System.out.println("Enter the root data ");
        data = s.nextInt();
        if(data == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
        root.left = takeInput(s);
        root.right = takeInput(s);
        return root;
    }
    public static BinaryTreeNode<Integer> takeInputLevelWise(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the root: ");
        BinaryTreeNode<Integer> node =  new BinaryTreeNode<>(s.nextInt());
        QueueUsingLL<BinaryTreeNode<Integer>> pending = new QueueUsingLL<>();
        pending.enqueue(node);

        while(!pending.isEmpty()){
            BinaryTreeNode<Integer> root;
            try {
                root = pending.dequeue();
            } catch (QueueEmptyException e) {
                return null;
            }
            System.out.println("Enter the left child of " + root.data);
            int leftChild = s.nextInt();
            if(leftChild != -1){
                BinaryTreeNode<Integer> child = new BinaryTreeNode<>(leftChild);
                pending.enqueue(child);
                root.left = child;
            }

            System.out.println("Enter the right child of " + root.data);
            int rightChild = s.nextInt();
            if(rightChild != -1){
                BinaryTreeNode<Integer> child = new BinaryTreeNode<>(rightChild);
                pending.enqueue(child);
                root.right = child;
            }

        }
        return node;

    }

    public static void printTreeLevelWise(BinaryTreeNode<Integer> root){
        QueueUsingLL<BinaryTreeNode<Integer>> pending = new QueueUsingLL<>();
        pending.enqueue(root);
        while(!pending.isEmpty()){
            BinaryTreeNode<Integer> ans;
            try {
                ans = pending.dequeue();
            } catch (QueueEmptyException e) {
                return;
            }
            String s = ans.data + " ";
            if(ans.left != null){
                s += "L: " + ans.left.data + " ";
                pending.enqueue(ans.left);
            }

            if(ans.right != null){
                s += "R:" + ans.right.data;
                pending.enqueue(ans.right);
            }
            System.out.println(s);
        }
    }

    public static void printTree(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        String toBePrinted = root.data + " ";
        if(root.left != null){
            toBePrinted += "L " + root.left.data + ", ";
        }
        if(root.right != null){
            toBePrinted += "R " + root.right.data;
        }
        System.out.println(toBePrinted);
        printTree(root.left);
        printTree(root.right);
    }
    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        BinaryTreeNode<Integer> root = takeInput(s);
        BinaryTreeNode<Integer> root = takeInputLevelWise();
//        System.out.println(countNodes(root));
//        printTreeLevelWise(root);

//        s.close();
//        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(2);
//        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(3);
//        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(4);
//        root.left = node1;
//        root.right = node2;

    }
}
