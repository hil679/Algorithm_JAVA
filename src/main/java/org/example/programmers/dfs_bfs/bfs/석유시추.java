package org.example.programmers.dfs_bfs.bfs;

import java.util.*;
public class 석유시추 {
    int[] result ;
    public int solution(int[][] land) {
        int answer = 0;
        result = new int[land[0].length];

        for (int row = 0; row < land.length; row++) {
            for (int r = 0; r < land[0].length; r++) {
                if (land[row][r] == 1) {
                    bfs(row, r, land);
                }
            }
        }
        answer = Arrays.stream(result).max().getAsInt();
        return answer;
    }

    public void bfs(int x, int y, int[][] land) {
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int cnt = 1;
        q.add(new int[] {x, y});
        land[x][y] = 0;
        int[] mining = new int[land[0].length];
        mining[y] = 1;

        while (!q.isEmpty()) {
            int[] new_pos = q.poll();

            for (int i =0; i < 4; i++) {
                int nx = new_pos[0] + dx[i];
                int ny = new_pos[1] + dy[i];
                if (nx < 0 || nx >= land.length || ny < 0 || ny >= land[0].length)
                    continue;
                if (land[nx][ny] == 1) {
                    land[nx][ny] = 0;
                    q.add(new int[] {nx, ny});
                    cnt++;
                    mining[ny] = 1;
                }
            }
        }
        // System.out.println(cnt);
        for (int i = 0; i < mining.length; i++) {
            if (mining[i] == 1) {
                result[i] += cnt;
            }
        }
    }
}
