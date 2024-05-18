package org.example.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        int[] tower = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::new).toArray();
        int[] answer = new int[n];

        for (int i = n -1; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                if (tower[i] < tower[j - 1]) {
                    answer[i] = j;
                    break;
                }
            }
        }

        for (int a : answer) {
            System.out.print(a + " ");
        }
    }
}
