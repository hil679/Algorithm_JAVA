package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class P13302 {
    public static boolean schoolDay[] = new boolean [101];
    public static int dp[][] = new int [101][101];
    static int vacationDayNum;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        vacationDayNum = Integer.parseInt(st.nextToken());
        int schoolDayNum = Integer.parseInt(st.nextToken());
        if (schoolDayNum > 0) {
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < schoolDayNum; ++i) {
                schoolDay[Integer.parseInt(st.nextToken())] = true;
            }
        }
        for (int i = 0; i <= vacationDayNum; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(sol(1, 0));
    }
    static int sol(int day, int couponCnt) {
        if (day > vacationDayNum) return 0;
        int ret = dp[day][couponCnt];
        if (ret != -1) return ret;

        // 리조트에 갈 수 없는 날이면, 그냥 다음 날로 넘어감
        if (schoolDay[day]) {
            return ret = sol(day + 1, couponCnt);
        }

//        const int INF = 1e9;
        ret = Integer.MAX_VALUE;

        // 1일권
        ret = min(ret, 10000 + sol(day + 1, couponCnt));

        // 3일권 (+쿠폰 1장)
        ret = min(ret, 25000 + sol(day + 3, couponCnt + 1));

        // 5일권 (+쿠폰 2장)
        ret = min(ret, 37000 + sol(day + 5, couponCnt + 2));

        // 쿠폰 3장으로 하루 이용 (무료)
        if (couponCnt >= 3) {
            ret = min(ret, sol(day + 1, couponCnt - 3));
        }

        return  dp[day][couponCnt] = ret;
    }
}
