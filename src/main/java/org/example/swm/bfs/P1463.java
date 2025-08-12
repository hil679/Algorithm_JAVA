package org.example.swm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Queue;

import static java.lang.Math.min;

public class P1463 {
    //dp
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(bf.readLine());
        int dp[] = new int [n+1];
        for (int i=2; i<=n;i++) {
            dp[i] = dp[i-1] + 1;
            if (i % 2 == 0) {
                dp[i] = min(dp[i], dp[i/2]+1);
            }
            if (i%3 == 0) {
                dp[i] = min(dp[i], dp[i/3]+1);
            }
        }
        System.out.println(dp[n]);
    }
    public static void main_bfs(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(bf.readLine());
        Deque<int[]> q = new ArrayDeque<>();
        int[] first = {n, 0};
        q.add(first);
        int answer = bfs(q);
        System.out.println(answer);
    }
    public static int bfs(Deque<int[]> q) {
        int answer = 0;
        while (!q.isEmpty()) {
            int[] pop = q.pop();
            if (pop[0] == 1) {
                answer = pop[1];
                break;
            }

            if (pop[0] % 3 == 0) {
                int[] newNum = {pop[0] / 3, pop[1]+1};
                q.add(newNum);
            }
            if (pop[0] % 2 == 0) {
                int[] newNum = {pop[0] / 2, pop[1]+1};
                q.add(newNum);
            }
            if (pop[0] - 1 > 1) {
                int[] newNum = {pop[0] -1, pop[1]+1};
                q.add(newNum);
            }
        }
        return answer;
    }
}
