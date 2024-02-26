package org.example.programmers.sort;
import java.util.*;

public class KNum {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx= 0;
        for(int[] c : commands) {
            int[] slicedArray = Arrays.copyOfRange(array, c[0] - 1, c[1]);
            Arrays.sort(slicedArray);
            // System.out.print(slicedArray[c[2] - 1]);
            answer[idx] = slicedArray[c[2] - 1];
            idx++;
        }
        return answer;
    }
}