package org.programmers.dfs_bfs;

class targetNum {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);

        return answer;
    }


    public void dfs(int[]numbers, int target, int depth, int sum) {
        if(numbers.length == depth){
            if(sum == target) {
                answer++;
            }
        } else {
            dfs(numbers, target, depth + 1, sum + numbers[depth]);
            // number[4] 일 때 depth = 5 -> 마지막 원소로 답 추출
            dfs(numbers, target, depth + 1, sum - numbers[depth]);
        }
    }
}
