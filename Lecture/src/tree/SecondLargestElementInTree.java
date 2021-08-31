package tree;
import java.util.Scanner;
public class SecondLargestElementInTree {
    public static TreeNode<Integer> findSecondLargest2(TreeNode<Integer> root){
        Helper<Integer> ans;
        ans = findSecondLargestHelper(root);
        return ans.secondMax;
    }

    public static Helper<Integer> findSecondLargestHelper(TreeNode<Integer> root){
        Helper<Integer> ans;
        if(root == null){
            ans = new Helper<>();
            ans.max = null;
            ans.secondMax = null;
        }
        ans = new Helper<>();
        ans.max = root;
        ans.secondMax = null;

        for(int i = 0;i < root.children.size();i++){
            Helper<Integer> childNode = findSecondLargestHelper(root.children.get(i));
            if(childNode.max.data > ans.max.data){
                if(childNode.secondMax == null || childNode.secondMax.data < ans.max.data){
                    ans.secondMax = ans.max;
                    ans.max = childNode.max;
                }
                else{
                    ans.max = childNode.max;
                    ans.secondMax = childNode.secondMax;
                }
            }
            else if(childNode.max.data.equals(ans.max.data) && childNode.secondMax !=  null){
                if(ans.secondMax == null || ans.secondMax.data < childNode.secondMax.data){
                ans.secondMax = childNode.secondMax;
            }
            else if(!ans.max.data.equals(childNode.max.data) && (childNode.secondMax == null || ans.secondMax.data < childNode.max.data)){
                ans.secondMax = childNode.max;
                }
            }
        }
        return ans;
    }

public static void change(TreeNode<Integer> root,int m) {

    if(root==null) {
        return ;
    }
    if(root.data == m) {
        root.data = Integer.MIN_VALUE;
    }
    for(int i=0;i<root.children.size();i++) {
        change(root.children.get(i), m);
    }

}

    public static TreeNode<Integer> largest(TreeNode<Integer> rootNode ) {
        if(rootNode==null) {
            return rootNode;
        }
        int max =rootNode.data;
        TreeNode<Integer> maxNode = rootNode;
        for(int i=0;i<rootNode.children.size();i++) {
            TreeNode<Integer> large = largest(rootNode.children.get(i));
            if(large == null){
                continue;
            }
            if(max <large.data) {
                max = large.data;
                maxNode = large;
            }
        }
        return maxNode;
    }

    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> rootNode) {
        if(rootNode==null) {
            return null;
        }
        int largest = largest(rootNode).data;

        change(rootNode, largest);

        return largest(rootNode);
    }
}

class Helper<T>{
    TreeNode<Integer> max;
    TreeNode<Integer> secondMax;
}

 class Main12 {

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
        TreeNode<Integer> ans = SecondLargestElementInTree.findSecondLargest2(root);
        if(ans == null){
            System.out.println(Integer.MIN_VALUE);
        }else{
            System.out.println(ans.data);
        }
    }

}

