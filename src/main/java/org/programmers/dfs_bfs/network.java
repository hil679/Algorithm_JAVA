package org.programmers.dfs_bfs;

class network {
    boolean visit[];

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];


        for(int i=0; i<n; i++) {
            if(visit[i] == false) {
                answer++;
                DFS(i, computers, n);
            }
        }

        return answer;
    }

    public void DFS(int i, int computers[][], int n) {
        visit[i] = true;

        for(int j=0; j<n; j++) {
            if(visit[j] == false && computers[i][j] == 1) {//i는 내 com, j는 다른 com
                DFS(j, computers, n); // 연결 가능하면 다시 그 연결 가능한 com과 다른 com 연결되는지 확인해서 가능한
                //com 다 true로 바꾸기 -> visit[i] = true; 이부분
            }
        }

    }
}

