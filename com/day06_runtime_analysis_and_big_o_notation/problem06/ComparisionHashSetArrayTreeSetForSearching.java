package com.day06_runtime_analysis_and_big_o_notation.problem06;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
public class ComparisionHashSetArrayTreeSetForSearching {

    // Implementing the Linear Search
    public static boolean searchUsingArray(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return true;
            }
        }
        return false;
    }

    // Implementing the searching by using HashSet
    static boolean searchUsingHashSet(HashSet<Integer>st, int target){

        return st.contains(target);  // Return true if target exit in HashSet otherwise it return false
    }
    // Implementing the searching by using TreeSet
    static boolean searchUsingTreeSet(TreeSet<Integer>ts, int target){
        return ts.contains(target);
    }


    public static void main(String[] args) {
        // Creating Scanner object to read user input
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the number we want to keep: ");
        int num=sc.nextInt();

        int arr[]=new int[num];
        System.out.println("Enter the value :");
        for(int i=0;i<num;i++){
            arr[i]=sc.nextInt();
        }
        // Input the target we want to search
        int target=sc.nextInt();
        // Searching by using array

        long start=System.nanoTime();
        boolean flag1=searchUsingArray(arr,target);

        if(flag1) System.out.println("Target get founded in arrays ");
        else System.out.println("Target not founded in arrays ");
        long timeTakenByUsingArray =System.nanoTime()-start;  // Time taken to search by using Arrays whether element is present or not

        // Searching by using HashSet

        HashSet<Integer>st=new HashSet<>();
        for(int it:arr){
            st.add(it);
        }
        start=System.nanoTime();
        boolean flag2=searchUsingHashSet(st,target);
        long timeTakenByUsingHashSet =System.nanoTime()-start;  // Time taken to search by using HashSetwhether element is present or not

        // Searching by using TreeSet
        TreeSet<Integer>ts=new TreeSet<>();
        for(int it:arr){
            ts.add(it);
        }
        start=System.nanoTime();
        boolean flag3=searchUsingTreeSet(ts,target);
        long timeTakenByUsingTreeSet =System.nanoTime()-start;  // Time taken to search by using HashSetwhether element is present


        System.out.println("Time taken in a case of arrays to search the target : " + timeTakenByUsingArray + " ns");

        System.out.println("Time taken in a case of HashSet to search the target : " + timeTakenByUsingHashSet + " ns");

        System.out.println("Time taken in a case of TreeSet to search the target : " + timeTakenByUsingTreeSet + " ns");
    }

}