package org.example.programmers.brute_force_search;

public class 공원 {
    class Solution {
        public int solution(int[] mats, String[][] park) {
            // int k = 0;
            int answer = -1;
            for (int k = 0; k < mats.length; k++) {
                boolean possible = false;

                for (int i = 0; i < park.length; i++) {
                    if (possible) break;
                    if (park.length < i+mats[k]) break;

                    for (int j = 0; j < park[0].length; j++) {
                        if (possible) break;
                        if (park[0].length < j+mats[k]) break;

                        int r = i;
                        int c = j;
                        for (r = i; r < i+mats[k]; r++) {
                            boolean empty = true;
                            for (c = j; c < j+mats[k]; c++) {
                                if (!park[r][c].equals("-1")) {
                                    empty = false;
                                    break;
                                }
                            }
                            if (!empty)
                                break;
                            if (r == i+mats[k]-1)
                                possible = true;
                        }
                        // if (r == i+mats[k] && c == j+mats[k])
                        //     possible = true;
                    }
                }
                if (possible) {
                    answer = mats[k];
                    break;
                }

            }
            return answer;
        }
    }
//50 * 50 * (20* 20 *10) = 10,000,000 (천만)
}
