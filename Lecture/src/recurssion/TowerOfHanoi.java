package recurssion;

public class TowerOfHanoi {
    public static void moveDisk(int n, char a, char c, char b) {
        if (n == 1) {
            System.out.println("1" + " disk from " + a + " to " + c);
            return;
        }
        moveDisk(n - 1, a, b, c);
        System.out.println(n + " disk from " + a + " to " + c);
        moveDisk(n - 1,b, c, a);



    }


    public static void main(String[] args) {
        int n = 4;

        moveDisk(n,'a','c','b');
    }
}
