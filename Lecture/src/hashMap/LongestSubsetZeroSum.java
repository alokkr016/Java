package hashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
public class LongestSubsetZeroSum {
    public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
        HashMap<Integer, Integer> h = new HashMap<>();
        int max = 0;
        int l = 0;
        int last = 0;
        for (int i = 0; i < arr.length;i++){
            if(i == 0){
                h.put(i,arr[i]);
                last = arr[i];
            }
            else{
                int value = arr[i] + last;
                if(value == 0){
                    l = i + 1;
                    if(l > max){
                        max = l;
                    }

                }

                else if(h.containsKey(value)){
                    l = i - h.get(value);
                    if(l > max) {
                        max = l;
                    }
                }
                h.put(value,i);
                last = value;
            }
        }
        return max;
    }
}



class Main12 {

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
        System.out.println(LongestSubsetZeroSum.lengthOfLongestSubsetWithZeroSum(arr));
    }

}