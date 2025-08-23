package org.programmers.greedy;

public class n플러스1카드게임 {
    public int solution(int coin, int[] cards) {
        int answer = 1;
        int n = cards.length;
        int mineIdx = n / 3;
        int[] mineCards = new int[n+1];
        int[] possibleCards = new int[n+1];
        int possible = 0;
        int i;
        //초기 카드 뭉치 n/3확인
        for (i = 0; i < mineIdx; i++) {
            mineCards[cards[i]] = 1;
            if (mineCards[(n + 1) - cards[i]] == 1) {
                possible++;
            }
        }
        do {
            if (mineIdx < n){
                if (coin  > 0 && mineCards[(n + 1) - cards[mineIdx]] == 1) {
                    coin--;
                    // mineCards[n - cards[mineIdx]] = -1;
                    // mineCards[cards[mineIdx]] = -1;
                    possible++;
                } else {
                    possibleCards[cards[mineIdx]] = 1;
                }

                mineIdx++;
                if (coin  > 0 && mineCards[(n + 1) - cards[mineIdx]] == 1) {
                    coin--;
                    possible++;
                } else {
                    possibleCards[cards[mineIdx]] = 1;
                }
                mineIdx++;

                if (possible <= 0 && coin > 1) {
                    for (int j = 1; j <= n / 2; j++) {
                        if (possibleCards[j] == 1 && possibleCards[(n + 1) - j] == 1) {
                            possibleCards[j] = -1;
                            possibleCards[(n + 1) - j] = -1;
                            coin -=2;
                            possible++;
                            break;
                        }
                    }
                }
            }
            possible--;
            if (possible >= 0) { // 마지막에 뽑은 것을 포함해도 불가능할 때 (n+1만들 수 없어 다음 라운드로 넘어갈 수 없음)
                answer++;
            } else {
                break;
            }


        } while(possible >= 0);

        return answer;
    }
}
