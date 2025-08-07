package org.example.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P10026 {
    private static int rgbCnt = 0;
    private static int rbCnt = 0;
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int rgb[][];
    static int rb[][];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());
        rgb= new int[n][n];
        rb = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j =0; j < n; j++) {
               if (line.charAt(j) == 'R') {
                   rgb[i][j] = 1;
                   rb[i][j] = 1;
               } else if (line.charAt(j) == 'G') {
                   rgb[i][j] = 3;
                   rb[i][j] = 1;
               } else {
                   rgb[i][j] = 2;
                   rb[i][j] = 2;
               }
//                System.out.print(rgb[i][j]);
            }
//            System.out.println();
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (rgb[i][j] != 0) {
//                    System.out.println(rgb[i][j]);
                    dfsrgb(i, j, rgb[i][j]);
                    rgbCnt++;
                }
                if (rb[i][j] != 0) {
                    dfsrb(i, j, rb[i][j]);
                    rbCnt++;
                }
            }
        }
        System.out.println(rgbCnt + " " + rbCnt);
    }

    private static void dfsrgb(int x, int y, int color) {
//        System.out.println(color);
        Queue<int[]> q = new LinkedList<>();
        int xy[] = {x, y};
        q.add(xy);
        rgb[x][y] = 0;
        while (!q.isEmpty()) {
            int nxy[] = q.poll();

            for (int i =0; i < 4; i++) {
                int nx = nxy[0] + dx[i];
                int ny = nxy[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || rgb[nx][ny] == 0)
                    continue;
                if (rgb[nx][ny] == color) {
                    rgb[nx][ny] = 0;
//                    System.out.println(nx + " " + ny);
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static void dfsrb(int x, int y, int color) {
        Queue<int[]> q = new LinkedList<>();
        int xy[] = {x, y};
        q.add(xy);
        rb[x][y] = 0;
        while (!q.isEmpty()) {
            int nxy[] = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = nxy[0] + dx[i];
                int ny = nxy[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || rb[nx][ny] == 0)
                    continue;
                if (rb[nx][ny] == color) {
                    rb[nx][ny] = 0;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}
