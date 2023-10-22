package org.example.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem24444 {
    static boolean[] visited;
    static int[] seq;
    static int cnt = 1;
    static Queue<Integer> queue = new LinkedList<>();;
    static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.valueOf(st.nextToken());
        int edge = Integer.valueOf(st.nextToken());
        int startNode = Integer.valueOf(st.nextToken());

        visited = new boolean[node + 1];
        seq = new int[node + 1];

        for(int i = 0; i <= node; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i <= edge; i++){
            st = new StringTokenizer(br.readLine());

            int firstNode = Integer.valueOf(st.nextToken());
            int secondNode = Integer.valueOf(st.nextToken());//4 2

            graph.get(firstNode).add(secondNode);
            graph.get(secondNode).add(firstNode);
        }

        for(int i = 1; i <= node; i++){
            Collections.sort(graph.get(i)); //내림차순 정렬 24  42
        }

        visited[startNode] = true;
        queue.add(startNode);
        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= node; i++)
            sb.append(seq[i]+ "\n");

        System.out.println(sb);
    }

    public static void bfs(){
        int root;
        while (!queue.isEmpty()) {
            root = queue.remove();// 큐 맨 앞쪽의 요소를 삭제한다.
           // System.out.println("r: "+root);
            seq[root] = cnt++;//큐에는 중복이 없고 순서대로임으로 root로 빼면 cnt 값을 add해주면 됨
            for(int vertex : graph.get(root)) { //each v ∈ E(u)  # E(u) : 정점 u의 인접 정점 집합.(정점 번호를 오름차순으로 방문한다)
                if (!visited[vertex]) {
                    visited[vertex] = true; // #정점 v를 방문 했다고 표시한다.
                    queue.add(vertex);//방문 안한 노드만 순서대로 큐에 넣음
                }
            }
        }
    }
}
