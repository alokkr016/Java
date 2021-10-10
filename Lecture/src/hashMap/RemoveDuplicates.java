package hashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicates {
    public static ArrayList<Integer> removeDuplicates(int []arr){
        ArrayList<Integer> output = new ArrayList<Integer>();
        HashMap<Integer, Boolean> ans = new HashMap<>();
        for(int i = 0;i < arr.length;i++){
            if(ans.containsKey(arr[i])){
                continue;
            }
            output.add(arr[i]);
            ans.put(arr[i],true);
        }
        return output;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 7, 9, 2, 1, 1000,7};
        ArrayList<Integer> output = removeDuplicates(arr);
        for(int i = 0;i < output.size(); i++){
            System.out.print(output.get(i) + " ");
        }
    }
}
