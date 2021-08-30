package tree;

import java.util.ArrayList;
import java.util.Scanner;

public class StructurallyIdentical {
    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.data != root2.data) {
            return false;
        }
        if (root1.children.size() != root2.children.size()) {
            return false;
        }
        for (int i = 0; i < root1.children.size(); i++) {
            if (!checkIdentical(root1.children.get(i), root2.children.get(i))) {
                return false;
            }
        }
        return true;
    }


    public static boolean checkIdentical2(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        if (root1.data != root2.data || root1.children.size() != root2.children.size()) {
            return false;
        }
        QueueUsingLL<TreeNode<Integer>> pendingNodes1 = new QueueUsingLL<>();
        for (int i = 0; i < root1.children.size(); i++) {
            pendingNodes1.enqueue(root1.children.get(i));
        }
        QueueUsingLL<TreeNode<Integer>> pendingNodes2 = new QueueUsingLL<>();
        for (int i = 0; i < root2.children.size(); i++) {
            pendingNodes2.enqueue(root2.children.get(i));
        }
        boolean isIdentical = true;
        if (!pendingNodes1.isEmpty() && !pendingNodes2.isEmpty()) {
            try {
                isIdentical = checkIdentical(pendingNodes1.front(), pendingNodes2.front());
            } catch (QueueEmptyException e) {
                e.printStackTrace();
            }
        }
        return isIdentical;
    }

}

 class Main9 {



    static Scanner s = new Scanner(System.in);

    public static TreeNode<Integer> takeInputLevelWise(){
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();  // Queue of node that are entered themselves but their children aren't added yet
        int rootData = s.nextInt();
        TreeNode<Integer> root = new TreeNode<Integer>(rootData);
        pendingNodes.enqueue(root);
        while(!pendingNodes.isEmpty()){
            TreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.dequeue();
                int numChild = s.nextInt();
                for(int i = 0 ; i < numChild; i++){
                    int currentChild = s.nextInt();
                    TreeNode<Integer> childNode = new TreeNode<Integer>(currentChild);
                    pendingNodes.enqueue(childNode);
                    currentNode.children.add(childNode);
                }
            } catch (QueueEmptyException e) {
            }
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode<Integer> root1 =  takeInputLevelWise();
        TreeNode<Integer> root2 = takeInputLevelWise();
        System.out.println(StructurallyIdentical.checkIdentical(root1, root2));
    }

}
