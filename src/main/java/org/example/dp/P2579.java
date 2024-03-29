package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int[] stairs = new int[n + 1];
        int[] dp = new int[n + 1];
        String value;
        int i = 1;
//        while((value = br.readLine()) != null){
//            stairs[i] = Integer.valueOf(value);
//        }
        for (i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = stairs[1];

        // n 이 1이 입력될 수도 있기 때문에 예외처리를 해줄 필요가 있다. -> arr 크기 때문
        if (n >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }

        for (i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] , dp[i - 3] + stairs[i - 1]) + stairs[i];
        }

        System.out.println(dp[n]);
    }
}
