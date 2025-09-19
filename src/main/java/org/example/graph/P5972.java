package org.example.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//이차원 배열로 하면 메모리 초과
public class P5972 {
    static int arr[][];
    static int visited[];
    static int nodeNum;
    static int min = 1000*50000;
    public static void main_lack_of_memory(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeNum = Integer.parseInt(st.nextToken());
        int rootNum = Integer.parseInt(st.nextToken());

        arr = new int[nodeNum+1][nodeNum+1];
        visited = new int[nodeNum+1];

        for (int i = 0; i < rootNum; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken())+1; // 0인거 막기 위해서 , 나중에 최종 결과에서 지난 길 개수만큼 빼줌
            arr[nodeA][nodeB] = value;
            arr[nodeB][nodeA] = value;
        }

        dfs(1, 0);
        System.out.println(min);
    }


    private static void dfs(int start, int res) {
        if (start == nodeNum) {
//            System.out.println(res);
            if (min > res){
                min = res;
            }
            return;
        }
        visited[start] = 1;
        for (int i = 1; i <= nodeNum; i++) {
            if (arr[start][i] != 0 && visited[i] == 0) {
                dfs(i, res+arr[start][i]-1);
            }
        }
        visited[start] = 0;
    }
}
