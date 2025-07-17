package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Queue;

public class P1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(bf.readLine());
        if (n == 1)
            System.out.println(0);
        else if (n == 2 || n == 3)
            System.out.println(1);
        else {
            int dp[] = new int[n+1];
            dp[2] = 1;
            dp[3] = 1;
            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i-1] + 1;
                if (i % 3 == 0) {
                    dp[i] =  Math.min(dp[i], dp[i / 3] +1);
                }
                else if (i % 2 == 0) {
                    dp[i] =  Math.min(dp[i], dp[i / 2] +1);
                }

            }
            System.out.println(dp[n]);
        }
    }
}
