package patterns;

public class IncrementDecrement {
    public static void main(String[] args) {
//        int a = 10;
//
//        System.out.println(a++);
//        System.out.println(a);
//        int a = 42;
//        int b = ~a; //(there is tilde sign before a)
//        System.out.print(a + " " + b);

        int x =10;
        int y = 20;
        if(x++ > 10 && ++y > 20 ){
            System.out.print("Inside if  ");
        }else{
            System.out.print("Inside else  ");
        }
        System.out.println(x +" "+y);
    }
}
