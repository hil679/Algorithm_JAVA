package org.example.programmers.dfs_bfs;
import java.util.*;
public class 등산코스정하기 {
    public static List<List<Node>> graph;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};

        //그래프 만들기
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        //출입구->산봉우리 단방향 등산로

        //입구일 경우 다른 곳으로만 갈 수 있는 단방향
        //산봉우리일 경우 특정 한 곳에서 산봉우리로 가는 단방향
        for(int[] path: paths){
            int s = path[0];
            int e = path[1];
            int cost = path[2];

            if(isGate(s, gates) || isSummit(e, summits)){
                graph.get(s).add(new Node(e, cost));
            }
            else if(isGate(e, gates) || isSummit(s, summits)){
                graph.get(e).add(new Node(s, cost));
            }
            else{
                graph.get(s).add(new Node(e, cost)); // 일반 등산로 양방향
                graph.get(e).add(new Node(s, cost));
            }
        }

        answer = dijkstra(n, gates, summits);

        return answer;
    }

    public int[] dijkstra(int n, int[] gates, int[] summits){
        int[] intensity = new int[n+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
//        Queue<Node> q = new LinkedList<>(); -> 시간 및 공간 복잡도 더 작음

        Arrays.fill(intensity, Integer.MAX_VALUE);

        // 시작지점 먼저 모두 추가
        for(int gate : gates){
            pq.offer(new Node(gate, 0));
//            q.offer(new Node(gate, 0));
            intensity[gate] = 0; //출입구
        }

        while(!pq.isEmpty()){
            Node nn = pq.poll();
//            Node nn = q.poll();

            if(intensity[nn.v] < nn.cost){
                continue;
            }

            //intensity 갱신( 번호 기준 DP(봉우리, 쉼터, 출발지)b)
            // ####### 시작지점 모두 먼저 추가할 수 있고 intensity를 봉우리별로 덮어쓸 수 있는 이유 #######
            //쉼터는 어떻게든 봉우리와 연결(쉼터로만 끝나는 길은 존재하지 않음
            // -> 따라서 어느 출발지에서 먼저 출발하든 intensity가 짧은 경로가면 됨
            for(int i=0; i < graph.get(nn.v).size(); i++){ //nn.v와 연결된 노드 intensity확인 및 update
                Node u = graph.get(nn.v).get(i);

                //최솟값 갱신
                int c = Math.max(intensity[nn.v], u.cost);
                if(intensity[u.v] > c){
                    intensity[u.v] = c;
                    pq.offer(new Node(u.v, c));
//                    q.add(new Node(u.v, c));
                }
            }
        }

        //intensity가 최소가 되는 등산코스에 포함된 산봉우리 번호와 intensity의 최솟값
        int sv = 0; //산봉우리 번호
        int smin = Integer.MAX_VALUE; //intensity 최솟값

        Arrays.sort(summits);

        for (int summit : summits) {
            if (intensity[summit] < smin) {
                smin = intensity[summit];
                sv = summit;
            }
        }

        int[] ans = {sv, smin};
        return ans;
    }

    public boolean isGate(int v, int[] gates){
        for (int gate : gates) {
            if (v == gate) return true;
        }

        return false;
    }

    public boolean isSummit(int v, int[] summits){
        for (int summit : summits) {
            if (v == summit) return true;
        }

        return false;
    }

    static private class Node implements Comparable<Node>{
        int v, cost;
        Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
