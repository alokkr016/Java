package array;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindUnique {
    public static int findUnique(int[] arr) {
        //
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }

            }
            if (count == 1) {
                temp = arr[i];
                break;
            }

        }
        return temp;

    }
}



    class Runner4 {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public static int[] takeInput() throws IOException {
            int size = Integer.parseInt(br.readLine().trim());
            int[] input = new int[size];

            if (size == 0) {
                return input;
            }

            String[] strNums;
            strNums = br.readLine().split("\\s");


            for (int i = 0; i < size; ++i) {
                input[i] = Integer.parseInt(strNums[i]);
            }

            return input;
        }


        public static void main(String[] args) throws NumberFormatException, IOException {
            int t = Integer.parseInt(br.readLine().trim());

            while (t > 0) {

                int[] input = takeInput();
                System.out.println(FindUnique.findUnique(input));

                t -= 1;
            }
        }
    }

