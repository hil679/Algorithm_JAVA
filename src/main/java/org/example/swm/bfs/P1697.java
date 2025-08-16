package org.example.swm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
1463 (DP) → 여러 경로의 최솟값을 비교해야 하므로 min() 필요.
예: 10을 만들 때
    9 → 10 (dp[9]+1)
    5 → 10 (dp[5]+1)
    … 여러 가지 경로
1697 (BFS) → 처음 방문 시 최단거리가 보장되므로 visited == 0일 때만 기록, 덮어쓸 필요 없음.
 */

public class P1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int start =  Integer.valueOf(st.nextToken());
        int end =  Integer.valueOf(st.nextToken());

        bfs(start, end);
    }
    public static void bfs(int start, int end) {
        Deque<Integer> que = new ArrayDeque<>();
        que.add(start);
        int[] visited = new int[100001];
        visited[start] = 1;
        while (!que.isEmpty()) {
            int pop = que.pop();
            if (pop == end) {
                System.out.println(visited[end] - 1);
                break;
            } else {
                if (pop-1 <= 100000 && pop -1 >= 0 && visited[pop-1] == 0) {
                    que.add(pop-1);
                    visited[pop-1] = visited[pop] + 1;
                }

                if (pop+1 <= 100000 && pop +1 >= 0 && visited[pop+1] == 0) {
                    que.add(pop+1);
                    visited[pop+1] = visited[pop] + 1;
                }

                if (pop*2 <= 100000 && pop*2 >= 0 && visited[pop*2] == 0) {
                    que.add(pop*2);
                    visited[pop*2] = visited[pop] + 1;
                }
            }

        }
    }
}
