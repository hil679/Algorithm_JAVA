package org.example.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P6588 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.valueOf(bf.readLine());
        boolean prime[] = new boolean[1000001]; //소수가 0
        prime[0] = true;
        prime[1] = true;
        for (int i = 2; i < 1001; i++) {
//            1,000,000
            if (prime[i] == false) {
                for (int j = i * i; j < 1000001; j += i) {
                    prime[j] = true;
                }
            }
        }
        while (num != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(num);
            sb.append(" = ");
            int left = 3, right = num-3;
            while (left <= right) {
                if (!prime[left] && !prime[right]) {
                    break;
                }
                left++;
                right--;
            }
            sb.append(left);
            sb.append(" + ");
            sb.append(right);

            if (left > right) System.out.println("Goldbach's conjecture is wrong.");
            else System.out.println(sb.toString());

            num = Integer.valueOf(bf.readLine());
        }
    }
}
