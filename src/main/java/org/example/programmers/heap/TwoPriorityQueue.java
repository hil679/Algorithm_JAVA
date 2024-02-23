package org.example.programmers.heap;
import java.util.*;

public class TwoPriorityQueue {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 오름차순 정렬
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int[] answer = {0, 0};

        for(String operation: operations) {
            StringTokenizer st = new StringTokenizer(operation);
            String cmd = st.nextToken();
            Integer data = Integer.valueOf(st.nextToken());
            if(cmd.equals("I")) {
                minHeap.offer(data);
                maxHeap.offer(data);
            } else {
                if(data.equals(1)) { // 최댓값 삭제
                    Integer removedNum = maxHeap.poll();
                    minHeap.remove(removedNum);
                } else { // 최솟값 삭제
                    Integer removedNum = minHeap.poll();
                    maxHeap.remove(removedNum);
                }
            }
        }
        if(!maxHeap.isEmpty())
            answer[0] = maxHeap.poll();
        if(!minHeap.isEmpty())
            answer[1] = minHeap.poll();
        return answer;
    }
}
