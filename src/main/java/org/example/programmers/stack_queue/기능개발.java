package org.example.programmers.stack_queue;
import java.util.*;
public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int working = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0)
                working++;
            q.add(working);
        }

        int max = q.poll();
        int result = 1;
        List<Integer> answer = new ArrayList<>();
        while (!q.isEmpty()) {
            int distribution = q.poll();
            if (max < distribution) {
                max = distribution;
                answer.add(result);
                result = 1;
            } else {
                result++;
            }
        }
        answer.add(result);
        // 7 4 9
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
