package org.example.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//이차원 배열, hashmap으로 하면 메모리 초과,
//dfs는 시간초과
/*
BFS (Breadth-First Search)
- 간선 가중치가 모두 동일(보통 1) 일 때만 최단거리를 보장.
- 큐(FIFO)로 “거리 1 → 거리 2 → …” 순서대로 자연스럽게 탐색.
- 시간 복잡도: O(N+M)

다익스트라
- **간선 가중치가 양의 정수(다양)**일 때 필요.
- 작은 가중치 간선이 먼저 나오기도 해서, “먼저 발견된 경로”가 최단이 아닐 수 있음.
- 따라서 PQ로 “지금까지 발견된 최단 후보 중 제일 작은 것”을 계속 선택.
- 시간 복잡도: O((N+M) log N) (PQ 때문에 log N 붙음)
 */

public class P5972 {
    static int N, M;
    /*
    head[u] = -1 → u에서 나가는 간선이 없음
    head[u] = e → 간선 배열에서 u가 시작점인 첫 간선이 e번 인덱스

    to[e] = v → e번째 간선의 도착 정점은 v
    wt[e] = w → e번째 간선의 비용/길이 = w

    head[u] = e → u의 첫 번째 간선
    그 간선에서 next[e] = e2 → u의 두 번째 간선
    또 next[e2] = e3 … 이런 식으로 연결 리스트처럼 이어짐
    끝이면 next[e] = -1

    head = 정점 → 간선 시작점 인덱스
    to = 간선 인덱스 → 도착 정점
    wt = 간선 인덱스 → 가중치
    next = 간선 인덱스 → 같은 출발 정점의 다음 간선 인덱스
     */
    static int[] head, to, next, wt;
    static int edgeIdx = 0;

    static void addEdge(int u, int v, int w) {
        to[edgeIdx] = v;
        wt[edgeIdx] = w;
        next[edgeIdx] = head[u];
        head[u] = edgeIdx++;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        head = new int[N+1];
        Arrays.fill(head, -1);
        to   = new int[2*M];
        wt   = new int[2*M];
        next = new int[2*M];

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            addEdge(a,b,w);
            addEdge(b,a,w);
        }

        /*
        dist[i]: 시작 정점(1번)에서 i번 정점까지의 현재까지 알려진 최소 거리
        INF: 아주 큰 값, "아직 도달 불가"를 의미
        vis[i]: i 정점이 최단거리 확정됐는지 여부
         */
        final int INF = 1_000_000_000;
        int[] dist = new int[N+1];
        boolean[] vis = new boolean[N+1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 1}); // {dist, node}

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int d = cur[0], u = cur[1];
            if (vis[u]) continue;
            vis[u] = true;
            if (u == N) break;

            //1 -> 5, 2
            // 만약 2의 w가 더 적다면 2부터 거리 계산, 2->3
            // 5보다 3까지 간 dist가 더 적으면 3부터 또 뻗어나감
            // 이후 5->3이라면, 위에서 간 경로보다 5->3이 더 작은지 확인 // if (nd < dist[v]){
            for (int e = head[u]; e != -1; e = next[e]){
                int v = to[e], nd = d + wt[e];
                if (nd < dist[v]){
                    dist[v] = nd;
                    pq.offer(new int[]{nd, v});
                }
            }
        }
        //도착점 N의 최단거리가 여전히 INF이면 도달 불가 → -1 출력
        System.out.println(dist[N] >= INF ? -1 : dist[N]);
    }
}

class ArrayListVersion {

    static int dist[];
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine() );
        N = Integer.parseInt(st.nextToken());   //헛간 그래프
        M = Integer.parseInt(st.nextToken());   //간선

        dist = new int[N+1];

        for (int i = 0; i <= N ; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i =0;i<M;i++){
            st= new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.get(A).add(new Node(B,C));
            graph.get(B).add(new Node(A,C));
        }

        Arrays.fill(dist,Integer.MAX_VALUE);

        dijst();
        System.out.println(dist[N]);
    }

    static void dijst(){
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        queue.add(new Node(1,0));
        dist[1] = 0;

        while (!queue.isEmpty()){
            Node now = queue.poll();

            for(Node next : graph.get(now.v)){
                if(dist[next.v] > dist[now.v]+next.cost){
                    dist[next.v] =dist[now.v]+next.cost;
                    queue.add(new Node(next.v,dist[next.v]));
                }
            }
        }
    }

    static class Node{
        int v;
        int cost;

        public Node(int v,int cost){
            this.v = v;
            this.cost = cost;
        }
    }
}
