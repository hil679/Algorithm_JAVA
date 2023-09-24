package org.example.recursive;

import java.util.Scanner;

public class Problem10870 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        System.out.println(fibonacci(input));

    }

    public static Long fibonacci(int input){
        int start = 0;
        if(input == 0){ //0번부터 시작(n0 = 0, n1 != 0)
            return 0L;
        }else if (input == 1){
            return 1L;
        } else{
            return fibonacci(input -1) + fibonacci(input -2);
        }
    }
}
