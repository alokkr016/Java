package binarySearchTree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
Given a binary tree and an integer S,
print all the pair of nodes whose sum equals S.
 */
public class PairSumBinaryTree {
    static void pairSum(BinaryTreeNode<Integer> root, int sum) {
        ArrayList<Integer> array = toArray(root);
        int j = array.size() - 1;
        Collections.sort(array);


        int count = array.size();
        int i = 0;

        while (count > 0) {
            if(i == j){
                break;
            }
            if (array.get(i) + array.get(j) == sum) {
                System.out.println(array.get(i) + " " + array.get(j));
                i++;
                j--;
                count -= 2;
            }
            if (array.get(i) + array.get(j) < sum) {
                i++;
                count -= 1;
            } else if (array.get(i) + array.get(j) > sum) {
                j--;
                count -= 1;
            }
        }
    }

    public static ArrayList<Integer> toArray(BinaryTreeNode<Integer> root) {
        ArrayList<Integer> result = new ArrayList<>();
        toArrayHelp(root, result);
        return result;
    }

    private static void toArrayHelp(BinaryTreeNode<Integer> root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        toArrayHelp(root.left, result);
        result.add(root.data);
        toArrayHelp(root.right, result);
    }

}

 class Runner39 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static BinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
        QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>();
        int start = 0;

        String[] nodeDatas = br.readLine().trim().split(" ");

        if (nodeDatas.length == 1) {
            return null;
        }

        int rootData = Integer.parseInt(nodeDatas[start]);
        start += 1;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        pendingNodes.enqueue(root);

        while(!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.dequeue();
            } catch (QueueEmptyException e) {
                return null;
            }

            int leftChildData = Integer.parseInt(nodeDatas[start]);
            start += 1;

            if(leftChildData != -1){
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
                currentNode.left = leftChild;
                pendingNodes.enqueue(leftChild);
            }

            int rightChildData = Integer.parseInt(nodeDatas[start]);
            start += 1;

            if(rightChildData != -1){
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
                currentNode.right = rightChild;
                pendingNodes.enqueue(rightChild);
            }
        }

        return root;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BinaryTreeNode<Integer> root = takeInput();
        int sum = Integer.parseInt(br.readLine().trim());

        PairSumBinaryTree.pairSum(root, sum);

    }
}
