package org.example.programmers.greedy;
import java.util.*;
public class 두큐합같게만들기 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        // Integer[] queue1Int = Arrays.stream(queue1).boxed().toArray(Integer[]::new);
        // Integer[] queue2Int = Arrays.stream(queue2).boxed().toArray(Integer[]::new);
        Queue<Integer> q1 = generateQueue(queue1); //new LinkedList<>(Arrays.asList(queue1Int));
        Queue<Integer> q2 = generateQueue(queue2); //new LinkedList<>(Arrays.asList(queue2Int));

        long q1Sum = Arrays.stream(queue1).sum();
        long q2Sum = Arrays.stream(queue2).sum();
        long totalSum = q1Sum+q2Sum;

        if (totalSum % 2 == 1) return -1;

        //fail reason
        // for (int q : queue1) {
        //     if(q > (totalSum/2l)) return -1;
        // }
        // for (int q : queue2) {
        //     if(q > (totalSum/2)) return -1;
        // }


        // while(answer > 600000 || q1Sum != q2Sum){ //600000보다 더 많이 도는데 같지 않으면 없는 건데 계속 돌게 됨(시간초과)
        int q1Val = q1.poll();
        int q2Val = q2.poll();
        while(answer <= 600000) {
            if (q1Sum > q2Sum) {

                q2.add(q1Val);
                q1Sum -= q1Val;
                q2Sum += q1Val;
                answer++;
                q1Val = q1.poll();
            }
            else if (q1Sum < q2Sum) {
                q1Sum += q2Val;
                q2Sum -= q2Val;
                q1.add(q2Val);
                answer++;
                q2Val = q2.poll();
            } else {
                return answer;
            }

        }

        // return answer > 600000 ?  -1 : answer;
        return -1;
    }

    private Queue<Integer> generateQueue(int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        for (int i : arr) {
            q.add(i);
        }
        return q;
    }
}
