package org.example.dp;

import java.util.Scanner;

public class Problem11050 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n + 1];
        System.out.println(binomialCoefficient(n, k, arr));

    }
    public static int binomialCoefficient(int n, int k, int[] arr){
        arr[0] = 1;
        for(int i = 1; i <= n; i++){
            arr[i] = i * arr[i - 1];
        }
        return arr[n] / (arr[k] * arr[n - k]);
    }

}
