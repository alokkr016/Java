package temp;

public class PrePostIncrement {
    public static void main(String[] args) {
        int []a = {1, 2 , 3, 4, 5};
        int i,j,m;
        i = ++a[1];
        System.out.println(i);
        j = a[1]++;
        System.out.println(j);
        m = a[i++];
        System.out.println(i + " " + j + " " + m);
    }
}
