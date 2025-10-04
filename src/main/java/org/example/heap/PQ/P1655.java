package org.example.heap.PQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class P1655 {
    /*
     1, 5, 2, 10, -99, 7, 5
     1: 1
     1: 1 5
     2: 1 5 2
     2: 1 5 2 10
     2: -99 1 2 5 10
     2: -99 1 2 5 7 10
     5: -99 1 2 5 5 7 10
     */
//    100,000 * 10,000 = 1,000,000,000
    public static void main(String[] args) throws IOException {
        PriorityQueue <Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue <Integer> minHeap = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            if (minHeap.size() == maxHeap.size()) {
                maxHeap.add(number);
            } else {
                minHeap.add(number);
            }
            if (!minHeap.isEmpty()&&maxHeap.peek() > minHeap.peek()) {
                int maxPeek = maxHeap.poll();
                int minPeek = minHeap.poll();
                maxHeap.add(minPeek);
                minHeap.add(maxPeek);
            }
            System.out.println(maxHeap.peek());
        }
    }

}
