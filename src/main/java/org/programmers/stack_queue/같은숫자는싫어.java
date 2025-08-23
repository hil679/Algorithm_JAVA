package org.programmers.stack_queue;

import java.util.*;
public class 같은숫자는싫어 {
    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();

        int prev = -1;
        int i = 0;
        for (int a : arr) {
            if(prev != a) {
                answer.add(a);
                prev = a;
                i++;
            }
        }


        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public Stack<Integer> otherSolution(int []arr) {

        Stack<Integer> stack = new Stack<>();

        for(int num : arr){
            if(stack.size() == 0 || stack.peek() != num){
                stack.push(num);
            }
        }



        return stack;
    }
}
