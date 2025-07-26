package org.example.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size[] = Arrays.stream( br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int col = size[0];
        int row = size[1];

        int map[][] = new int[row][col];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.valueOf(st.nextToken());
//                System.out.println(map[i][j]);
                if (map[i][j] == 1) {
                    q.add(new int[]{i, j, 0});
//                    System.out.println(i+ " "+ j);
                }
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int days = 0;
        while (!q.isEmpty()) {
            int xy[] = q.poll();
            int x = xy[1];
            int y = xy[0];
            int d = xy [2]; // day for ripe tomato
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= col || ny < 0 || ny >= row || map[ny][nx] != 0) {
                    continue;
                }
                if (map[ny][nx] == 0) {
                    q.add(new int[] {ny, nx, d+1});
                    map[ny][nx] = 1;
                    if (days < d+1) days = d+1;
//                    System.out.println(nx + " " + ny);
                }
            }
        }

        boolean possible = true;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    possible = false;
                    break;
                }
            }
            if (!possible) break;
        }
        if (possible)
            System.out.println(days);

    }
//    2 2
//    0 0
//    0 0
//    주의 -> if (!possible) break;
}
