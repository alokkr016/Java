package binaryTree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
public class ConstructTreeFromPreorderAndInorder {
    public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
        //Your code goes here
        return buildTree(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
    }

    /*
        public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder,int preOrderStart,int preOrderEnd, int inOrderStart, int inOrderEnd){
            if(preOrderStart > preOrderEnd || inOrderStart > inOrderEnd){
                return null;
            }
            int temp = preOrder[preOrderStart];
            BinaryTreeNode<Integer> root = new BinaryTreeNode<>(temp);

            int count = 0;
            int i = inOrderStart;
            while(i <= inOrderEnd){
                if(inOrder[i] == temp){
                    count = i;
                    break;
                }
                i++;
            }

            root.left = buildTree(preOrder, inOrder,preOrderStart + 1,preOrderStart + (count),inOrderStart,count - 1);
            System.out.println("Inorder " + inOrderStart);
            System.out.println("Preorder " + preOrderStart);
            root.right = buildTree(preOrder, inOrder, preOrderStart + (count - inOrderStart) + 1,preOrderEnd,count + 1,inOrderEnd);

            return root;
        }
    }
    */
    public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder, int preOrderStart, int preOrderEnd, int inOrderStart, int inOrderEnd) {
        if (preOrderStart > preOrderEnd || inOrderStart > inOrderEnd) {
            return null;
        }
        int temp = preOrder[preOrderStart];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(temp);

        int count = 0;
        for (int i = inOrderStart; i <= inOrderEnd; i++) {
            if (temp == inOrder[i]) {
                count = i;
                break;
            }
        }

        int siPreLeft = preOrderStart + 1;
        int siInLeft = inOrderStart;
        int eiInLeft = count - 1;
        int siInRight = count + 1;
        int eiPreRight = preOrderEnd;
        int eiInRight = inOrderEnd;
        int leftSubTreeLength = eiInLeft - siInLeft + 1;
        int eiPreLeft = siPreLeft + leftSubTreeLength - 1;
        int siPreRight = eiPreLeft + 1;




        root.left = buildTree(preOrder, inOrder, siPreLeft, eiPreLeft, siInLeft, eiInLeft);
        root.right = buildTree(preOrder, inOrder, siPreRight, eiPreRight, siInRight, eiInRight);

        return root;
    }
}

    class Pair2 {
        int[] preOrder;
        int[] inOrder;

        public Pair2(int[] preOrder, int[] inOrder) {
            this.preOrder = preOrder;
            this.inOrder = inOrder;
        }

    }

class Runner11 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static Pair2 takeInput() throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine().trim());

        int pre[] = new int[n];
        int in[] = new int[n];

        String[] preOrder = br.readLine().trim().split(" ");
        String[] inOrder = br.readLine().trim().split(" ");


        for (int i = 0; i < n; i++) {
            pre[i] = Integer.parseInt(preOrder[i].trim());
            in[i] = Integer.parseInt(inOrder[i].trim());
        }

        return new Pair2(pre, in);

    }

    public static void printLevelWise(BinaryTreeNode<Integer> root) {

        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        pendingNodes.add(null);

        while(!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> frontNode = pendingNodes.poll();


            if (frontNode == null) {
                System.out.println();

                if (!pendingNodes.isEmpty()) {
                    pendingNodes.add(null);
                }

            } else {
                System.out.print(frontNode.data + " ");

                if (frontNode.left != null) {
                    pendingNodes.add(frontNode.left);
                }

                if (frontNode.right != null) {
                    pendingNodes.add(frontNode.right);
                }
            }

        }

    }
    public static void main(String[] args) throws NumberFormatException, IOException {

        Pair2 input = takeInput();

        int[] preOrder = input.preOrder;
        int[] inOrder = input.inOrder;

        BinaryTreeNode<Integer> root = ConstructTreeFromPreorderAndInorder.buildTree(preOrder, inOrder);

        printLevelWise(root);

    }
}