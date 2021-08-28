package tree;

import java.util.ArrayList;
import java.util.Scanner;
public class CountLeafNodes {

    public static int countLeafNodes(TreeNode<Integer> root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        if(root.children.size() == 0){
            return 1;
        }
        int count = 0;
        for(int i = 0;i < root.children.size();i++){
            count += countLeafNodes(root.children.get(i));
        }
        return count;
    }

}


 class Main5 {



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
        TreeNode<Integer> root =  takeInputLevelWise();
        System.out.println(CountLeafNodes.countLeafNodes(root));
    }

}
