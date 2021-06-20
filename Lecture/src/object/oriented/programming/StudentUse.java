package object.oriented.programming;

import java.util.Scanner;

public class StudentUse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        s1.name = "Alok";
        s1.rollNumber = 1729;
        s2.name = "Navpreet";
        s2.rollNumber = 1660;
        s3.name = "Ujjwal";
        s3.rollNumber = 1654;
        System.out.println(s1.name);
    }
}
