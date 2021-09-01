package tree;
import java.util.Scanner;

public class ReplaceNodeWithDepth {

    public static void replaceWithDepthValue(TreeNode<Integer> root){
        replaceWithDepthValueHelper(root,0);
    }

    public static void replaceWithDepthValueHelper(TreeNode<Integer> root, int depth){
        if(root == null){
            return;
        }
        if(root.children.size() == 0){
            root.data = depth;
            return;
        }
        root.data = depth;
        for(int i= 0; i < root.children.size();i++){
            replaceWithDepthValueHelper(root.children.get(i),depth + 1);
        }
    }
}

 class Main13 {

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

    public static void printTreeLevelWise(TreeNode<Integer> root){
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();
        pendingNodes.enqueue(root);
        pendingNodes.enqueue(null);
        while(!pendingNodes.isEmpty()){
            TreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.dequeue();
                if(currentNode==null){
                    System.out.println();
                    if(!pendingNodes.isEmpty()){
                        pendingNodes.enqueue(null);
                        continue;
                    }else{
                        break;
                    }
                }
                System.out.print(currentNode.data+" ");
                int numChild = currentNode.children.size();
                for(int i = 0 ; i < numChild; i++){
                    pendingNodes.enqueue(currentNode.children.get(i));
                }

            } catch (QueueEmptyException e) {
            }
        }
    }
    // Test case will have tree printed -
    public static void main(String[] args) {
        TreeNode<Integer> root =  takeInputLevelWise();
        ReplaceNodeWithDepth.replaceWithDepthValue(root);
        printTreeLevelWise(root);
    }

}