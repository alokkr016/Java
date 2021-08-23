package tree;

import java.util.Scanner;

public class TreeUse {
    public static TreeNode<Integer> takeInput(Scanner s){
        int n;
//        Scanner s = new Scanner(System.in);
        System.out.println("Enter the next node data ");
        n = s.nextInt();
        TreeNode<Integer> root = new TreeNode<>(n);
        System.out.println("Enter the children for " + n);
        int childCount = s.nextInt();
        for(int i = 0;i < childCount;i++){
            TreeNode<Integer> child = takeInput(s);
            root.children.add(child);
        }
        return root;
    }
    public static TreeNode<Integer> takeInputLevelWise(){
        Scanner s = new Scanner(System.in);
        QueueUsingLL<TreeNode<Integer>> pending = new QueueUsingLL<>();
        System.out.println("Enter the root of the tree ");
        TreeNode<Integer> root = new TreeNode<>(s.nextInt());
        pending.enqueue(root);

        while(!pending.isEmpty()){
            try {
                TreeNode<Integer> frontNode = pending.dequeue();
                System.out.println("Enter the number child for root " + frontNode.data);
                int size = s.nextInt();
                for(int i = 0;i < size;i++){
                    System.out.println("Enter the value for the child");
                    int val = s.nextInt();
                    TreeNode<Integer> child = new TreeNode<>(val);
                    frontNode.children.add(child);
                    pending.enqueue(child);
                }
            } catch (QueueEmptyException e) {
                //will not rich here
                return null;
            }


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
//        Scanner s = new Scanner(System.in);
//        TreeNode<Integer> root = takeInput(s);
        TreeNode<Integer> root = takeInputLevelWise();
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
