package binaryTree;

public class BinaryTreeUse {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(4);
        root.left = node1;
        root.right = node2;

    }
}
