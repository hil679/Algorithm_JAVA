package org.example.swm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(bf.readLine());
        int[][] triangle = new int[n+1][n+1];

        triangle[1][1] = Integer.valueOf(bf.readLine());
        for (int i = 2; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= i; j++) {
                if (j == 1) {
                    triangle[i][j] = triangle[i-1][j] + Integer.valueOf(st.nextToken());
                }else if (j == i) {
                    triangle[i][j] = triangle[i-1][j-1] + Integer.valueOf(st.nextToken());
                } else {
                    triangle[i][j] = Math.max(triangle[i-1][j-1], triangle[i-1][j]) + Integer.valueOf(st.nextToken());
                }

            }
        }
        int answer = Arrays.stream(triangle[n]).max().getAsInt();
        System.out.println(answer);
    }
}
