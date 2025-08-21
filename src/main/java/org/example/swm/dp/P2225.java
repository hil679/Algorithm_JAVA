package org.example.swm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int[][] dp = new int[n+1][m+1];
        //4 3
        /*
        dp[1][1] = 1
        dp[1][2] = 1+0, 0+1
        dp[1][3] = 1+0+0, 0+1+0, 0+0+1
        dp[2][1] = 2
        dp[2][2] = 2+0, 0+2, 1+1
        dp[2][3] = 2+0+0, 0+0+2, 0+2+0, 1+1+0, 1+0+1, 0+1+1=6 //dp[2][2] + 0,
        dp[3][1] = 3
        dp[3][2] = 3+0, 0+3, 1+2, 2+1
        dp[3][3] = 3+0+0, 0+3+0, 0+0+3, 2+1+0 * 6, 1+1+1 = 10
        dp[4][1] = 4
        dp[4][2] = 4+0, 0+4, 1+3, 3+1, 2+2 = 5
        dp[4][3]= 4+0+0 * 3, 1+3+0 *6, 2+2+0 * 3, 1+1+2*3 = 15
        4 = 0 (2번 더해서 0이 되는 경우)+ 4
        4 = 1 (2번 더해서 1이 되는 경우)+ 3
        4 = 2 (2번 더해서 2이 되는 경우)+ 4
        4 = 3 (2번 더해서 3이 되는 경우)+ 1
        4 = 4 (2번 더해서 4이 되는 경우)+ 0
        dp[4][3] = dp[0][2]~dp[4][2] 합 (dp[0][2] + dp[1][2] + dp[2][2] + dp[3][2] + dp[4][2])
                 = dp[1][3] (dp[0][2] (1붙이기) + dp[1][2](0붙이기))+ dp[2][2] + dp[3][2] + dp[4][2]
                 = d[2][3] (dp[1][3] (0대신 1로 바꾸기) + dp[2][2] (0붙이기) + dp[3][2] + dp[4][2]
                 =dp[3][3] + dp[4][2]
        참고)https://hu-coding.tistory.com/28
         */
        for (int i = 1; i <=m; i++) {
            dp[1][i] = i;
        }
        for (int i = 2; i <=n; i++) {
            dp[i][1] = 1;
            for (int j = 2; j <=m; j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j])%1000000000;
            }
        }
        System.out.println(dp[n][m]);
    }
}
