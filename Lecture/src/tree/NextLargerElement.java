package tree;

import java.util.ArrayList;
import java.util.Scanner;

public class NextLargerElement {
    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n) {
        if (root == null) {
            return null;
        }
        TreeNode<Integer> ans = null;
        if (root.data > n) {
            ans = root;
        }
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> temp = findNextLargerNode(root.children.get(i), n);
            if (temp != null) {
                if (ans == null || ans.data > temp.data) {
                    ans = temp;
                }
            }

        }
        return ans;
    }

    public static TreeNode<Integer> findNextLargerNode2(TreeNode<Integer> root, int n){

        if(root==null) {
            return root;
        }
        int min=Integer.MAX_VALUE;
        TreeNode<Integer> minNode = null;
        for(int i=0;i<root.children.size();i++) {

            TreeNode<Integer> maxNode = findNextLargerNode(root.children.get(i), n);
            if(maxNode==null) {
                continue;
            }
            int max = maxNode.data;
            if(min>max) {
                min = max;
                minNode = maxNode;
            }
        }
        if( root.data > n && root.data < min ) {
            return root;
        }
        return minNode;

    }
}



 class Main10 {


     static Scanner s = new Scanner(System.in);

     public static TreeNode<Integer> takeInputLevelWise() {
         QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();  // Queue of node that are entered themselves but their children aren't added yet
         int rootData = s.nextInt();
         TreeNode<Integer> root = new TreeNode<Integer>(rootData);
         pendingNodes.enqueue(root);
         while (!pendingNodes.isEmpty()) {
             TreeNode<Integer> currentNode;
             try {
                 currentNode = pendingNodes.dequeue();
                 int numChild = s.nextInt();
                 for (int i = 0; i < numChild; i++) {
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
        int n = s.nextInt();
        TreeNode<Integer> root =  takeInputLevelWise();

        TreeNode<Integer> ans = NextLargerElement.findNextLargerNode(root, n);
        if(ans == null){
            System.out.println(Integer.MIN_VALUE);
        }else{
            System.out.println(ans.data);
        }

    }

}
