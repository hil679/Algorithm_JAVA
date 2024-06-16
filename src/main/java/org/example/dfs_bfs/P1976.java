package org.example.dfs_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1976 {
    static int cityNum, planNum;
    static ArrayList<Integer>[] graph;
    static int[] plan;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cityNum = sc.nextInt();
        planNum = sc.nextInt();
        plan = new int[planNum];
        graph = new ArrayList[cityNum + 1];
        for (int i = 0; i <= cityNum; i++) {
            graph[i] = new ArrayList<>();
        }
        //도시 연결 정보 저장
        for (int i = 1; i <= cityNum; i++) {
            for (int j = 1; j <= cityNum; j++) {
                int tmp = sc.nextInt();
                if (tmp == 1) {
                    graph[i].add(j);
                }
                if (i == j) graph[i].add(j);
            }
        }
        // 계획 정보 저장
        for (int i = 0; i < planNum; i++) {
            plan[i] = sc.nextInt();
        }

        for (int i = 0; i < planNum - 1; i++) {
            bfs(plan[i], plan[i + 1]);
        }
        System.out.println("YES");
    }

    static void bfs(int start, int dest) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[cityNum + 1];
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 0; i < graph[now].size(); i++) {
                int next = graph[now].get(i);
                if (next == dest) return;
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
        System.out.println("NO");
    }
}