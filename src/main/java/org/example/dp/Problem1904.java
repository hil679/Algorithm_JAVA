package org.example.dp;
import java.util.Scanner;
public class Problem1904 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[1000001];

        System.out.println(dpFibo(n, arr));
    }

    private static long dpFibo(int n, long[] arr){
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i <= n; i++){
            arr[i] = (arr[i-1] + arr[i -2]) % 15746;
        }
        return arr[n];

    }
}
