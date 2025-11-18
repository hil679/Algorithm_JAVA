package org.codeup.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2608 {
    static int n;
    public static void sol(int depth, String vote) {
        if (depth == n) {
            System.out.println(vote);
            return;
        }
        sol(depth+1, vote+"O");
        sol(depth+1, vote+"X");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());

        sol(0, "");
    }
}
