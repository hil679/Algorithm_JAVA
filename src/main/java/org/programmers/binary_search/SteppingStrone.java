package org.programmers.binary_search;

import java.util.*;
class SteppingStrone {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        Arrays.sort(rocks);

        int left = 1;
        int right = distance;
        while(left <= right){
            int mid = (left + right)/2;
            if(getRemovedRockNum(rocks, mid, distance) <= n){
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    public int getRemovedRockNum(int[] rocks, int mid, int distance){
        // mid가 바위(지점) 간 최소 거리가 되어야 함
        // 적어도 mid만큼 지점끼리의 최소거리를 두기 위해 하기 위해 제거 해야할 바위의 개수를 리턴한다.
        int before = 0;
        int end = distance;

        int removeCnt = 0;
        for(int i = 0; i < rocks.length; i++){
            if(rocks[i] - before < mid) {
                removeCnt++;
                continue;
            }
            before = rocks[i];
        }
        if(end - before < mid) removeCnt++;

        return removeCnt;
    }

}