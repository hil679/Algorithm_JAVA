package org.example.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P22968 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(bf.readLine());
        int[] arr = new int[44];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= 43; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + 1;
        }

        for (int i = 0; i < n; i++) {
            int v = Integer.valueOf(bf.readLine());
            for (int j = 2; j <= 43; j++) {
                if (arr[j] > v && v >= arr[j - 1]) {
                    System.out.println(j - 1);
                }
            }
        }
    }
}
