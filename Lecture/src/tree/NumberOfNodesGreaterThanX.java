package tree;
import java.util.Scanner;
public class NumberOfNodesGreaterThanX {
    public static int numNodeGreater(TreeNode<Integer> root,int x){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int count = 0;
        if(root.data > x){
            count++;
        }
        for(int i = 0; i < root.children.size();i++){
            count += numNodeGreater(root.children.get(i), x);

        }
        return count;

    }

}



 class Main3 {



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
        int x = s.nextInt();
        TreeNode<Integer> root =  takeInputLevelWise();
        System.out.println(NumberOfNodesGreaterThanX.numNodeGreater(root, x));
    }

}
