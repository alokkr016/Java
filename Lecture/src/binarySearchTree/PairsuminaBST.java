package binarySearchTree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
Given a binary search tree and an integer S, find pair of nodes in the BST which sum to S. You can use extra space of the order of O(log n).
 */
public class PairsuminaBST {
    public static void printNodesSumToS(BinaryTreeNode<Integer> root, int sum) {

        ArrayList<Integer> array = toArray(root);
        int j = array.size() - 1;

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

 class Main31 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static BinaryTreeNode<Integer> takeInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        int rootData = Integer.parseInt(st.nextToken());
        if (rootData == -1) {
            return null;
        }
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        pendingNodes.enqueue(root);

        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.dequeue();
            } catch (QueueEmptyException e) {
                return null;
            }
            int leftChildData = Integer.parseInt(st.nextToken());
            if (leftChildData != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
                currentNode.left = leftChild;
                pendingNodes.enqueue(leftChild);
            }
            int rightChildData = Integer.parseInt(st.nextToken());
            if (rightChildData != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
                currentNode.right = rightChild;
                pendingNodes.enqueue(rightChild);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BinaryTreeNode<Integer> root = takeInput();
        int s = Integer.parseInt(br.readLine());
        PairsuminaBST.printNodesSumToS(root,s);
    }

}