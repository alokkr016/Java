package binaryTree;

import java.util.Scanner;

public class BinaryTreeUse {

    public static BinaryTreeNode<Integer> takeInput(Scanner s){
        int data;
        System.out.println("Enter the root of the Tree: ");
        data = s.nextInt();
        if(data == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
        root.left = takeInput(s);
        root.right = takeInput(s);
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(4);
        root.left = node1;
        root.right = node2;

    }
}
