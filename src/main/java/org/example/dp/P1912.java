package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Math.max;

public class P1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(bf.readLine());
        int nums[] = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int dp[] = new int [n];
        int neg = 0;
        int pos = 0;
        dp[0] = nums[0];
//        dp[2] = max(dp[1] + nums[2], nums[2]);
//        dp[3] = nums[3], dp[2] + nums[3]
        for (int i = 1; i <n; i++) {
            dp[i] = max(nums[i], dp[i-1]+nums[i]);
//            System.out.println(dp[i]);

        }
        System.out.println(Arrays.stream(dp).max().getAsInt());



    }
}
