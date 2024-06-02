package org.example.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P22251 {
    //    static int[][] numbers = {
//            {1, 1, 1, 1, 1, 1, 0},
//            {0, 1, 1, 0, 0, 0, 0},
//            {1, 1, 0, 1, 1, 0, 0},
//            {1, 1, 1, 1, 0, 0, 1},
//            {0, 1, 1, 0, 0, 1, 1},
//            {1, 0, 1, 1, 0, 1, 0},
//            {1, 0, 1, 1, 1, 1, 1},
//            {1, 1, 1, 0, 0, 1, 0},
//            {1, 1, 1, 1, 1, 1, 1},
//            {1, 1, 1, 1, 0, 1, 1}
//    };
    static int[][] numbers = {{1, 1, 1, 0, 1, 1, 1}, //0
            {0, 0, 1, 0, 0, 0, 1}, //1
            {0, 1, 1, 1, 1, 1, 0}, //2
            {0, 1, 1, 1, 0, 1, 1}, //3
            {1, 0, 1, 1, 0, 0, 1}, //4
            {1, 1, 0, 1, 0, 1, 1}, //5
            {1, 1, 0, 1, 1, 1, 1}, //6
            {0, 1, 1, 0, 0, 0, 1}, //7
            {1, 1, 1, 1, 1, 1, 1}, //8
            {1, 1, 1, 1, 0, 1, 1}}; //9
    public static int count = 0;
    public static int maxFloor, digit, reversal, currentFloor;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        maxFloor = Integer.valueOf(st.nextToken()); //N
        digit = Integer.valueOf(st.nextToken()); //K
        reversal = Integer.valueOf(st.nextToken()); //P
        currentFloor = Integer.valueOf(st.nextToken()); //X

        int[] current = new int[digit + 1];
        int x = currentFloor;
        for (int i = digit; i >= 1; i--) {
            current[i] = x % 10;
            x = x / 10;
        }

        for (int i = 1; i <= maxFloor; i++) { //maxFloor범위까지 완탐
            if (i == currentFloor)
                continue;
            if (change(i, current)) {
//                System.out.println(i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean change(int target, int[] current) {
        int[] targets = new int[digit + 1];
        for (int i = digit; i >= 1; i--) {
            targets[i] = target % 10;
            target = target / 10;
        }

        int diff = 0;
        int digitBar = 6;
        for (int i = 1; i <= digit; i++) {//한 자리 수씩 확인
            for (int j = 0; j <= digitBar; j++) {// 세그먼트 탐색
                if (Math.abs(numbers[targets[i]][j] - numbers[current[i]][j]) == 1) {//타겟과의 세그먼트비교하여 몇개 차이나는지 확인
                    diff++;
                }
                if (diff > reversal)
                    return false;
            }
        }
        return true;
    }
}
