package org.example.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P13549 {
    public static int visited[] = new int [100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bfs(N, K);
        System.out.println(visited[K]-1);
    }

     //2 → 4 (순간이동, 0초) → 8 (순간이동, 0초) → 7 (걷기, 1초) : 0초, 1초 순서가 필요
    private static void bfs(int start, int end) { //5 17
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 1;//5
        while (!q.isEmpty()) {
            Integer pos = q.poll();
            if (pos.equals(end)) {
                break;
            }
            if (pos *2 >= 0 && pos *2 <=100000) {
                if (visited[pos*2] == 0) {
                    visited[pos * 2] = visited[pos];
                    q.add(pos * 2);
                }
            }
            if (pos - 1 >= 0 && pos -1 <=100000) {
                if (visited[pos-1] == 0) {
                    visited[pos - 1] = visited[pos] + 1;
                    q.add(pos - 1);
                }
            }
            if (pos + 1 <= 100000 && pos +1 >= 0) {
                if (visited[pos+1] == 0) {
                    visited[pos + 1] = visited[pos] + 1;
                    q.add(pos + 1);
                }
            }
            if (pos + 1 <= 100000 && pos +1 >= 0) {
                if (visited[pos+1] == 0) {
                    visited[pos + 1] = visited[pos] + 1;
                    q.add(pos + 1);
                }
            }


            // 5
            //4 6 8
            //3 7 12 9 16
            //2 14
        }
    }
}
