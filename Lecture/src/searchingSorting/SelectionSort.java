package searchingSorting;

public class SelectionSort {
    public static int minimum(int []arr,int i){
        int index = i;
        for(int j = i + 1;j < arr.length;j++){
            if(arr[j] < arr[index]){     //{5,10,9,2,1,12}
                index = j;
            }
        }
        return index;
    }
    public static void selectionSort(int []arr){
        for (int i = 0;i < arr.length - 1;i++){
            int minIndex = minimum(arr,i);    //{5,10,9,2,1,12}
           // System.out.println(minIndex);
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

        }

    }
    public static void main(String[]args){
        int []arr = {5,10,0,2,3,2,1,12};
        selectionSort(arr);
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
