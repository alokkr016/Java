package dynamicProgramming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
Given a positive integer 'n', find and return the minimum number of steps that 'n'
has to take to get reduced to 1. You can perform any one of the following 3 steps:
1.) Subtract 1 from it. (n = n - ­1) ,
2.) If its divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
3.) If its divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).
Write brute-force recursive solution for this.
Input format :
The first and the only line of input contains an integer value, 'n'.
Output format :
Print the minimum number of steps.
Constraints :
1 <= n <= 200

Time Limit: 1 sec
Sample Input 1 :
4
Sample Output 1 :
2
Explanation of Sample Output 1 :
For n = 4
Step 1 :  n = 4 / 2  = 2
Step 2 : n = 2 / 2  =  1
Sample Input 2 :
7
Sample Output 2 :
3
Explanation of Sample Output 2 :
For n = 7
Step 1 :  n = 7 ­- 1 = 6
Step 2 : n = 6  / 3 = 2
Step 3 : n = 2 / 2 = 1
 */
public class MinStepsToOne {
    public static int countMinStepsToOne(int n) {
        //Your code goes here
        if(n == 1){
            return 0;
        }

        int subByOne = Integer.MAX_VALUE;
        int divideBy2 = Integer.MAX_VALUE;
        int divideBy3 = Integer.MAX_VALUE;

        subByOne = countMinStepsToOne(n - 1);

        if(n % 2 == 0){
            divideBy2 = countMinStepsToOne(n/2);
        }
        if(n % 3 == 0){
            divideBy3 = countMinStepsToOne(n/3);
        }

        return  1 + Math.min(subByOne,Math.min(divideBy2,divideBy3));
    }
}

//my solution

/*
public static int countMinStepsToOne(int n) {
        //Your code goes here
        return countMinStepsToOne(n, 0);
    }

    public static  int countMinStepsToOne(int n, int step){
        if(n == 1){
            return step;
        }
        if(n % 3 != 0) {
            return countMinStepsToOne(n - 1, step + 1);
        }
        else if(n % 3 == 0){
            return countMinStepsToOne(n / 3,step + 1);
        }else if(n % 2 == 0){
            return countMinStepsToOne(n / 2,step + 1);
        } else{
            return countMinStepsToOne(n - 1, step + 1);
        }
    }

}

 */


 class Runner1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine().trim());
        System.out.println(MinStepsToOne.countMinStepsToOne(n));
    }
}