package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.min;

public class P1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(bf.readLine());
        int rgb[][] = new int[n+1][4];
        for (int i = 1; i <= n; i++) {
            String price[] = bf.readLine().split(" ");
            for (int j = 1; j <= 3; j++) {
                rgb[i][j] = Integer.valueOf(price[j-1]);
            }
        }
        int dp[][] = new int[n+1][4];
        dp[1][1] = rgb[1][1];
        dp[1][2] = rgb[1][2];
        dp[1][3] = rgb[1][3];
        for (int i = 2; i <= n; i++) {
            dp[i][1] = rgb[i][1] + min(dp[i-1][2], dp[i-1][3]);
            dp[i][2] = rgb[i][2] + min(dp[i-1][1], dp[i-1][3]);
            dp[i][3] = rgb[i][3] + min(dp[i-1][2], dp[i-1][1]);
        }

        System.out.println(min(min(dp[n][1], dp[n][2]), dp[n][3]));
    }
}
