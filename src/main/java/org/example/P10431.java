package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder();
        int answer = 0;

        for(int i = 1; i <= p; i++) {
            int[] students = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(s -> Integer.valueOf(s))
                    .toArray();
            for(int j = 1; j < 20; j++) {
                for(int k = j; k > 0; k--) {
                    if(students[k] > students[k+1]) {
                        int temp = students[k];
                        students[k] = students[k+1];
                        students[k+1] = temp;
                        answer++;
                    } else{
                        break;
                    }
                }
            }

            sb.append(students[0]);
            sb.append(" ");
            sb.append(answer);
            sb.append("\n");
            answer = 0;
        }

        System.out.println(sb.toString());
    }
}
