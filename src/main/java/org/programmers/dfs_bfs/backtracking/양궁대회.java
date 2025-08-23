package org.programmers.dfs_bfs.backtracking;

public class 양궁대회 {
    int max = -1;
    int[] result = new int[11];//0~10점
    int[] lion = new int[11];
    public int[] solution(int n, int[] info) {
        int[] answer = {-1};
        dfs(0, n, info);
        if (max == -1)
            return answer;
        return lion;
    }

    public void dfs(int depth, int n, int[] info) {
        if (depth == n) {
            int diff = score(info);
            if (max <= diff) {
                max = diff;
                lion = result.clone();
            }
            return;
        }

        for (int i = 0; i < result.length && result[i] <= info[i]; i++) {
            result[i]+=1;
            dfs(depth+1, n, info);
            result[i]-=1;
        }
    }

    public int score(int[] info) {
        int lion = 0;
        int ap = 0;
        for (int i =0; i < info.length; i++) {
            if (info[i] == 0 && result[i] == 0) {
                continue;
            }
            else if (info[i] < result[i]) {
                lion += 10 -i;
            } else if (info[i] >= result[i]) {
                ap += 10 -i;
            }
        }
        if (lion > ap)
            return lion-ap;
        return -1;
    }
}
