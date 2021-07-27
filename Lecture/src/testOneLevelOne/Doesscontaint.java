package testOneLevelOne;

import java.util.Scanner;
public class Doesscontaint {
    public static boolean checkSequence(String a, String b) {
        if(b.length() == 0){
            return true;
        }
        if(a.length() == 0){
            return false;
        }
        if(a.charAt(0) == b.charAt(0)){
            a = a.substring(1);
            b = b.substring(1);
        }
        else{
            a = a.substring(1);
        }
        return checkSequence(a,b);

    }

}



 class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String large = s.nextLine();
        String small = s.nextLine();

        System.out.println(Doesscontaint.checkSequence(large, small));
    }
}