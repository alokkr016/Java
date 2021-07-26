package temp;

public class Mypattern {
    public static void main(String[] args) {
        int n = 4;
        int size = (n * 2) - 1;
        for(int i = 0; i < n+1;i++){
            for(int j = 0;j < i;j++){
                System.out.print(n - j);
            }
            System.out.println();
        }
//        for(int i = size; i >= size - n;i--){
//            for(int j = 1;j > )
//        }


    }
}
