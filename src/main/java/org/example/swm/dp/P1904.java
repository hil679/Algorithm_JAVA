package org.example.swm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1 - 1 1
2- 2 11 00
3 - 111, 100, 001
4 - dp[3] +(1붙임), dp[2] +(00붙임)
 */
public class P1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(bf.readLine());
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }
        System.out.println(dp[n]);
    }
}
