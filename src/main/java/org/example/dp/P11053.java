package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(bf.readLine());
        int nums[] = new int[n];
        String s[] = bf.readLine().split(" ");
        int dp[] = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.valueOf(s[i]);
            dp[i] = 1;
        }

        dp[0] = 1;
        for (int i =1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i]= Math.max(dp[i], dp[j] + 1);
                    //처음부터 i번째까지 돌아서 비교 숫자(1~i-1)보다 자기가 더 크면
                    // 이전거 까지 가능한 최대 갯수 + 1 <-> 아니면 그대로 갯수 유지 (이전 말고 그 전의 숫자의 가능 수열 갯수(이미 센 거)가 클 수 있어)
                    //ex)10 20 40 10 50 -> 50의 가능 갯수 구할 때
                }
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
