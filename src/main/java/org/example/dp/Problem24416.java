package org.example.dp;

import java.util.Scanner;

public class Problem24416 {
    private static int recursiveFiboCount =  0;
    private static int dpFiboCount =  0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[100000];

        recursiveFibo(n);
        dpFibo(n, arr);
        System.out.println(recursiveFiboCount + " " + dpFiboCount);
    }

    private static int recursiveFibo(int n){
        if(n==0) return 1;
        else if(n==1){
            recursiveFiboCount++;
            return 1;
        }
        else
            return recursiveFibo(n -1) + recursiveFibo(n -2);
    }
    private static int dpFibo(int n, int[] arr){
        arr[1] = 1;
        arr[2] = 1;
        for(int i = 3; i <= n; i++){
            dpFiboCount++;
            arr[i] = arr[i-1] + arr[i -2];
        }
        return arr[n];

    }
}
