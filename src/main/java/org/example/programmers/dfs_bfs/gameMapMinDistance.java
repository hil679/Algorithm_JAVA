package org.example.programmers.dfs_bfs;

import java.util.*;

class gameMapMinDistance {
    //x가 움직이면 y는 움직이지 않기 때문에 x가 1 또는 -1 이면 y는 0만큼 움직인다.
    // 상하좌우 다 움직일 가능성이 있기에 1만 있는 것이 아니라 -1도 있다.
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int solution(int[][] maps) {
        int answer = 0;

        int[][] visited = new int[maps.length][maps[0].length];

        bfs(maps, visited);
        answer = visited[maps.length-1][maps[0].length-1];

        if(answer == 0){
            answer = -1;
        }

        return answer;
    }

    public void bfs(int[][] maps, int[][] visited){ // maps와 visited크기 맞추기(2)
        int x = 0;
        int y = 0;
        visited[x][y] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y}); //가장 처음 {0, 0}이라는 처음 값 들어가 있음

        while(!queue.isEmpty()){
            int[] current = queue.remove();
            int cX = current[0]; // 현재 위치의 x값
            int cY = current[1]; // 현재 위치의 y값

            for(int i = 0; i < 4; i++){
                int nX = cX + dx[i];  // cX = 0일 때 -> 1, 0, -1, 0
                int nY = cY + dy[i];  // 0, 1, 0, -1

                if(nX < 0 || nX > maps.length-1 || nY < 0 || nY > maps[0].length-1)
                    //x좌표가 음수거나 / x좌표가 최대값 n - 1을 넘어갔거나 / y좌표가 음수거나 / y 좌표의 최대값 m - 1를 넘어갔거나
                    continue;

                if(visited[nX][nY] == 0 && maps[nX][nY] == 1){ // 아직 방문 전인데 방문 가능하먄
                    visited[nX][nY] = visited[cX][cY] + 1; // 방문 표시 -> 가까워질 수록 방문 노드 +1 씩 증가
                    //무조건 직전 노드에 대해 상하좌우 확인하기에 직전 위치했던 곳에서 + 1
                    //목표지점 근처에 빨리 도달할 수록 작은 수를 가지고 있을 것이고
                    //목표 지점까지 갈 수 있는 길은 있지만, 더 멀면 도달 지점에서 떨어져 있을거다.
                    //당연히 더 빨리 도달한 애가 visited를 차지하게 되기에 처음 방문한 것이 가장 최소 횟수다.
                    queue.add(new int[]{nX, nY}); //현재 위치를 다시 큐에 넣기
                }
            }

        }


    }
}
