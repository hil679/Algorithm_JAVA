package org.programmers.stack_queue;
import java.util.PriorityQueue;
import java.util.Collections;

public class Process {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순 정렬
        int answer = 0;

        for (int i : priorities) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                // 현재 작업의 위치 찾기
                if (queue.peek() == priorities[i]) {
                    queue.poll();
                    answer++; //[911111]2 3 4 5 -> [11] 0

                    // 현재 작업이 location과 같으면 answer 반환
                    if (location == i) { // 0 = 0
                        return answer; //5
                    }
                }
            }
        }

        return answer;
    }
}
