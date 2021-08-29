package tree;

import java.util.ArrayList;
import java.util.Scanner;

public class NodeHavingSumOfChildrenAndNodeIsMax {

    public static TreeNode<Integer> maxSumNode2(TreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        int sum = root.data;
        TreeNode<Integer> ans = root;
        for (int i = 0; i < root.children.size(); i++) {
            sum += root.children.get(i).data;
        }
        TreeNode<Integer> temp;
        for (int i = 0; i < root.children.size(); i++) {
            temp = maxSumNode2(root.children.get(i));
            int childsum = temp.data;
            for (int j = 0; j < temp.children.size(); j++) {
                childsum += temp.children.get(j).data;
            }
            if (childsum > sum) {
                ans = temp;
                sum = childsum;
            }
        }
        return ans;
    }

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
        // Write your code here
        Pair<Integer> ans = new Pair<>();
        ans = maxSumNodeHelper(root);
        return ans.root;
    }
    public static Pair<Integer> maxSumNodeHelper(TreeNode<Integer> root){
        if(root == null){
            Pair<Integer> t = new Pair();
            t.root = null;
            t.sum = Integer.MIN_VALUE;
            return t;
        }
        Pair<Integer> ans = new Pair<>();
        ans.root = root;
        ans.sum = root.data;

        for(int i = 0;i < root.children.size();i++){
            ans.sum += root.children.get(i).data;
        }
        Pair<Integer> temp = new Pair<>();
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

class Pair<T> {
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
        TreeNode<Integer> ans = NodeHavingSumOfChildrenAndNodeIsMax.maxSumNode2(root);
        if(ans == null){
            System.out.println(Integer.MIN_VALUE);
        }else{
            System.out.println(ans.data);
        }

    }

}
