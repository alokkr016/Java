package recurssion;
import java.text.DecimalFormat;
import java.util.Scanner;

public class GeometricSum {
    public static double findGeometricSum(int k){
        // Write your code here
        if(k == 0){
            return 1;
        }else {
            double sum = 1/Math.pow(2, k);
            return sum + findGeometricSum(k-1);
        }



    }
}


 class runner14 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        double ans = GeometricSum.findGeometricSum(k);
        DecimalFormat dec = new DecimalFormat("#0.00000");
        System.out.println(dec.format(ans));
    }
}
