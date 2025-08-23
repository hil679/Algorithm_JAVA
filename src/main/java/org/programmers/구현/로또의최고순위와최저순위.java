package org.programmers.구현;

public class 로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {6, 6};
        int a = 0;
        int zeroCnt = 0;
        for (int lotto : lottos) {
            if (lotto == 0) zeroCnt++;
            else
                for (int win : win_nums) {
                    if (win == lotto) {
                        a++;
                        break;
                    }
                }
        }
        if (7 - (a) <= 5) {
            answer[1] = 7 - (a);
        }
        if (7 - (a+zeroCnt) <= 5) {
            answer[0] = 7 - (a+zeroCnt);
        }
        return answer;
    }
}
