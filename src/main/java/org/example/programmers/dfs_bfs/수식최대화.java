package org.example.programmers.dfs_bfs;

import java.util.*;
public class 수식최대화 {
    static long answer = 0;
    public long solution(String expression) {
        StringTokenizer st = new StringTokenizer(expression, "*-+", true);
        List<Long> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        int[] visited = new int[3];
        int idx = 1;
        while (st.hasMoreTokens()) {
            if (idx %2 == 1)
                numbers.add(Long.valueOf(st.nextToken()));
            else
                operators.add(st.nextToken());
            idx++;
        }
        dfs(new ArrayList<>(numbers), new ArrayList<>(operators), "*", visited);
        visited = new int[3];
        dfs(new ArrayList<>(numbers), new ArrayList<>(operators), "+", visited);
        visited = new int[3];
        dfs(new ArrayList<>(numbers), new ArrayList<>(operators), "-", visited);
        return answer;
    }

    private void dfs(List<Long> numbers, List<String> operators, String curOper, int[] visited ) {

        if (numbers.size() == 1){
            answer = answer > Math.abs(numbers.get(0)) ? answer : Math.abs(numbers.get(0));
            System.out.println(numbers.get(0));
            return;
        }

        List<Long> newNumbers = new ArrayList<>(numbers);
        List<String> newOperators = new ArrayList<>(operators);
        if (curOper.equals("*")) {
            if (visited[0] == 1) return;
            int i = 0;
            while (i < newOperators.size()) {
                if (newOperators.get(i).equals(curOper)) {
                    newNumbers.add(i, newNumbers.get(i) * newNumbers.get(i+1));
                    newNumbers.remove(i+1);
                    newNumbers.remove(i+1);
                    newOperators.remove(i);
                    System.out.println(i + " " +newNumbers.get(i));
                } else {
                    i++;
                }
            }
            visited[0] = 1;
            int[] newVisited = visited.clone();
            dfs(new ArrayList<>(newNumbers), new ArrayList<>(newOperators), "+", visited);
            visited = newVisited;
            dfs(new ArrayList<>(newNumbers), new ArrayList<>(newOperators), "-", visited);
        } else if (curOper.equals("+")) {
            if (visited[1] == 1) return;

            int i = 0;
            while (i < newOperators.size()) {
                if (newOperators.get(i).equals(curOper)) {
                    newNumbers.add(i, newNumbers.get(i) + newNumbers.get(i+1));
                    newNumbers.remove(i+1);
                    newNumbers.remove(i+1);
                    newOperators.remove(i);
                    System.out.println(i + " " +newNumbers.get(i));
                } else {
                    i++;
                }
            }
            visited[1] = 1;
            int[] newVisited = visited.clone();
            dfs(new ArrayList<>(newNumbers), new ArrayList<>(newOperators), "*", visited);
            visited = newVisited;
            dfs(new ArrayList<>(newNumbers), new ArrayList<>(newOperators), "-", visited);
        } else if (curOper.equals("-")) {
            if (visited[2] == 1) return;

            int i = 0;
            while (i < newOperators.size()) {
                if (newOperators.get(i).equals(curOper)) {
                    newNumbers.add(i, newNumbers.get(i) - newNumbers.get(i+1));
                    newNumbers.remove(i+1);
                    newNumbers.remove(i+1);
                    newOperators.remove(i);
                    System.out.println("- "+i + " " +newNumbers.get(i));
                } else {
                    i++;
                }
            }
            visited[2] = 1;
            int[] newVisited = visited.clone();
            dfs(new ArrayList<>(newNumbers), new ArrayList<>(newOperators), "*", visited);
            visited = newVisited;
            dfs(new ArrayList<>(newNumbers), new ArrayList<>(newOperators), "+", visited);
        }
    }
}