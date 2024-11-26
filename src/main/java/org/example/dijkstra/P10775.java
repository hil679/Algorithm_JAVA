package org.example.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Long.toBinaryString;

public class P10775 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.valueOf(bf.readLine());
        int p = Integer.valueOf(bf.readLine());
        int ans = 0;
        int visit = ((1 << g+1) - 1);
        visit = visit & ~(1 << (0)); //0번째를 0으로
//        System.out.println(toBinaryString(visit));

        for (int i = 1; i <=p; i++) {
            int airplane = Integer.valueOf(bf.readLine());
            while(airplane > 0) {
                if ((visit & (1 << (airplane))) == (1 << (airplane))) {
                    visit = visit & ~(1 << (airplane));
//                System.out.println(toBinaryString(visit));
                    ans++;
                    break;
                }
                airplane--;
            }
            if (visit == 0)
                break;
        }
        System.out.println(ans);
    }
}
