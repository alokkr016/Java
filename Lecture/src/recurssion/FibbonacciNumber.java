package recurssion;

public class FibbonacciNumber {
    public static int fibo(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fibo(n - 1) + fibo (n - 2);
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println("The " + n + " Fibbonaci Number is " + fibo(n));

    }
}
