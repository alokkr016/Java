package hashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
public class PairsWithDifferenceK {
    public static int getPairsWithDifferenceK(int arr[], int k) {
        //Write your code here
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i = 0;i < arr.length;i++){
            if(h.containsKey(arr[i])) {
                h.put(arr[i], h.get(arr[i]) + 1);
            }
            else{
                h.put(arr[i],1);
            }
        }
        int count = 0;
        //array with same element case handled
        if(h.size() == 1){
            int key = arr[0];
            count = (key*(key - 1))/2;
            return count;
        }

        for(int i = 0;i < arr.length;i++){
            if(h.get(arr[i]) != 0){
                int key = k + arr[i];
                if(h.containsKey(key)){
                    count += h.get(arr[i]) * h.get(key);

                }
                int key2 = -(k - arr[i]);
                if(h.containsKey(key2)){
                    count += h.get(arr[i]) * h.get(key2);

                }
                h.put(arr[i],0);
            }
        }

        return count;
    }
}


 class Main3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int k = Integer.parseInt(br.readLine());
        System.out.println(PairsWithDifferenceK.getPairsWithDifferenceK(arr, k));
    }

}