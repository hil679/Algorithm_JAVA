package org.example.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Stack;

public class P2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        HashMap<Integer, Integer> towers = new LinkedHashMap<>();
        int index = 1;
        for (String t : br.readLine().split(" ")) {
            towers.put(Integer.valueOf(t), index);
            index++;
        }
//        int[] towers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::new).toArray();
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int t : towers.keySet()) {
            if (stack.isEmpty()) {
                sb.append(0);
                sb.append(" ");
            }

            while (!stack.isEmpty()) {
                int peek = stack.peek();
                if (peek < t) {
                    stack.pop();
                    if(stack.isEmpty()){
                        sb.append(0);
                        sb.append(" ");
                    }
                } else {
                    sb.append(towers.get(peek));
                    sb.append(" ");
                    break;
                }
            }
            stack.push(t);
//            for (int k : stack) {
//                System.out.print(k);
//                System.out.println();
//            }

        }

        System.out.println(sb.toString());

    }
}
