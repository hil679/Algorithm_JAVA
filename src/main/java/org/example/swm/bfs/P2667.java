package org.example.swm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2667 {
    static int[][] graph;
    static int[][] visited;
    static int n;
    static List<Integer> aptNums = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int villageNum = 0;
        n = Integer.valueOf(bf.readLine());
        graph = new int[n][n];
        visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = bf.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = s.charAt(j) -'0';
            }
        }
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1 && visited[i][j] != 1) {
                    bfs(i, j);
                    villageNum++;
                }
            }
        }

        System.out.println(villageNum);
        Collections.sort(aptNums);
        for (Integer apt : aptNums) {
            System.out.println(apt);
        }
    }
    public static void bfs(int x, int y) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Deque<int[]> dq = new ArrayDeque<>();
        int aptNum = 1;
        dq.add(new int[]{x, y});
        visited[x][y] = 1;

        while (!dq.isEmpty()) {
            int[] popXY = dq.pop();
            for (int i = 0; i < 4; i++) {
                int nx = popXY[0] + dx[i];
                int ny = popXY[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] == 1) continue;

//                nd[0] = nx;
//                nd[1] = ny; -> 값 덮어 씌움, 주의
//                System.out.println(nx + " " + ny + " " + graph[nx][ny]);

                if(graph[nx][ny] == 1) {
                    dq.add(new int[]{nx, ny});
                    aptNum++;
                }
                visited[nx][ny] = 1;
            }
        }
        aptNums.add(aptNum);
    }
}
