package org.example.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem24480 {
    static boolean[] visited;
    static int[] seq;
    static int cnt = 1;
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
            int secondNode = Integer.valueOf(st.nextToken());

            graph.get(firstNode).add(secondNode);
            graph.get(secondNode).add(firstNode);
        }

        for(int i = 1; i <= node; i++){
            Collections.sort(graph.get(i), Collections.reverseOrder()); //내림차순 정렬
        }

        visited[startNode] = true;
        dfs(startNode);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= node; i++)
            sb.append(seq[i]+ "\n");

        System.out.println(sb);


    }

    public static void dfs(int root){
        seq[root] = cnt;
        for(int vertex : graph.get(root)){
            if(!visited[vertex]){
                visited[vertex] = true;
                cnt++;
                dfs(vertex);
            }
        }

    }
}
