package org.example.programmers.hash;

import java.util.HashMap;
import java.util.Map;

class cloth {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> hm = new HashMap<>();

        for (String[] cloth : clothes) {
            hm.put(cloth[1], hm.getOrDefault(cloth[1], 1) + 1);
        }
        for(int v : hm.values()){
            answer *= v;
        }
        return answer - 1;
    }
}
