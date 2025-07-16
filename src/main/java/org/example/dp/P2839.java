package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int dp[];
        if (n < 5) {
            dp = new int[6];
            for (int i = 1; i < n+1; i++) {
                dp[i] = -1;
            }
        } else {
            dp = new int[n+1];
            for (int i = 1; i < n+1; i++) {
                dp[i] = -1;
            }
        }
        dp[1] = -1;
        dp[2] = -1;
        dp[3] = 1;
        dp[4] = -1;
        dp[5] = 1;

        for (int i = 6; i < n+1; i++) {
            if (dp[i-3] != -1)
                dp[i] = dp[i-3] + 1;
            if (dp[i-5] != -1)
                if (dp[i] == -1)
                    dp[i] =dp[i-5] +1;
                else
                    dp[i] = dp[i] < dp[i-5] + 1 ? dp[i] : dp[i-5] +1;
        }
        System.out.println(dp[n]);

    }
}
