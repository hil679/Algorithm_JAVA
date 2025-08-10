package org.example.swm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1012 {
    static int [][] graph;
    static int [][] visited;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(bf.readLine());

        while (t > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            n = Integer.valueOf(st.nextToken());
            m = Integer.valueOf(st.nextToken());
            int k = Integer.valueOf(st.nextToken());
            int answer = 0;
            graph = new int[n][m];
            visited = new int[n][m];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(bf.readLine());
                int x = Integer.valueOf(st.nextToken());
                int y = Integer.valueOf(st.nextToken());
                graph[x][y] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (graph[i][j] == 1 && visited[i][j] == 0) {
                        bfs(i, j);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
            t--;
        }
    }

    public static void bfs(int x, int y) {
        visited[x][y] = 1;
        Queue<int[]> dq = new LinkedList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        dq.add(new int[]{x, y});

        while(!dq.isEmpty()) {
            int[] pop = dq.poll();
//            visited[pop[0]][pop[1]] = 1;
//            graph[pop[0]][pop[1]] = 0;
            for (int i = 0; i < 4; i++) {
                int nx = pop[0] + dx[i];
                int ny = pop[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] == 1) continue; //

                if (graph[nx][ny] == 1) {
                    dq.add(new int[]{nx, ny});
                    visited[nx][ny] = 1; // 위치 중요 -> 이미 큐에 들어간 거 다시 못 들어가게 먼저 visited 체크
                }
            }
        }
    }
}
