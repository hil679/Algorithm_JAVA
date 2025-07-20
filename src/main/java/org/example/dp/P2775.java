package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(bf.readLine());
        int dp[][] = new int[15][15];
        for (int i = 1; i <= 14; i++) {
            dp[0][i] = i;
        }
//        dp[1][1] = dp[0][1];
//        dp[1][2] = dp[1][1] + dp[0][2];
//        dp[1][3] = dp[1][2] + dp[0][3];
//        ...
//        dp[1][14] = dp[1][13] + dp[0][14];
//        dp[2][1] = dp[1][1];
//        dp[2][2] = dp[2][1] + dp[1][2];
//        dp[2][3] = dp[2][2] + dp[1][3];

        while (t > 0) {
            int k =Integer.valueOf(bf.readLine()); // floor
            int n = Integer.valueOf(bf.readLine()); // 호수
            for (int  i = 1; i <= k; i++) {
                dp[i][1] = dp[i-1][1];
                for (int j = 2; j <=n; j++) {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
            t--;
            System.out.println(dp[k][n]);
        }
    }
}
