package recurssion;

public class CheckSorted {
    public static boolean checkSorted(int []arr){
        if (arr.length <= 1){
            return true;
        }
        int []smallArray = new int[arr.length - 1];
        for (int i = 1;i < arr.length;i++){
            smallArray[i - 1]  = arr[i];
        }
        if(arr[1] <= arr[0]){
            return true;
        }
        else{
            return false;
        }
        return checkSorted(smallArray);
    }
    public static void main(String[] args) {
        int[]arr = {5, 8, 7};
        boolean check;
        check = checkSorted(arr);
        if (check == true){
            System.out.println("The array is sorted");
        }
        else{
            System.out.println("The array is not sorted");
        }
    }
}
