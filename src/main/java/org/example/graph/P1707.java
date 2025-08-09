package org.example.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1707 {
    

    /*
    1
    4 3
    1 4 (1 , -1)
    2 3 (1, -1)
    3 4 (-1, -1)
    YES인데 NO라고 출력
    간선 순서에 따라, 사이클을 발견하지 못함.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        while (n > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int node[] = new int [V+1];
            boolean flag = true;
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int color1 = Integer.parseInt(st.nextToken());
                int color2 = Integer.parseInt(st.nextToken());


                if (node[color1] == 0 && node[color2] == 0) {
                    node[color1] = 1;
                    node[color2] = -1;
                } else if (node[color1] == 0) {
                    node[color1] = -node[color2];
                } else if (node[color2] == 0) {
                    node[color2] = -node[color1];
                } else if (node[color1] == node[color2]) {
                    flag = false;
                    break;
                }
//                System.out.println(node[color1] + " " + node[color2]);

            }
            if (flag)
                System.out.println("YES");
            else
                System.out.println("NO");
            n--;
        }
    }
}
