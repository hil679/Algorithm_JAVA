package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14495 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine() );
        int n = Integer.valueOf(st.nextToken());
        long[] dp = new long[n+1];
        if (n == 1) {
            dp[1] = 1;
        } else if (n == 2) {
            dp[1] = dp[2] = 1;
        } else {
            dp[1] = dp[2] = dp[3] = 1;

            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i-1]+dp[i-3];
            }
        }
        System.out.println(dp[n]);
    }
}
