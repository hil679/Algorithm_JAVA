package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] nationInfo = bf.readLine().split(" ");
        int n = Integer.valueOf(nationInfo[0]);
        int k = Integer.valueOf(nationInfo[1]);
        int[][] medals = new int[n + 1][4];
        int result = 0;

        for(int i = 1; i <= n; i++) {
            int[] medal = Arrays.stream(bf.readLine().split(" "))
                    .mapToInt(x -> Integer.valueOf(x)).toArray();
            medals[medal[0]] = new int[]{medal[1], medal[2], medal[3]};
        }

        for(int i = 1; i <= n; i++) {
            if(medals[k][0] < medals[i][0]) {
                result++;
            } else if (medals[k][0] == medals[i][0]) {
                if(medals[k][1] < medals[i][1]){
                    result++;
                } else if (medals[k][1] == medals[i][1]) {
                    if(medals[k][2] < medals[i][2]){
                        result++;
                    }
                }
            }
        }

        System.out.println(result + 1);
    }
}
