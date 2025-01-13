package org.example.programmers.dp;
import java.util.*;
public class 산모양타일링 {
    public int solution(int n, int[] tops) {
        /*
        !!! 아래 방향 삼각형 기준으로 dp 나눠 줘야함
        삼각형은 아래 방향 삼각형 기준으로 4가지 케이스가 존재:
            1. 아래 방향 삼각형
            2. 왼쪽 위 방향 삼각형
            3. 위쪽 위 방향 삼각형(tops 정보)
            4. 오른쪽 위 방향 삼각형
         */
        int[] a = new int[n + 1]; // 오른쪽 윗방향 삼각형 덮는 경우의 수
        int[] b = new int[n + 1]; // 오른쪽 윗방향 제외 경우의 수
        int mod = 10007;

        a[0] = 0; // 오른쪽 윗방향 없음
        b[0] = 1; // 왼쪽 윗방향 1개
        for (int i = 1; i <= n; ++i) {
            a[i] = (a[i - 1] + b[i - 1]) % mod;
            //노트참고
            if (tops[i - 1] > 0)
                b[i] = (2 * a[i - 1] + 3 * b[i - 1]) % mod;
            else
                b[i] = (a[i - 1] + 2 * b[i - 1]) % mod;
        }

        return (a[n] + b[n]) % mod;
    }

    public int failSolution(int n, int[] tops) {
        int answer = 0;
        int topNum = (int)Arrays.stream(tops).filter(x -> x == 1).count(); // how to change int
        // only excepting top case(bottom case)
        int totalBottomTriangleNum = (n+1) + n;
        int[] cases = new int[totalBottomTriangleNum + 1];
        int[] topCases = new int[tops.length + 1];

        // System.out.print(topNum);
        cases[1] = 1;
        cases[2] = 2;
        // cases[3] = cases[2] + cases[1]; // 3
        // cases[4] = cases[3] + cases[2] -1 + cases[2]-1 ; // 5
        // cases[5] = cases[4] + cases[3]; // 8
        // cases[6] = cases[5] + cases[4]; // 13
        // cases[7] = cases[5] + cases[4]; // 21

        int i = 3;
        while(i <= (n + n+1)) {
            cases[i] = cases[i-1] + cases[i-2];
            // System.out.println(cases[i] % 10007);
            i++;
        }
        --i;

        int topCaseNum = 0;
        int betweenTriangle = 1;
        for (int j = 0; j < tops.length; j++) {
            int topSequence = 1;

            if (tops[j] == 1) {
                // topCases[j] = (cases[topSequence] * cases[totalBottomTriangleNum - topSequence - 1]);
                betweenTriangle = 1;
                topCaseNum += (cases[topSequence] * cases[totalBottomTriangleNum - topSequence - 1]);
            } else {
                betweenTriangle += 2;
            }
            topCases[j+1] = betweenTriangle;
            // System.out.println(topCases[j]);
            topSequence += 2;
        }

        return (cases[i] + topCaseNum) % 10007;
    }
}
