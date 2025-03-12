package org.example.swm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(bf.readLine());
        long[] dp = new long [101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        int prev_n = 4;
        for (int i =0; i < t; i++) {
            int n = Integer.valueOf(bf.readLine());
            if (prev_n <= n) {
                for (int j = prev_n; j <= n; j++) {
                    dp[j] = dp[j - 2] + dp[j - 3];
                }
                prev_n = n;
            }
            System.out.println(dp[n]);
        }
    }
}
