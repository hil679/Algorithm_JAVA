package org.example.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10837 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int k = Integer.parseInt(br.readLine()); // round
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n;i++) {
            st = new StringTokenizer(br.readLine());
            int young = Integer.parseInt(st.nextToken());
            int dong = Integer.parseInt(st.nextToken());

            if (young > dong && (young-dong) - (k-young) > 2) {
                System.out.println(0);
            } else if (young < dong && (dong - young) - (k - dong) > 1) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        }


    }
}
