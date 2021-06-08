package array;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ArraysSum2 {
    public static int sum(int n[]) {
        int sum = 0;
        for (int i = 0; i < n.length; i++) {
            sum = sum + n[i];
        }
        return sum;
    }



}



class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

public static int[] takeInput() throws IOException {
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size];

        if (size == 0) {
        return input;
        }

        String[] strNums;
        strNums = br.readLine().trim().split("\\s");


        for (int i = 0; i < size; ++i) {
        input[i] = Integer.parseInt(strNums[i]);
        }

        return input;
        }


public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine().trim());

        while(t > 0) {
        int[] input = takeInput();
        System.out.println(ArraysSum2.sum(input));
        t -= 1;
        }
}
}