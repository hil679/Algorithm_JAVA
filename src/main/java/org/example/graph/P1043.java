package org.example.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1043 {
    public static int[] parent;
    public static List<Integer> truthPeople;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int peopleNum = Integer.valueOf(st.nextToken());
        int party = Integer.valueOf(st.nextToken());

        parent = new int[peopleNum + 1];
        for (int i = 1; i <=peopleNum; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(bf.readLine());
        truthPeople = new ArrayList<>();
        int truthPeopleNum = Integer.valueOf(st.nextToken());
        if (truthPeopleNum == 0) {
            System.out.println(party);
            return;
        }
        while (st.hasMoreTokens()) {
            truthPeople.add(Integer.valueOf(st.nextToken()));
        }

        int[][] parties = new int[51][51];
        for (int i =0; i < party; i++) {
            int j = 0;
            st = new StringTokenizer(bf.readLine());
            st.nextToken();
            int x = Integer.valueOf(st.nextToken());
            parties[i][j++] = x;

            while (st.hasMoreTokens()) {
                int y = Integer.valueOf(st.nextToken());
                parties[i][j] = y;
                union(x, y);
                j++;
            }
        }

        int ans = 0;
        for (int i = 0; i < party; i++) {
            boolean flag = true;
            for (int j = 0; parties[i][j] != 0; j++) {
                if (truthPeople.contains(find(parent[parties[i][j]]))) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                ans++;
        }
        System.out.println(ans);
    }

    public static int find(int x) {
        if (parent[x] == x)
            return x;
        else
            return find(parent[x]); // find한 숫자가 다시 다른 숫자과 연관있을 수 있으니 find 또 필요
    }

    public static void union(int a, int b) {
        int x = find(parent[a]);
        int y = find(parent[b]);
        if (truthPeople.contains(y))
            parent[x] = y;
        else
            parent[y] = x;
    }
}
