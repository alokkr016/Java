public class MyPower {
    public static double power(int num,int exp){
        if (exp == 0){
            return 1;
        }
        return num * power(num,exp - 1);
    }

    public static void main(String[] args) {
        System.out.println(power(8,2));
    }
}
