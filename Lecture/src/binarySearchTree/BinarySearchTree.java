package binarySearchTree;

import binaryTree.BinaryTreeUse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BinarySearchTree {
    private BinaryTreeNode<Integer> root;
    private BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root,int data){
        if(root == null){
            BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(data);
            return node;
        }
        if(data <= root.data){
            root.left = insertHelper(root.left,data);
        }
        else{
            root.right = insertHelper(root.right,data);
        }
        return root;
    }
    public void insert(int data) {
        //Implement the insert() function
        root = insertHelper(root,data);
    }
    public BinaryTreeNode<Integer> removeHelper(BinaryTreeNode<Integer> root,int data){
        if(root == null){
            return null;
        }
        if(data < root.data){
            root.left = removeHelper(root.left,data);
            return root;
        }
        else if(data > root.data){
            root.right = removeHelper(root.right,data);
            return root;
        }
        else {
            if (root.data == data && root.left == null && root.right == null) {
                return null;
            } else if (root.data == data && root.left != null && root.right == null) {
                return root.left;
            } else if (root.data == data && root.left == null && root.right != null) {
                return root.right;
            } else {
                BinaryTreeNode<Integer> minNode = root.right;
                while(minNode.left != null){
                    minNode = minNode.left;
                }
                root.data = minNode.data;
                root.right = removeHelper(root.right,minNode.data);
                return root;
            }
        }
    }
    public void remove(int data) {
        //Implement the remove() function
        root = removeHelper(root,data);
    }
    private void printTree(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        String toBePrinted = root.data + ":";
        if(root.left != null){
            toBePrinted += "L:" + root.left.data + ",";
        }
        if(root.right != null){
            toBePrinted += "R:" + root.right.data;
        }
        System.out.println(toBePrinted);
        printTree(root.left);
        printTree(root.right);
    }
    public void printTree() {
        //Implement the printTree() function
        printTree(root);
    }
    private boolean searchHelper(BinaryTreeNode<Integer> root, int data){
        if(root == null){
            return false;
        }
        if(root.data == data){
            return true;
        }
        else if(data < root.data){
            return searchHelper(root.left,data);
        }
        else{
            return searchHelper(root.right,data);
        }

    }
    public boolean search(int data) {
        //Implement the search() function
        return searchHelper(root,data);
    }


}
class Main22 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BinarySearchTree bst = new BinarySearchTree();
        int choice, input;
        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            choice = Integer.parseInt(st.nextToken());
            switch (choice) {
                case 1:
                    input = Integer.parseInt(st.nextToken());
                    bst.insert(input);
                    break;
                case 2:
                    input = Integer.parseInt(st.nextToken());
                    bst.remove(input);
                    break;
                case 3:
                    input = Integer.parseInt(st.nextToken());
                    System.out.println(bst.search(input));
                    break;
                default:
                    bst.printTree();
                    break;
            }

        }
    }
}