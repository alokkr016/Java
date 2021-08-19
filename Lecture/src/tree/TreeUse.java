package tree;

import java.util.Scanner;

public class TreeUse {
    public static TreeNode<Integer> takeInput(){
        int n;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the next node data ");
        n = s.nextInt();
        TreeNode<Integer> root = new TreeNode<>(n);
        System.out.println("Enter the children for " + n);
        int childCount = s.nextInt();
        for(int i = 0;i < childCount;i++){
            TreeNode<Integer> child = takeInput();
            root.children.add(child);
        }
        return root;
    }
    public static void print(TreeNode<Integer> root){
        String s = root.data + ": ";
        for (int i = 0;i < root.children.size();i++){
            s = s + root.children.get(i).data + ", ";
        }
        System.out.println(s);
        for (int i = 0;i < root.children.size();i++){
            print(root.children.get(i));
        }
    }
    public static void main(String[] args) {
        TreeNode<Integer> root = takeInput();
        print(root);
//        TreeNode<Integer> root = new TreeNode<>(4);
//        TreeNode<Integer> node1 = new TreeNode<>(2);
//        TreeNode<Integer> node2 = new TreeNode<>(8);
//        TreeNode<Integer> node3 = new TreeNode<>(9);
//        TreeNode<Integer> node4 = new TreeNode<>(7);
//        root.children.add(node1);
//        root.children.add(node2);
//        root.children.add(node3);
//        node2.children.add(node4);
//
//        System.out.println(root);
    }
}
