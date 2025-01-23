package org.example.programmers.구현;

import java.util.HashMap;

public class 다단계칫솔판매 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int tot = enroll.length;
        int[] answer = new int[tot];
        int hundred = 100;
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < tot; i++) {
            hm.put(enroll[i], i);
        }

        for (int i = 0; i < seller.length; i++) {
            String curNm = seller[i];
            int curAmount = amount[i] * hundred;
            while(curAmount != 0) {
                int nextAmount = (int)Math.floor(curAmount * 0.1);
                answer[hm.get(curNm)] += curAmount - nextAmount;
                curAmount = nextAmount;
                curNm = referral[hm.get(curNm)];
                if (curNm.equals("-")) break;
            }
        }

        return answer;
    }
}
