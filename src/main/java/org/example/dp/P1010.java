package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(bf.readLine());
        /*
        M Combination N
        M!/(M-N)!*N!
        nCr= nC(r-1) +(n-1)C(r-1)
         */
        for (int i = 0; i < n; i++) {
            String s[] = bf.readLine().split(" ");
            int r = Integer.valueOf(s[1]);
            int c = Integer.valueOf(s[0]);
            int dp[][] = new int[r+1][r+1];

            for (int j = 1; j <=r; j++) {
                for (int k = 0; k <= j; k++) {
                    if (j == k || k == 0) {
                        dp[j][k] = 1;
                        continue;
                    }
                    dp[j][k] = dp[j-1][k] + dp[j-1][k-1];
//                    System.out.println(j + " " + k + " " + dp[j][k]);
                }
            }
            System.out.println(dp[r][c]);
        }


    }
}
