package recurssion;
import java.util.Scanner;
public class TowerOfHanoi2 {
    public static void towerOfHanoi(int disks, char a, char b, char c) {
        // Write your code here
        if(disks == 0){
            return;
        }
        if(disks == 1){
            System.out.println(a + " " + c);
            return;
        }
        towerOfHanoi(disks-1,a,c,b);
        System.out.println(a + " " + c);
        towerOfHanoi(disks-1,b,a,c);
    }
}



 class runner22 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        TowerOfHanoi2.towerOfHanoi(n, 'a', 'b', 'c');
    }
}
