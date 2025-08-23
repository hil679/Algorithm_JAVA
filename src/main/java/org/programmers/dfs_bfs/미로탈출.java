package org.programmers.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sizes = bf.readLine().split(" ");
        int n = Integer.valueOf(sizes[0]);
        int m = Integer.valueOf(sizes[1]);
        String[][] maps = new String[n][m];
        int[][] visit = new int[n][m];

        for(int i = 0 ; i < n; i++) {
            maps[i] = bf.readLine().split("");
        }

        bfs(visit, maps, n-1, m-1);

        System.out.println(visit[n-1][m-1]);
    }

    public static void bfs(int[][] visit, String[][] maps, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        int x = 0;
        int y = 0;
        visit[0][0] = 1;

        queue.add(new int[] {x, y});

        while(!queue.isEmpty()) {
            int[] cxy = queue.poll();
            x = cxy[0];
            y = cxy[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx > n || ny > m || maps[nx][ny] == "0" || visit[nx][ny] != 0) {
                    continue;
                }

                visit[nx][ny] = visit[x][y] + 1;
                queue.add(new int[] {nx, ny});
            }
        }
    }
}

//5 6
//101010
//111111
//000001
//111111
//111111
