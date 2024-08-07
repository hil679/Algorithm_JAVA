package org.example.dp;

import java.util.Scanner;

public class P2169 { //need to retry
    static int N,M;
    static int[][] mars;
    static int[][] dp;
    static int[][] temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        mars = new int[N+1][M+1];
        dp = new int[N+1][M+1];
        temp = new int[2][M+2];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++){
                mars[i][j] = sc.nextInt();
            }
        }

        dp[1][1] = mars[1][1];
        // 첫 줄
        for(int j = 2; j <= M; j++) dp[1][j] = mars[1][j]+ dp[1][j-1];

dp[0][0] = 0;
        for(int i = 2; i <= N; i++) {

            temp[0][1] = dp[i-1][1] + mars[i][1]; // 가장 왼쪽은 바로 위에서 옴
            //왼쪽 / 위 비교
            for(int j = 2; j <= M; j++) {
                temp[0][j] = Math.max(temp[0][j-1], dp[i-1][j])+ mars[i][j];
            }

            // 오른쪽 / 위 비교
            temp[1][M] = dp[i-1][M] + mars[i][M]; //가장 오른쪽은 바로 위에서 옴
            for(int j = M - 1; j >= 1; j--) {
                temp[1][j] = Math.max(temp[1][j+1], dp[i-1][j]) + mars[i][j];
            }

            //왼 / 오 비1
            for(int j = 1; j <= M; j++) {
                dp[i][j] = Math.max(temp[0][j], temp[1][j]);
            }
        }
            System.out.println(dp[N][M]);

            sc.close();
    }
}
