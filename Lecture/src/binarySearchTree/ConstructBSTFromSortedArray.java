package binarySearchTree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ConstructBSTFromSortedArray {
    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
        return sortedArrayToBST(arr,0,n-1);
    }
    public static BinaryTreeNode<Integer> sortedArrayToBST(int []arr, int sI, int eI){
        if(sI > eI){
            return null;
        }

//        int middleIndex = sI + (eI - sI) / 2;
        int middleIndex = (sI + eI) / 2;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(arr[middleIndex]);
        root.left = sortedArrayToBST(arr,sI,middleIndex - 1);
        root.right = sortedArrayToBST(arr,middleIndex + 1,eI);

        return root;
    }
}
class Main12 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    private static void preOrder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());
        int arr[] = new int[len];
        if(len>0)
        {
            st = new StringTokenizer(br.readLine());
        }
        for(int i=0;i<len;i++)
        {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        BinaryTreeNode<Integer> ans = ConstructBSTFromSortedArray.SortedArrayToBST(arr, len);
        preOrder(ans);
    }

}
