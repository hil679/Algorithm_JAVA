package org.example.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem24479 {
    static boolean[] visited;// List<Integer>로 node번호를 담고 contain으로 if문한 후 여기 담으면 시간초과!
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] seq;
    static int cnt = 1;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());
        seq = new int[nodeNum + 1];
        visited = new boolean[nodeNum + 1];

        for (int i = 0; i <=nodeNum; i++)
            graph.add(new ArrayList<>());//nodeNum인 list에 넣을 거니까

        for (int i = 1; i <= edgeNum; i++ ){
            st = new StringTokenizer(br.readLine());
            int firstNode = Integer.parseInt(st.nextToken());
            int secondNode = Integer.parseInt(st.nextToken());
            graph.get(firstNode).add(secondNode);
            graph.get(secondNode).add(firstNode);
        }

        for (int i = 1; i <= nodeNum; i++)
            Collections.sort(graph.get(i));

        visited[startNode] = true;
        dfs(startNode);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= nodeNum; i++)
            sb.append(seq[i] + "\n");

        System.out.println(sb);

    }

    public static void dfs(int root) {
        seq[root] = cnt;
        for (int vertex : graph.get(root)) {
            if (!visited[vertex]) {
                visited[vertex] =true;
                cnt++;//seq[root] = cnt++;로 합치면 오류남 -> root랑 이어지는 vertex가 없으면 cnt를 seq에 저장하지 못하기 때문
                dfs(vertex);
            }
        }

    }
}
