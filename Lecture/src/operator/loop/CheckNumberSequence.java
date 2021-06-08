package operator.loop;

import java.util.Scanner;

public class CheckNumberSequence {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int prev = s.nextInt();
        int i = 0;
        boolean isDec = true;
        while(i < n-1){
            int next = s.nextInt();
            if(next == prev){
                System.out.print("false");
                return;
            }
            else if(next < prev){
                if(isDec == false){
                    System.out.print("false");
                    return;
                }
                i++;
                prev = next;
                continue;
            }
            else{
                isDec = false;

                i++;

            }
        }
        System.out.print("true");
    }
}
