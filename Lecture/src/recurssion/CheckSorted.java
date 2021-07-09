package recurssion;

public class CheckSorted {
    public static boolean checkSorted(int []arr) {
        if (arr.length <= 1){
            return true;
        }


        int[] smallArray = new int[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            smallArray[i - 1] = arr[i];
        }

        boolean check = checkSorted(smallArray);
        if(check == false){
            return false;
        }
        if(arr[0] <= arr[1]){
            return true;
        }
        else{
            return false;
        }

    }
    public static boolean checkSorted2(int []arr) {
    return sorted(arr,0);
    }
    private static boolean sorted(int []arr, int startIndex){
        if(startIndex >= arr.length - 1) {
        return true;
        }
            if (arr[startIndex] > arr[startIndex + 1]) {

                return false;
            }

        boolean check = sorted(arr,startIndex + 1);
        return check;

    }


    public static void main(String[] args) {
        int[]arr = {5, 8, 7};
        boolean check;
        check = checkSorted2(arr);
        if (check == true){
            System.out.println("The array is sorted");
        }
        else{
            System.out.println("The array is not sorted");
        }
    }
}
