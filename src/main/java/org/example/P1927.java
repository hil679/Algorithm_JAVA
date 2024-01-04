package org.example;

import java.util.*;

public class P1927 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> numbers = new PriorityQueue<>(); //list로하면 시간 초과, priorityQueue이용
        StringBuilder sb = new StringBuilder();

        while(n > 0) {
            int num = sc.nextInt();
            n--;
            if (num == 0){
                if (numbers.isEmpty()) {
                    sb.append("0\n");
                    continue;
                }
                Integer min = numbers.poll();
                sb.append(min);
                sb.append("\n");
            } else{
                numbers.add(num);
            }
        }

        System.out.print(sb.toString());
    }
}
