package org.example.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2097 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            if ((i+1)*(i+1) >= n) {
                System.out.println(i*4);
                break;
            } else if ((i+1) * (i+2) >= n) {
                System.out.println((i+1)*2 + i*2);
                break;
            }
        }
    }
}

