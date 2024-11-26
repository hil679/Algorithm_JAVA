package org.example.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10775 {
    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.valueOf(bf.readLine());
        int p = Integer.valueOf(bf.readLine());
        int ans = 0;
        visit = new int[g + 1];
        for (int i = 1; i < g + 1; i++) {
            visit[i] = i;
        }

        for (int i = 1; i <= p; i++) {
            int airplane = Integer.valueOf(bf.readLine());

            if (find(airplane) == 0) break;
                ans++;
            union(find(airplane), find(airplane) - 1);
        }
        System.out.println(ans);
    }

    private static int find(int airplane) {
        if (visit[airplane] == airplane)
            return airplane;
        else
            return visit[airplane] = find(visit[airplane]);
    }

    private static void union(int airplane, int leftDocking) {
        airplane = find(airplane);
        leftDocking = find(leftDocking);

        visit[airplane] = leftDocking;
    }
}
