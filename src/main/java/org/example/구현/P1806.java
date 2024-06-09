package org.example.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.valueOf(bf.readLine().split(" ")[1]);
        int[] nums = Arrays.stream(bf.readLine().split(" ")) .mapToInt(Integer::new).toArray();

        int startPos = 0;
        int curPos = 0;
        int sum = 0;
        int curAns = 0;
        int ans = -1;
        int length = nums.length;

        while (startPos < length) {
            if (sum < target) {
                if (curPos >= length)
                    break;
                sum += nums[curPos];
                curPos++;
                curAns++;
            } else {
                if (ans == -1 || ans > curAns)
                    ans = curAns;
                curAns--;
                sum -= nums[startPos];
                startPos++;
            }
        }

        if (ans == -1)
            ans = 0;
        System.out.println(ans);
    }
}
