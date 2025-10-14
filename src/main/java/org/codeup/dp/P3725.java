package org.codeup.dp;

import java.util.*;
import java.io.*;
import java.lang.Math;

public class P3725 {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int h = Integer.valueOf(br.readLine());
        int n;
        if (h < 3) n = 3;
        else n = h;
        long dp[] = new long [n+1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 3;
        // dp[4] = 5; dp[3]*2 + dp[1] * 2^4, dp[2] + dp[2] * 2^2
        // dp[5] = dp[4] + dp[1] * 2^4, dp[3] + dp[2]*2^3, dp[2] + dp[3] * 2^2
        // dp[6] = dp[5] + dp[1] * 2^5, dp[4] + dp[2]*2^4 = 21, dp[3] + dp[3]* 2^3 = 27
        for (int i = 4; i <= h; i++) {
            dp[i] = dp[i-2] + dp[2]* (long)(Math.pow(2, i-2));
        }
        System.out.println(dp[h]);
    }
}
