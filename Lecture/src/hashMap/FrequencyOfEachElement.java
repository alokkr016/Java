package hashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class FrequencyOfEachElement {

    public static void frequencyOfElement(int []arr) {
//        ArrayList<Integer> output = new ArrayList<Integer>();
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!hash.containsKey(arr[i])) {
                hash.put(arr[i], 1);
            } else {
                hash.put(arr[i], hash.get(arr[i]) + 1);
            }
        }

        for(int x : hash.keySet()){
            System.out.println(x + "    " + hash.get(x));
        }

    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 7, 9, 2, 1, 10, 7};
        frequencyOfElement(arr);
    }
}
