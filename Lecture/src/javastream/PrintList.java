package javastream;

import java.util.List;

public class PrintList {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 36, 7, 23, 5, 32, 45, 6, 36, 8, 63);
        System.out.println("Printing each number");
        printEachNumber(list);
        System.out.println("\nPrinting even numbers");
        printEvenNumber(list);

        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");
        System.out.println("\nPrinting element containing word Spring");
        printCoursesContainingSpring(courses);

        System.out.println("Printing squares of even numbers");
        printSquareOfEvenNumbers(list);
    }

    private static void printSquareOfEvenNumbers(List<Integer> list) {
        list.stream().filter(e -> e % 2 == 0).map( e -> e * e).forEach(PrintList::print);
    }

    private static void printCoursesContainingSpring(List<String> courses) {
        courses.stream().filter(e -> e.contains("Spring")).forEach(System.out::println);
    }

    private static void printEvenNumber(List<Integer> list) {
        list.stream().filter(e -> e%2 == 0).forEach(PrintList::print);
    }

    private static void print(int num){
        System.out.print(num + " ");
    }

    private static void printEachNumber(List<Integer> list) {
        list.forEach(PrintList::print);
    }


}
