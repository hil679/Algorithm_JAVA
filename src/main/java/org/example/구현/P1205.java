package org.example.구현;

import java.util.Scanner;

public class P1205 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tScore = sc.nextInt(); // 태수의 점수
        int p = sc.nextInt();//랭킹에 올라갈 수 있는 개수
        int rank = 1;
        int sameRank = 0;

        for(int i = 0; i<n; i++) {
            int score = sc.nextInt();
            if(tScore < score){ // 태수의 점수보다 크면 랭크가 하나씩 밀리고
                                // 같을 때는 공동 순위이기 때문에 랭크에 변화가 없다.
                rank++;
            }
            if(tScore == score) // 하지만 같은 점수인 사람이 많아 태수보다
                                // 높은 순위의 사람들과 같은 순위의 사람들의 합이 랭킹 리스트에 올라갈 수 있는 사람 수보다 많으면
                                // 태수는 올라갈 수 없다.
                sameRank++; // 따라서 태수와 같은 랭킹인 사람의 수를 구한다.
        }

        if(rank + sameRank <= p) // 높은 순위 + 같은 순위 <= 랭킹 리스트 목록 개수 -> 랭킹 출력 가능
            System.out.println(rank);
        else
            System.out.println(-1);

    }
}
//3 90 10
//100 100 90