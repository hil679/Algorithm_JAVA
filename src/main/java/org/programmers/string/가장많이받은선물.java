package org.programmers.string;
import java.util.*;
public class 가장많이받은선물 {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        HashMap<String, Integer> friendIdx = new HashMap<String, Integer>();
        int[] results = new int[friends.length];

        for(int i =0; i < friends.length; i++) {
            friendIdx.put(friends[i], i);
        }

        int[][] giftState = new int[friends.length][friends.length];
        for (String gift : gifts) {
            String[] info = gift.split(" ");
            int from = friendIdx.get(info[0]);
            int to = friendIdx.get(info[1]);
            giftState[from][to] += 1;
        }

        int[] giftIndex = new int[friends.length];
        for(int i =0; i < friends.length; i++) {
            int giving = Arrays.stream(giftState[i]).sum();
            int reciving = 0;
            for(int j =0; j < friends.length; j++) {
                reciving += giftState[j][i];
            }
            giftIndex[i] = giving - reciving;;
        }
        for(int i =0; i < friends.length; i++) {
            for(int j = i; j < friends.length; j++) { // 0부터하면 2번 중복
                if (i == j) continue;

                if (giftState[i][j] > giftState[j][i]) {
                    results[i]++;
                } else if (giftState[i][j] < giftState[j][i]) {
                    results[j]++;
                } else {
                    if (giftIndex[i] > giftIndex[j])
                        results[i]++;
                    else if (giftIndex[i] < giftIndex[j])
                        results[j]++;
                }
            }
        }

        return Arrays.stream(results).max().getAsInt();
        // return Arrays.stream(results).max().getAsInt() /2;
    }
}
