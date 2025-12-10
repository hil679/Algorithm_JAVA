package org.example.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class P17087 {
    /*
    s-위치 간 거리끼리 gcd
    s에서 D만큼 이동하여 도달할 수 있으면 다 도달 가능
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        Integer dist[] = new Integer [n];

        int s =Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            dist[i] = abs(s - Integer.parseInt(st.nextToken()));
        }
        int prev = dist[0];
        for (int i = 1; i < n; i++) {
            prev = gcd(prev, dist[i]);
        }
        System.out.println(prev);
    }

    public static int gcd(int a, int b) {
        while (a % b != 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return b;
    }
}
