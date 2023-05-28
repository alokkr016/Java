package javastream;

import java.util.List;

public class UseOfReduceOnList {

    public static int sumOfTwoNumbers(int a,int b){
        return a + b;
    }


    public static void main(String[] args) {
        List<Integer> list = List.of(1, 36, 7, 23, 5, 32, 45, 6, 36, 8, 63);
        System.out.println( sumOfList(list));
        System.out.println(findMax(list));
        System.out.println(findMin(list));
        System.out.println(printSumOfSquare(list));

    }

    private static int printSumOfSquare(List<Integer> list) {
        return list.stream().map(x -> x*x).reduce(0,Integer::sum);
    }

    private static int findMin(List<Integer> list) {
        return list.stream().reduce(Integer.MAX_VALUE,(a , b) -> a < b ? a : b);
    }

    private static int findMax(List<Integer> list) {
        return list.stream().reduce(Integer.MIN_VALUE,(a , b) -> a > b ? a : b);
    }

    private static int sumOfList(List<Integer> list) {
//        return  list.stream().reduce(0,PrintSumOfList::sumOfTwoNumbers);
//        return list.stream().reduce(0,(a,b) -> a + b);
        return  list.stream().reduce(0,Integer::sum);
    }
}
