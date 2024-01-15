package org.example.구현;

import java.util.Scanner;

public class P1205 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tScore = sc.nextInt();
        int p = sc.nextInt();//랭킹에 올라갈 수 있는 개수
        int rank = 1;
        int sameRank = 0;

        for(int i = 0; i<n; i++) {
            int score = sc.nextInt();
            if(tScore < score){
                rank++;
            }
            if(tScore == score)
                sameRank++;
        }

        if(rank + sameRank <= p)
            System.out.println(rank);
        else
            System.out.println(-1);

    }
}
//3 90 10
//100 100 90