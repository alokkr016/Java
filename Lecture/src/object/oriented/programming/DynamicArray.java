package object.oriented.programming;

public class DynamicArray {
    int arr[];
    int nextIndex;
    public DynamicArray(){
        arr = new int[10];
        nextIndex = 0;
    }
    public int size(){
        return nextIndex;
    }
//    public int getArrayIndex(int n){
//        for (int i = 0; i < arr.length;i++){
//            if(arr[i] == i){
//                return i;
//            }
//        }
//    }
    public void add(int element){
        if(nextIndex == arr.length){
            reconstruct();
        }
        arr[nextIndex] = element;
        nextIndex++;

    }
    public void reconstruct() {
        int[] temp = arr;
        arr = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }
    public void set(int index, int element) {
        if(index > nextIndex){
            return;
        }
        else if(index < nextIndex){
            arr[index] = element;
        }
        else {
            add(element);
        }
    }
    public int get(int index){
        if(index >= nextIndex) {
            return -1;
        }
        return arr[index];
    }
    public boolean isEmpty(){
        if(size() == 0){
            return true;
        }
        else{
            return false;
        }
    }
    public int removeLast(){
        if(size() == 0){
            return -1;
        }
        int value = arr[nextIndex - 1];
        nextIndex--;
        return value;
    }
}
