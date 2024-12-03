package org.example.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
* !!!큰 범위는 type 주의 필요!!!
* bitmasking 문제
* 경우의 수
*/
public class P2825 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int trial = Integer.valueOf(bf.readLine());
        int numbers[] = new int[1024];
        long ans = 0; //type 주의

        for (int i = 0; i < trial; i++) {
            long num = Long.valueOf(bf.readLine());
            int bit = 0;
            while (num > 0) {
                bit = bit | (1 << (num % 10));
                num /= 10;
            }

            numbers[bit] += 1;
        }

        for (int i = 1; i < 1024; i++) { // 1023이면 안돼 -> 1023끼리 쌍 안 더해지니까
            for (int j = i + 1; j < 1024; j++) {
                if ((i & j) != 0) {
                    ans += 1l *numbers[i] * numbers[j]; // 다른 숫자도 포함되어 있지만 같은 것도 있는 그룹
                }
            }
//            ans += 1l * (numbers[i] * (numbers[i] - 1)) / 2;
// 이거 때문에 틀림... int끼리의 먼저 연산으로 overflow가능하기 때문에 1L로 long으로 먼저 변환이 필요
            ans += 1l * numbers[i] * (numbers[i] - 1) / 2; // 동일한 숫자가 들어 있는 그룹
        }

        System.out.println(ans);
    }
}
