package org.example.greedy;

import java.util.*;
public class P2138 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans1 = 1, ans2 = 0; // 0번째 바꾸니까 ans1은 1로 초기화
        String now = sc.next();
        String expect = sc.next();

        int[] now_0_on = new int[n];
        int[] now_0_off = new int[n];
        int[] target = new int[n];

        for(int i = 0; i < n; i++) {
            now_0_on[i] = now.charAt(i)-'0';
            now_0_off[i] = now.charAt(i)-'0';
            target[i] = expect.charAt(i)-'0';
        }
        now_0_on[0] = 1 - now_0_on[0]; // 0번째 전구 바꿈
        now_0_on[1] = 1 - now_0_on[1]; // 0번째 전구 바꾸면서 1번째 전구 바뀜

        for (int i = 1; i < n; i++) {
            if (now_0_on[i-1] != target[i-1]) {
                now_0_on[i-1] = 1 - now_0_on[i-1];
                now_0_on[i] = 1 - now_0_on[i];
                ans1++;
                if(i != n-1)
                    now_0_on[i+1] = 1 - now_0_on[i+1];

            }
            if(now_0_off[i-1] != target[i-1]) {
                now_0_off[i-1] = 1 - now_0_off[i-1];
                now_0_off[i] = 1 - now_0_off[i];
                ans2++;
                if(i != n-1)
                    now_0_off[i+1] = 1 - now_0_off[i+1];
            }
        }

        //마지막 n번째 비교
        if(now_0_on[n-1] != target[n-1])
            ans1 = -1;
        if(now_0_off[n-1] != target[n-1])
            ans2 = -1;

        if(ans1 == -1 && ans2 == -1)
            System.out.println(-1);
        else
            if (ans1 == -1)
                System.out.println(ans2);
            else if (ans2 == -1)
                System.out.println(ans1);
            else
                System.out.println(Math.min(ans1, ans2));
    }
}
