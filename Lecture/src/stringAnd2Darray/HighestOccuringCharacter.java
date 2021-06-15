package stringAnd2Darray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class HighestOccuringCharacter {
    public static char highestOccuringChar(String str) {
        //Your code goes here
        int arr[] = new int[256];
        for (int i = 0;i < str.length();i++){
            int val = str.charAt(i);
            arr[val] += 1;

        }
        int largest = 0;
        int index = 0;
        for (int i = 0;i < arr.length;i++){
            if(arr[i] > largest){
                largest = arr[i];
                index = i;
            }
        }
        return (char)index;
    }
}




class Runner14 {

    static BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

    public static void main (String [] args) throws NumberFormatException, IOException {
        String str = br.readLine ();
        if (str != null) {
            str = str.trim ();
        } else {
            str = "";
        }

        char ans = HighestOccuringCharacter.highestOccuringChar(str);

        System.out.println(ans);

    }
}