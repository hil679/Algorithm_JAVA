package org.example.programmers.brute_force_search;

class carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i = 1; i <= yellow; i++) {
            if(yellow % i == 0 && isRightBrownNum(yellow / i, i, brown)) {
                answer[0] = yellow / i + 2;
                answer[1] = i + 2;
                break;
            }
        }
        return answer;
    }

    public boolean isRightBrownNum(int yellow_h, int yellow_v, int brown) {
        return (yellow_h + yellow_v) * 2 + 4 == brown;
    }
}
