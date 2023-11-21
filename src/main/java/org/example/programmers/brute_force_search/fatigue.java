package org.example.programmers.brute_force_search;

class fatigue {
    static boolean[] visited;
    static int answer = -1;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];

        dfs(0, k, dungeons);
        return answer;
    }

    static void dfs(int cnt, int heal, int[][] dungeons){
        if (cnt == dungeons.length) {
            answer = dungeons.length;
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && heal >= dungeons[i][0]) {
                visited[i] = true;
                dfs(cnt + 1, heal - dungeons[i][1], dungeons);
                visited[i] = false;
            }
            if(i ==  visited.length - 1) {
                answer = answer > cnt ? answer : cnt;
            }
        }
    }

}
