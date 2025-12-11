package org.example.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.abs;
import static java.lang.Math.ceil;

public class P2089 {
    /* 2->-2의 거듭제곱으로 분해
        7%-2 = 1
        7/-2 = -3
        -13 % -2 = -1
        -13 / -2 = 6
        -13 -> 7(ceil(6.5)) -> -3 -> 2(ceil(-3/-2) -> -1 -> 1(ceil(-1/-2))
        13 -> -6(ceil(-6.5)) -> 3 -> -1 (ceil(1/2)) -> 1
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println(-1%-2);
//        System.out.println(7/-2);
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        if (n == 0) sb.append(0);
        else {
            while (n != 1) {
                sb.append(abs(n % -2));
                n = (int) ceil(n / -2.0);
                System.out.println(n);
            }
            sb.append(n);
        }
        System.out.println(sb.reverse().toString());
    }
}
