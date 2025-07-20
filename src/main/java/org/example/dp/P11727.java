package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class P11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(bf.readLine());

        int dp[] = new int[n+1];
        dp[1] = 1;
        if (n > 1) {
            dp[2] = 3;
        }
        for (int i = 3; i <= n; i++) {
            //1 추가 필요 + 2 추가 필요 dp (2는 종류가 2개 (2-1, 2-2)니까 * 2 해줌)
            dp[i] = (dp[i-1] + dp[i-2] * 2) % 10007;
        }
        System.out.println(dp[n]);
    }
    /*
    dp[1] = 1
    dp[2] = 11, 2-1, 2-2
    dp[3] = 111, 2-1 1, 2-2 1, 1 2-1, 1 2-2
            dp[2] + dp[1]*2
    dp[4] = dp[3] + dp[2] * 2

     */
}
