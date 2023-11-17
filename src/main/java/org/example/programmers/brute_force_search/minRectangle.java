package org.example.programmers.brute_force_search;

import java.util.*;

class minRectangle {
    public int solution(int[][] sizes) {
        List<Integer> mins = new ArrayList<>();
        int max = 0;

        for(int i = 0; i < sizes.length; i++) {
            int i_hor = sizes[i][0];
            int i_ver = sizes[i][1];

            if(i_hor < i_ver) {
                mins.add(i_hor);
                max = findMax(max, i_ver);
            } else {
                mins.add(i_ver);
                max = findMax(max, i_hor);
            }
        }

        return Collections.max(mins) * max;
    }

    public int findMax(int max, int comparison) {
        if(max < comparison)
            return comparison;
        return max;
    }
}
