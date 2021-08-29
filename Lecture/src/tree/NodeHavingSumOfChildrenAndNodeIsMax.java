package tree;

import java.util.ArrayList;
import java.util.Scanner;

public class NodeHavingSumOfChildrenAndNodeIsMax {
    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
        // Write your code here
        Pair ans = new Pair();
        ans = maxSumNodeHelper(root);
        return ans.root;
    }
    public static Pair maxSumNodeHelper(TreeNode<Integer> root){
        Pair ans = new Pair();
        ans.root = root;
        ans.sum = root.data;

        for(int i = 0;i < root.children.size();i++){
            ans.sum += root.children.get(i).data;
        }
        Pair temp = new Pair();
        for(int i = 0;i < root.children.size();i++){
            temp = maxSumNodeHelper(root.children.get(i));
            if(temp.sum > ans.sum){
                ans.sum = temp.sum;
                ans.root = temp.root;
            }
        }

        return ans;
    }

}

class Pair {
    TreeNode<Integer> root;
    int sum;
 }


 class Main8 {

    static Scanner s = new Scanner(System.in);

    public static TreeNode<Integer> takeInputLevelWise(){
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();  // Queue of node that are entered themselves but their children aren't added yet
//		System.out.println("Enter root Data");
        int rootData = s.nextInt();
        TreeNode<Integer> root = new TreeNode<Integer>(rootData);
        pendingNodes.enqueue(root);
        while(!pendingNodes.isEmpty()){
            TreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.dequeue();
//				System.out.println("Enter number of children of "+currentNode.data);
                int numChild = s.nextInt();
                for(int i = 0 ; i < numChild; i++){
//					System.out.println("Enter "+ i + "th child of " + currentNode.data);
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
        TreeNode<Integer> ans = NodeHavingSumOfChildrenAndNodeIsMax.maxSumNode(root);
        if(ans == null){
            System.out.println(Integer.MIN_VALUE);
        }else{
            System.out.println(ans.data);
        }

    }

}
