package org.example.swm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Queue;

public class P1463 {
    public static void main(String[] args) throws IOException {
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
