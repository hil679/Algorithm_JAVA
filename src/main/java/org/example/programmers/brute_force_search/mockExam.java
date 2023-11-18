package org.example.programmers.brute_force_search;

import java.util.*;

class mockExam {
    List<Integer> first = new ArrayList<>(List.of(1, 2, 3, 4, 5));
    List<Integer> second = List.of(2, 1, 2, 3, 2, 4, 2, 5);
    List<Integer> third = List.of(3, 3, 1, 1, 2, 2, 4, 4, 5, 5);
    Map<Integer, Integer> result = new HashMap<>();
    public int[] solution(int[] answers) {
        result.put(1, getAnswerNum(first, answers));
        result.put(2, getAnswerNum(second, answers));
        result.put(3, getAnswerNum(third, answers));

        int maxValue = Collections.max(result.values());
        List<Integer> maxStu = new ArrayList<>();

        for(int stu : result.keySet()) {
            if(result.get(stu) == maxValue)
                maxStu.add(stu);
        }

        int[] answer= new int[maxStu.size()];
        int cnt = 0;
        for(int stu : maxStu) {
            answer[cnt++] = stu;
        }
        return answer;
    }

    public int getAnswerNum(List<Integer> supoja, int[] answers) {
        int rightAnswerNum = 0;
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == supoja.get(i % supoja.size())){
                rightAnswerNum++;
            }
            System.out.print(answers[i]);
        }

        return rightAnswerNum;
    }
}