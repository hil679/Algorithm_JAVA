package org.example.programmers.graph;

import java.util.*;

class FarthestNode {
    private ArrayList<Integer>[] adj;
    private int[] visit;
    private int depth = 0;

    public int solution(int n, int[][] edge) {
        int answer = 0;
        visit = new int[n+1];
        adj = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<edge.length; i++){
            adj[edge[i][0]].add(edge[i][1]);
            adj[edge[i][1]].add(edge[i][0]);
        } // 양방향

        bfs(1, 1);

        for(int i=1; i<=n; i++){
            if(depth == visit[i]) answer+=1;
        }

        return answer;
    }

    private void bfs(int start, int cur_depth){
        Queue<Integer> q = new LinkedList();
        q.add(start);
        q.add(cur_depth);
        visit[start] = cur_depth;

        while(!q.isEmpty()){
            int node = q.poll(); // cur start node
            cur_depth = q.poll(); // cur_depth

            if(depth < cur_depth) depth = cur_depth;
            for(int i=0; i<adj[node].size(); i++){
                int next = adj[node].get(i); // cur start node와 연결된 노드 확인

                if(visit[next] != 0) continue; // 이미 방문한 적 있으면 그게 최단 -> continue
                visit[next] = cur_depth+1; // 현재 depth + 1 로 연결된 노드까지 depth저장 (next 노드까지 depth)
                q.add(next);
                q.add(cur_depth+1);
            }
        }
    }
}
