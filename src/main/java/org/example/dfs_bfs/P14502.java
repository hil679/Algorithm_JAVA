package org.example.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14502 {
    static int map[][];
    static int col, row;
    static int maxSafeZone = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size[] = Arrays.stream( br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        col = size[1];
        row = size[0];

        map = new int[row][col];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        dfs(0);

        System.out.println(maxSafeZone);

    }

    static public void dfs(int wall) {
        if (wall == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wall+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(map[i][j] == 2) {
                    q.add(new Node(i,j));
                }
            }
        }
        //원본 연구소를 바꾸지 않기 위한 카피맵 사용
        int copyMap[][] = new int[row][col];

        for (int i = 0; i < row; i++) {
            copyMap[i] = map[i].clone();
        }

        //BFS 탐색 시작
        int dx[] = {1, -1, 0, 0};
        int dy[] = {0, 0, 1, -1};
        while(!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x; // 현재 값
            int y = now.y; //

            for(int k=0; k<4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                //연구소 범위 밖이 아니고 빈칸일 경우에만 바이러스를 퍼트린다.
                if(0<=nx && nx<row && 0<=ny && ny<col) {
                    if(copyMap[nx][ny] == 0) {
                        q.add(new Node(nx,ny));
                        copyMap[nx][ny] = 2;
                    }
                }
            }
        }

        int safeZone =0;
        for(int i=0; i<row ; i++) {
            for(int j=0; j<col; j++) {
                if(copyMap[i][j] == 0) {
                    safeZone++;
                }
            }
        }
        if (maxSafeZone < safeZone) {
            maxSafeZone = safeZone;
        }
    }

    //Queue에 좌표값 x,y를 넣기 위함.
    static class Node {
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
