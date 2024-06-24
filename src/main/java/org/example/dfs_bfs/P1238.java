package org.example.dfs_bfs;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1238 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder sb;
    static StringTokenizer st;
    static int n, m, x, a, b, t, time[], r_time[];
    static ArrayList<Node> village[], r_village[];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        village = new ArrayList[n + 1];
        r_village = new ArrayList[n + 1]; //역방향
        time = new int[n+1];
        r_time = new int[n+1]; //역방향
        Arrays.fill(time, Integer.MAX_VALUE);
        Arrays.fill(r_time, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            village[i] = new ArrayList<>();
            r_village[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            village[a].add(new Node(b, t));
            r_village[b].add(new Node(a, t));
        }

        dijkstra(village, time, x);

        dijkstra(r_village, r_time, x);

        int max = 0;
        for(int i=1; i<=n; i++) {
            max = Math.max(max, time[i] + r_time[i]);
        }

        System.out.println(max);

    }

    static void dijkstra(ArrayList<Node>[] villages, int[] time, int start) {
        PriorityQueue<Node> q = new PriorityQueue<Node>();
        q.add(new Node(start, 0));
        time[start] = 0;

        while(!q.isEmpty()) {
            Node now = q.poll();
            for(Node next : villages[now.node]) {
                if (time[next.node] > time[now.node] + next.time) { // now까지 걸린 시간 + now에서 Next 마을로 가는 시간
                    time[next.node] = time[now.node] + next.time;
                    q.add(new Node(next.node, time[next.node]));
                }
            }
        }
    } //bfs랑 다익스트라랑..??

    static class Node { //implements Comparable<Node>
        int node;
        int time;

        public Node(int node, int time) {
            super();
            this.node = node;
            this.time = time;
        }

//        @Override
//        public int compareTo(Node o) {
//            return this.time - o.time;
//        }

    }
}
