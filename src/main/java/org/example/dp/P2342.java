package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2342 {
    static int dp[][][] = new int [100001][5][5];
    //queue는 불가능, 재귀로 같은 element여러번 접근하기 때문
    static ArrayList<Integer> arr = new ArrayList<>();
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int number=Integer.parseInt(st.nextToken());

        arr.add(0);
        while (number != 0) {
            arr.add(number);
            number = Integer.valueOf(st.nextToken());
        }
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(ddr(0, 0, 0));
    }

    private static int ddr(int cur, int left, int right) {
        // 1 2 0
        // case1: 0,1,2(arr.size()=3) <-> case2: 1,2(arr.size()=2)
        /*
        case1: cur, next, arr.size(), arr.size()-1, arr.size()+1
        cur 0, next 1, 3 2 4
        cur 1, next 2, 3 2 4
        cur 2, next 3, 3 2 4 -> next에서 err, 2로 이동한 것에 대해서 계산은 cur 1에서 했고 멈추면 됨, next에서 err

        case2: cur, next, arr.size(), arr.size()-1, arr.size()+1
        cur 0, next 1, 2 1 3
        cur 1, next 2, 2 1 3
        cur 2, next 3, 2 1 3, cur 2 되자마자 더이상 진행 필요 없음, 나머지는  덜 진행 혹은 runtime err
         */
        if (cur+1 == arr.size()) {
            return 0;
        }

        if (dp[cur][left][right] != -1) return dp[cur][left][right];

        int next = arr.get(cur+1);
        int leftVal = INF;
        int rightVal = INF;

        if (next != right) {
            leftVal = ddr(cur + 1, next, right) + dist(left, next);
        }
        if (next != left) {
            rightVal = ddr(cur + 1, left, next) + dist(right, next);
        }

        return dp[cur][left][right] = Math.min(leftVal, rightVal);
    }

    private static int dist_fail(int cur, int next) {
        if (cur == next) return 1;
        else if (Math.abs(cur - next) == 2) return 4;
        else if (cur == 0) return 2; // 이게 먼저 나와야해
        else return 3;
    }
    private static int dist(int from, int to) {
        if (from == to) return 1;
        if (from == 0) return 2;
        if (Math.abs(from - to) == 2) return 4;
        return 3;
    }
}
