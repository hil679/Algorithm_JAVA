package org.example.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1238 {
    static Integer[][] roadInfo;
    static int curStudentTime = 0;
    static Integer N;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] NMX = bf.readLine().split(" ");
        N = Integer.valueOf(NMX[0]);
        Integer M = Integer.valueOf(NMX[1]);
        Integer X = Integer.valueOf(NMX[2]); // target village

        roadInfo = new Integer[N+1][N+1];
        for (int i = 0; i < M; i++) { //String road = bf.readLine(); road != null; road = bf.readLine()
            String road = bf.readLine();
            String[] roadArr = road.split(" ");
            roadInfo[Integer.valueOf(roadArr[0])][Integer.valueOf(roadArr[1])] = Integer.valueOf(roadArr[2]);
        }

        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            if (i == X)
                continue;
            bfs(i, X);
            bfs(X, i);
            if (maxTime < curStudentTime)
                maxTime = curStudentTime;
            curStudentTime = 0;
        }
        System.out.println(maxTime);
    }

    public static void bfs(Integer curVillage, Integer target) {
        if(roadInfo[target][curVillage] != null) {
            curStudentTime += roadInfo[target][curVillage];
            return;
        }

        int minidx = 0;
        int min = 101;

        for (int i = 1; i <= N; i++) {
            if (roadInfo[target][i] == null)
                continue;
            if ( min > roadInfo[target][i]) {
                min = roadInfo[target][i];
                minidx = i;
            }
        }
        bfs(curVillage, minidx);
    }
}
