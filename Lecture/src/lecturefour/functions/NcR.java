package lecturefour.functions;

import java.util.Scanner;

public class NcR {
    public static int combination(int n){
        int res = 1;
        for(int i = 1;i <= n;i++){
            res = res * i;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int r = s.nextInt();
        int  num = combination(n);
        int den1 = combination(r);
        int den2 = combination(n-r);
        int result = num/(den1*den2);
        System.out.println(result);
    }
}
