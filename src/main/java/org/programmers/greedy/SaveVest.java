package org.programmers.greedy;

import java.util.*;

public class SaveVest {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int light_person = 0;

        for (int heavy_person = people.length - 1; heavy_person >= light_person; heavy_person--) {
            if (people[heavy_person] + people[light_person] <= limit) {
                light_person++;
                answer++;
            }
            else {
                answer++;
            }
        }

        return answer;
    }
}