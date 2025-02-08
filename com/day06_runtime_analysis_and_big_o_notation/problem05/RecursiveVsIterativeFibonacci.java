package com.day06_runtime_analysis_and_big_o_notation.problem05;

import java.util.*;
public class RecursiveVsIterativeFibonacci {

    // Implementing the fibonacciRecursiveMethod to find specific fibonacci number
    static int fibonacciRecursion(int n){
        // Base condition
        if(n==1||n==2) return n-1;

        return fibonacciRecursion(n-1)+fibonacciRecursion(n-2);
    }
    // Implementing the fibonacciIterativeMethod to find specific fibonacci number
    static int fibonacciIterative(int n){
        int a=0,b=1;
        if(n==1) return a;
        if(n==2) return b;
        int c=-1;
        for(int i=3;i<=n;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
    public static void main(String[] args) {

        // Creating the scanner object to read user input
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the position of fibonacci ");

        int num=sc.nextInt();  // Read user input

        long start=System.nanoTime();

        int fiboValueRecursion=fibonacciRecursion(num);

        long timeTakenByRecusionMethod=System.nanoTime()-start;  // Finding the time taken by recursive method

        start=System.nanoTime();

        // Calling method to find specific fibonacci number in series
        int fiboValueIterative=fibonacciIterative(num);

        long timeTakenByIterativeMethod=System.nanoTime()-start; // Finding the time taken by iterative method

        System.out.println("Num position in fibonacci series is "+fiboValueIterative);

        System.out.println("Time taken in a case of recursion : " + timeTakenByRecusionMethod + " ns");

        System.out.println("Time taken in a case of iterative: " + timeTakenByIterativeMethod + " ns");
    }
}