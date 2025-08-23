package org.programmers.sort;
import java.util.*;

public class HIndex {
    public int solution(int[] citations) {
        int length = citations.length;
        Arrays.sort(citations);
        int answer = 0;
        int min = citations[0];
        int max = citations[length - 1];

        if(length == 1 && min == 0)
            return 0;
        else if(length == 1)
            return 1;

        if(length < min) // 9 7 6

            return length;


        for(int h = 0; h < max; h++) { // max / 2 도 통과
            int over = 0;
            for(int c : citations) {
                if(c >= h)
                    over++;
            }
            int under = length - over;
            if(over >= h && under <= h)
                answer = h;
        }
        return answer;

    }
}
