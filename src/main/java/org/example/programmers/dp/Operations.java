package org.example.programmers.dp;
import java.util.*;
class Operations {
    public int solution(String[] arr) {
        int[] num = new int[arr.length / 2 + 1];
        int[] op = new int[arr.length / 2];
        int ind1 = 0;
        int ind2 = 0;
        for (String cur : arr) {
            if (cur.equals("+"))
                op[ind2++] = 0;
            else if (cur.equals("-"))
                op[ind2++] = 1;
            else
                num[ind1++] = Integer.parseInt(cur);
        }

        int[][][] dp = new int[arr.length / 2 + 1][arr.length / 2 + 1][2];

        for (int i = 0; i < arr.length / 2 + 1; i++)
            dp[i][i][0] = dp[i][i][1] = num[i];

        for (int len = 1; len < arr.length / 2 + 1; len++) {
            for (int s = 0; s < arr.length / 2 + 1; s++) {
                if (s + len >= arr.length / 2 + 1) break;
                int e = s + len;
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for (int i = s; i < e; i++) {
                    if (op[i] == 0) {
                        max = Math.max(max, dp[s][i][1] + dp[i+1][e][1]);
                        min = Math.min(min, dp[s][i][0] + dp[i+1][e][0]);
                    }
                    else {
                        max = Math.max(max, dp[s][i][1] - dp[i+1][e][0]);
                        min = Math.min(min, dp[s][i][0] - dp[i+1][e][1]);
                    }
                }
                dp[s][e][0] = min;
                dp[s][e][1] = max;
            }
        }
        return dp[0][arr.length / 2][1];
    }
}