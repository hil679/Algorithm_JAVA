package org.codeup.dp.LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P4474 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int [n];
        int dp[] = new int [n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            dp[i]++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    if (dp[j] <= dp[i])
                        dp[j] = dp[i] + 1;
                }
            }
        }
        System.out.println(n-Arrays.stream(dp).max().getAsInt());
    }

}
//3 1
//7 2 (3)
//5 2 (3)
//2 1
//6 3 (3, 5)
//1 1
//4 2 (3)
//
//
//1 1
//3 2
//2 2
//9 3
//7 3
//8 4
//5 3
//10 5