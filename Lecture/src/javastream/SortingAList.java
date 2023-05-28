package javastream;

import java.util.Comparator;
import java.util.List;

public class SortingAList {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 36, 7, 23, 5, 32, 45, 6, 36, 8, 63);
        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");

        System.out.println("Sorted List Of Integer in ascending Order");
        sortTheListInAsc(list);
        System.out.println("\nSorted List Of String in ascending Order");
        sortTheListInAsc(courses);
        System.out.println("\nSorted List Of Integer in Descending Order");
        sortTheListInDesc(list);
        System.out.println("\nSorted List Of String in Descending Order");
        sortTheListInDesc(courses);
        System.out.println("\nSorted List Of String in Ascending Order of length");
        sortAscOrderLength(courses);
        System.out.println("\nSorted List Of String in Descending Order of length");
        sortDescOrderLength(courses);

    }

    private static void sortAscOrderLength(List<String> courses) {
        courses.stream().sorted(Comparator.comparing(String::length)).distinct().forEach(SortingAList::print);
    }

    private static void sortDescOrderLength(List<String> courses) {
        courses.stream().sorted(Comparator.comparing(String::length).reversed()).distinct().forEach(SortingAList::print);
    }

    private static <T> void sortTheListInDesc(List<T> list) {
        list.stream().sorted((Comparator<? super T>) Comparator.reverseOrder()).distinct().forEach(SortingAList::print);
    }

    private static <T> void print(T element){
        System.out.print(element + " ");
    }
    private static <T> void sortTheListInAsc(List<T> list) {
        list.stream().sorted().distinct().forEach(SortingAList::print);

    }
}
