package org.example.구현;

import java.util.*;
/*
조건: 무조건 홀수 개만 가져갈 수 있다.
-> 1. 홀수 2개가 모여 짝수가 되기에, 돌의 개수가 짝수인 경우에는 2번째로 하는 사람이 이기게 된다.
-> 2. 그렇다면 반대로 돌의 개수가 홀수인 경우에는 처음 시작하는 사람이 이긴다.
 */
public class P9655{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n % 2 == 0) { // 짝수면
            System.out.println("CY"); // 나중에 시작하는 창영이가 이긴다.
        } else { // 홀수면
            System.out.println("SK"); // 처음에 하는 상근이가 이긴다.
        }
    }
}
