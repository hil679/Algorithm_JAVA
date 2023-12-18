package org.example.programmers.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 음료수얼려먹기 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sizes = bf.readLine().split(" ");
        int n = Integer.valueOf(sizes[0]);
        int m = Integer.valueOf(sizes[1]);
        String[][] maps = new String[n][m];
        int answer = 0;

        for(int i =0; i < n; i++) {
            maps[i] = bf.readLine().split("");
        }

        for(int i = 0; i<n; i++) {
            for(int j = 0; j < m; j++) {
                if(maps[i][j].equals("0")) {
                    bfs(i, j, maps);
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }

    public static void bfs(int cx, int cy, String[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {cx, cy});

        while(!queue.isEmpty()) {
            int[] cxy = queue.poll();
            cx = cxy[0];
            cy = cxy[1];
            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || ny < 0 || nx > maps.length - 1 || ny > maps[0].length - 1 || !maps[nx][ny].equals("0") )
                    continue;

                maps[nx][ny] = "2";
                queue.add(new int[] {nx, ny});
            }
        }
    }
}

//15 14
//00000111100000
//11111101111110
//11011101101110
//11011101100000
//11011111111111
//11011111111100
//11000000011111
//01111111111111
//00000000011111
//01111111111000
//00011111111000
//00000001111000
//11111111110011
//11100011111111
//11100011111111