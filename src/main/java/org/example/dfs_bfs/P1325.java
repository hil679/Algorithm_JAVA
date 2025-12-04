package org.example.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1325 {
    static int visited[];
    static int visitId = 0;
    static int n;
//    static int relation[][];
    static List<List<Integer>> relation = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
//        relation = new int[n+1][n+1];
        int cnt[] = new int[n+1];
        for (int i = 1; i <= n+1; i++) {
            relation.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            relation.get(b).add(a);
//            relation[a][b] = 1;

        }
        visited = new int[n+1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int hackedComNum = bfs(i);
            cnt[i] = hackedComNum;
//            System.out.println(hackedComNum);
            if (max < hackedComNum) max = hackedComNum;
        }
//        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == max)
//                sb.append(i).append(' ');
                System.out.print(i + " ");
        }
//        System.out.print(sb.toString());

    }

    public static int bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visitId++;
        visited[start] = visitId;
        int connectedCom = 0;
        while (!q.isEmpty()) {
            int curCom = q.poll();

            for (int i : relation.get(curCom)) {
                if (visited[i] != visitId) {
                    q.add(i);
                    visited[i] = visitId;
                    connectedCom++;
                }
            }
        }
        return  connectedCom;
    }
}
