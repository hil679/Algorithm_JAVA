package org.example.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class nightOfKing {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String current = bf.readLine();
        int x = Integer.valueOf(current.charAt(0));
        int y = Integer.valueOf(current.substring(1, 2));
        int x_min = Integer.valueOf('a');
        int x_max = Integer.valueOf('h');
        int y_min = 1;
        int y_max = 8;
        int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};
        int result = 0;

        for(int i = 0; i < 8; i++) {
            if(x_min <= x + dx[i]
                    && x + dx[i] <= x_max
                    && y_min <= y + dy[i]
                    && y + dy[i] <= y_max) {
                result += 1;
            }
        }
        System.out.println(result);
    }
}
