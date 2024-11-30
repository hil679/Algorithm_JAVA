package org.example.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.abs;

public class P11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(bf.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        Map<Integer, Integer> numElems = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int num = Integer.valueOf(bf.readLine());
            if (num == 0) {
                if (maxHeap.isEmpty()) {
                    System.out.println(0);
                } else {
                    Integer pollNum = maxHeap.poll();
                    Integer negativePollNum = -pollNum;

                    /*
                    1. List add, remove -> 시간 초과
                    2. get만 하면 positive일 경우 map에 없을 때 runtime err
                    3. getOrDefault나 get은 return type이 valueType, 현재 integer => if문이 원하는 건 boolean
                       따라서 != 0 => 없으면 err
                     */
                    if (numElems.getOrDefault(negativePollNum, 0) != 0) {
                        System.out.println(negativePollNum);
                        numElems.put(negativePollNum, numElems.get(negativePollNum) - 1);
                    }
                    else
                        System.out.println(pollNum);
                }
            } else {
                maxHeap.offer(abs(num));
                if (num < 0)
                    numElems.put(num, numElems.getOrDefault(num, 0) + 1);
            }
        }
    }
}
