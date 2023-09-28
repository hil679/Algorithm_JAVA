package org.example.recursive;

import java.util.Scanner;

public class Problem27433 {
    public static void main(String[] args){
        Long answer = 1L;
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        answer *= factorial(input);
        System.out.println(answer);
    }

    public static long factorial(int n){
        if(n <= 1){
            return 1;
        }

        return n * factorial(n -1);
    }
}
