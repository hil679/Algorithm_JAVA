package org.programmers.dfs_bfs;

public class Solution {
    static int answer = 0;
    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        dfs(0, numbers, 0, target);
        System.out.println("abc".substring(2, 3));

        System.out.println(answer);
    }
    public static void dfs(int current, int[] numbers, int depth, int target) {
        if(depth == numbers.length){
            if(current == target) // 조건문 한번에 작성하면 안됨. 그러면 길이가 같고 target이 아닐때 else를 실행하여 out of bound
                answer++;
        }else {
            System.out.println(depth);
            //따로하면 depth++ 참조로 전달되어 재귀할 때마다 depth올라가서 안됨(out of bounds)
            dfs(current + numbers[depth], numbers, depth + 1, target);
            dfs(current - numbers[depth], numbers, depth + 1, target);
        }
    }

//    class Solution {
//        int answer = 0;
//        public int solution(int[] numbers, int target) {
//
//            bfs(0, numbers, numbers[0], 0, target);
//            bfs(0, numbers, -numbers[0], 0, target);
//
//            return answer;
//        }
//
//        public void bfs(int current, int[] numbers, int number, int depth, int target) {
//            ++depth;
//            current += number;
//
//            if(depth == numbers.length){
//                if (current == target)
//                    answer++;
//            }else {
//                bfs(current, numbers, numbers[depth], depth, target);
//                bfs(current, numbers, -numbers[depth], depth, target);
//            }
//        }
//    }
}
