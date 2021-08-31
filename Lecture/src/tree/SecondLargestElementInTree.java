package tree;
import java.util.Scanner;
public class SecondLargestElementInTree {
//    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
//        Helper<Integer> ans = new Helper<>();
//        ans = findSecondLargestHelper(root);
//        return ans.secondMax;
//    }
//
//    public static Helper<Integer> findSecondLargestHelper(TreeNode<Integer> root){
//        Helper<Integer> node = new Helper<>();
//        node.max = root;
//        node.secondMax = null;
//
//        for(int i = 0;i < root.children.size();i++){
//            Helper<Integer> childNode = findSecondLargestHelper(root.children.get(i));
//            TreeNode<Integer> discard = null;
//            if(childNode.max.data > node.max.data){
//                discard = node.max;
//                node.max.data = childNode.max.data;
//            }
//            if(node.secondMax == null || node.secondMax.data < discard.data){
//                if(discard.data < childNode.secondMax){
//                    node.secondMax.data = childNode.secondMax.data;
//                }
//                else{
//                    node.secondMax.data = discard.data;
//                }
//            }
//        }
//        return node;
//    }
//}
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
        TreeNode<Integer> ans = SecondLargestElementInTree.findSecondLargest(root);
        if(ans == null){
            System.out.println(Integer.MIN_VALUE);
        }else{
            System.out.println(ans.data);
        }
    }

}

