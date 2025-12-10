package org.example.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class P2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        //2의 조합이 5의 조합보다 항상 작지 않음(10C2, 5C1)
        int ans5 = cnt(n, 5)  - cnt(m, 5) - cnt(n-m, 5);
        int ans2 = cnt(n, 2)  - cnt(m, 2) - cnt(n-m, 2);
        System.out.println(min(ans5, ans2));
    }
    public static int cnt(int num, int standard) {
        int ans = 0;
        while (num >= standard) {
            ans -= num / standard;
            num /= standard;
        }
        return ans;
    }
}

