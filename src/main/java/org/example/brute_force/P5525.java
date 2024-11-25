package org.example.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(bf.readLine());
        int m = Integer.valueOf(bf.readLine());
        String s = bf.readLine();

        int ansCnt = 0;
        int n_cnt = 0;
        for (int i = 1; i < m - 1;){
            if (s.charAt(i) == 'O' && s.charAt(i+1) == 'I'){
                n_cnt++;
                if (n_cnt == n){
                    if (s.charAt(i - 2*n + 1) == 'I') {
                        ansCnt++;
                    }
                    n_cnt--;
                }
                i += 2;
            } else {
                n_cnt = 0;
                i++;
            }
        }

        System.out.println(ansCnt);
    }
}
