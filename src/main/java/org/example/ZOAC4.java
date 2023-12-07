package org.example;

import java.util.Scanner;
/*
idea: 비워야하는 칸 개수 앞에는 무조건 사람이 앉아있다. 따라서 사람 + 비우는 개수를 한 묶음으로 보고 몇 번이나 들어가는지 구한다.
 */
public class ZOAC4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt(); //행 개수
        int W = sc.nextInt(); // 열 개수
        int N = sc.nextInt() + 1; // 세로로 비우는 칸 개수 + 1 -> 1은 앉기 가능 좌석 의미
        int M = sc.nextInt() + 1; // 가로로 비우는 칸 개수 + 1

        int hor = W / M; // 가로로 앉을 수 있는 개수
        int ver = H / N; // 세로로 앉을 수 있는 개수

        if(W % M != 0) { //묶음의 개수로 나누어 떨어지지 않으면
            hor += 1; // 뒤에 한 명 더 앉을 수 있음
        }
        if(H % N != 0) { // 마찬가지
            ver += 1;
        }

//        if(hor == 0)  -> hor과 ver은 양수일 수 밖에 없음
//            hor = 1;  -> (나누어 떨어지면 몫이 있는 거고 아니면 위에서 무조건 +1 하기 때문)
//        if(ver == 0)
//            ver = 1;

        System.out.print(hor*ver);
    }
}
