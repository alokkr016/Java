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
                    System.out.println("Enter the " + (i + 1) + "th of the " + frontNode.data);
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
    public static void printAtk(TreeNode<Integer> root,int k){
        if(k < 0){
            return;
        }
        if(k == 0){
            System.out.println(root.data);
        }
        for(int i = 0;i < root.children.size();i++){
            printAtk(root.children.get(i), k - 1);
        }
    }
    public static void printLevelWise(TreeNode<Integer> root){
        QueueUsingLL<TreeNode<Integer>> queue = new QueueUsingLL<>();
        queue.enqueue(root);
        while(!queue.isEmpty()) {
            TreeNode<Integer> temp = null;
            int count = queue.size();
            for (int j = 0; j < count; j++) {
                try {
                    temp = queue.dequeue();
                } catch (QueueEmptyException e) {

                }
                System.out.print(temp.data + " ");
                for (int i = 0; i < temp.children.size(); i++) {
                    queue.enqueue(temp.children.get(i));
                }

            }
            System.out.println();
        }
}
    public static void printPreOrder(TreeNode<Integer> root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        for(int i = 0;i < root.children.size();i++){
            printPreOrder(root.children.get(i));
        }
    }

    public static int numNode(TreeNode<Integer> root){
        // when there is no none in tree
        if(root == null){
            return 0;
        }

        int count = 1;
        for(int i = 0;i < root.children.size();i++){
            count += numNode(root.children.get(i));
        }
        return count;
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
        printPreOrder(root);
//        printAtk(root,1);
//         printLevelWise(root);
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
