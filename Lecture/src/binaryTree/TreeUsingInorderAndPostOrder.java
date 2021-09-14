package binaryTree;

public class TreeUsingInorderAndPostOrder {
    public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
       return buildTree(postOrder,inOrder,0,postOrder.length - 1,0,inOrder.length - 1);
    }
    public static BinaryTreeNode<Integer> buildTree(int[] postOrder,int[] inOrder,int postSi,int postEi,int inSi,int inEi){
        if(postSi > postEi || inSi > inEi) {
            return null;
        }
        int temp = postOrder[postEi];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(temp);

        int j = 0;
        for(int i = inSi;i <= inEi;i++){
            if(temp == inOrder[i]){
                j = i;
                break;
            }
        }

        int eiInleft = j - 1;
        int siInleft = inSi;

        int leftSubTreeLength = eiInleft - siInleft;

        int siProLeft = postSi;
        int eiProLeft = postSi + leftSubTreeLength;
        int siProRight = postSi + leftSubTreeLength + 1;
        int eiProRight = postEi - 1;
        int siInRight = j + 1;
        int eiInRight = inEi;

        root.left = buildTree(postOrder,inOrder,siProLeft,eiProLeft,siInleft,eiInleft);
        root.right = buildTree(postOrder,inOrder,siProRight,eiProRight,siInRight,eiInRight);

        return root;
    }

}

class Main10{
    public static void main(String[] args) {
        int []preOrder = {4,5,2,6,7,3,1};
        int []inOrder = {4,2,5,1,6,3,7};
        Runner11.printLevelWise(TreeUsingInorderAndPostOrder.buildTree(preOrder,inOrder));
    }
}