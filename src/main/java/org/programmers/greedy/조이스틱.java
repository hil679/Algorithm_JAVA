package org.programmers.greedy;

public class 조이스틱 {
    public int solution(String name) {
        int answer = 0;
        //name -> charAt - 65
        int minMove = name.length() - 1; //오른쪽으로 다 이동할 때
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) <= 65 + 13) {
                // System.out.println((name.charAt(i)-65));
                answer += (name.charAt(i) - 65);
            } else
                answer += ('Z' - name.charAt(i) + 1);

            int next = i + 1;
            //연속 A만큼 이동(초기가 A라서 건들거 없기 때문)
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }
            minMove = Math.min(minMove, i + i + name.length() - next); //오른쪽으로만 이동, 오른쪽으로 A까지 이동(i : 지금까지 이동) + 다시 왼쪽으로 첫번째까지 이동(i) + (name.length()) - next(A + 앞에 알파벳 만큼)

            minMove = Math.min(minMove, i + 2 * (name.length() - next));//BBBAAAAAB 같은 케이스 ->뒤로 갔다가 다시 처음으로 돌아오는 경우가 더 빠른경우
        }
        answer += minMove;
        return answer;
    }
}
