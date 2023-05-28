package javastream;

import java.util.List;
import java.util.stream.Collectors;

public class CollectUse {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 36, 7, 23, 5, 32, 45, 6, 8, 63);
        List<Integer> doubleList = doubleList(list);
        System.out.println(doubleList);
    }

    private static List<Integer> doubleList(List<Integer> list) {
//        return list.stream().map(e -> e * e).toList();
        return list.stream().map(e -> e * e).collect(Collectors.toList());
    }
}
