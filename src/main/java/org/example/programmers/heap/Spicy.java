package org.example.programmers.heap;
import java.util.*;
public class Spicy{
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
        int answer = 0;

        for(int s : scoville) {
            pqueue.offer(s);
        }

        // 하나 남으면 더이상 섞을 거 없음, 따라서 섞을 거 있을 떄까지 돌리는데 가장 작은게 K가 안된 경우에만 섞는 거 계속 진행
        while (pqueue.peek() < K && pqueue.size() != 1) {
            int smallest = pqueue.poll();
            int secondSmall = pqueue.poll();
            pqueue.offer(smallest + secondSmall * 2);
            answer++;
        }
        if(pqueue.size() == 1 && pqueue.peek() < K) //하나밖에 없는데 원하는 스코빌 지수 도달 못하면 -1
            return -1;

        return answer;
    }
}