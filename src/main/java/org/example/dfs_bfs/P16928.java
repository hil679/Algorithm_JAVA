package org.example.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16928 {
    /*
        1~100좌표
        1~6, 특수좌표 (0 일반좌표 / !0 특수좌표)
        [주사위 굴리기] → [뱀/사다리 확인] 순서입니다. 이 전체가 하나의 턴입니다.
        뱀 사다리 시작점이면 거기 머물지도 못하고 이동 -> 따라서 뱀/사다리 체크 후 주사위 굴리기는 불가능
        주사위 굴리고 나온 숫자가 뱀/사다리면 이동 아니면 +1

     */
    private static int visited[] = new int [102];
    private static int mem[] = new int [102]; // 1~101
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //ladder, snake
        for (int i = 0; i < n+m; i++) {
            st = new StringTokenizer(br.readLine());
            mem[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        bfs();
        System.out.println(visited[100]);
    }
    /*
        시간복잡도
        1개당 6개 + 특수 1개 있다고 가정
        노드 100개
        -> 700개

        2 1
        2 60
        21 99
        61 20
        # 4

     */
    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        visited[1] = 0;
        q.add(1);

        while(!q.isEmpty()) {
            int curPos = q.poll();
//            if (visited[curPos] != 0) continue;
            for (int i = 1; i <= 6; i++) {
                if (curPos+i > 100) continue;
                if (mem[curPos+i] != 0) {
                    if (visited[mem[curPos+i]] == 0) {
                        visited[mem[curPos+i]] = visited[curPos]+1;
                        q.add(mem[curPos+i]);
                    }
                }
                else if (visited[curPos+i] == 0) {
                    visited[curPos + i] = visited[curPos] + 1;
                    q.add(curPos+i);
                }
            }
        }

    }
}
