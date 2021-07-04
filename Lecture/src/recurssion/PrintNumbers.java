package recurssion;
import java.util.Scanner;

public class PrintNumbers {
    public static void print(int n){
//        if(n == 0){
//            System.out.println(0);
//        }
        if(n == 0){
            return;
        }
        print(n - 1);
        System.out.print(n+" ");

    }

}

 class Runner2 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        PrintNumbers.print(n);
    }

}