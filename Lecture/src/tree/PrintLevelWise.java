package tree;

import java.util.Scanner;

public class PrintLevelWise {

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

}
class Main {



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
        PrintLevelWise.printLevelWise(root);
    }

}
