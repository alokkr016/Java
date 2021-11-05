package binarySearchTree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BSTClass {
    private BinaryTreeNode<Integer> root;

    private boolean searchHelper(BinaryTreeNode<Integer> root, int data){
        if(root == null){
            return false;
        }
        if(root.data == data){
            return true;
        }else if(data < root.data){
            return searchHelper(root.left,data);
        }
        else{
            return searchHelper(root.right,data);
        }
    }
    public boolean search(int data) {
        return searchHelper(root, data);
    }

    public void printTreeHelper(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        String s = root.data + ":";
        if(root.left != null){
            s += "L:" + root.left.data + ",";
        }
        if(root.right != null){
            s +=  "R:" + root.right.data;
        }
        System.out.println(s);
        printTreeHelper(root.left);
        printTreeHelper(root.right);
    }
    public void printTree(){
        printTreeHelper(root);
    }

    public BinaryTreeNode<Integer> removeHelper(BinaryTreeNode<Integer> root,int data){
        if(root == null){
            return root;
        }

        if(data < root.data){
            root.left = removeHelper(root.left,data);
            return root;
        }else if(data > root.data){
            root.right = removeHelper(root.right,data);
            return root;
        }
        else{
            if (root.left == null && root.right == null && root.data == data) {
                return null;
            } else if (root.left != null && root.right == null && root.data == data) {
                return root.left;
            } else if (root.left == null && root.right != null && root.data == data) {
                return root.right;
            } else {
                BinaryTreeNode<Integer> minimum = root.right;
                while(minimum.left != null){
                    minimum = minimum.left;
                }
                root.data = minimum.data;
                root.right = removeHelper(root.right, minimum.data);
                return root;
            }
        }

    }
    public void remove(int data) {
        root = removeHelper(root,data);
    }
    public BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root, int data) {
        if(root == null){
            BinaryTreeNode<Integer> node = new BinaryTreeNode<>(data);
            return node;
        }

        if(data < root.data){
            root.left = insertHelper(root.left,data);
            return root;
        }
        else{
            root.right = insertHelper(root.right,data);
            return root;
        }
    }
    public void insert(int data) {
        root = insertHelper(root,data);
    }
}

 class Main101 {

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