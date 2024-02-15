package org.example.programmers.stack_queue;

import java.util.*;

public class truck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int cur_weight = 0;
        Queue<Integer> bridgeQueue = new LinkedList<>();

        for(int w : truck_weights) {
            while(true) {
                // 다리위에 트럭 없음
                if(bridgeQueue.isEmpty()) {
                    bridgeQueue.add(w);
                    cur_weight += w;
                    time++; // 다리에 오를 때 시간 추가
                    break;
                } else if(bridgeQueue.size() == bridge_length) { // 큐에 다리 길이만큼 트럭이 다 찬 경우
                    cur_weight -= bridgeQueue.poll();
                } else  { // 다리 길이만큼 큐가 차지않았음
                    // weight 값을 넘지 않았다면 트럭 다리에 올라감
                    if(cur_weight + w <= weight) {
                        bridgeQueue.add(w);
                        cur_weight += w;
                        time++;
                        break;
                    } else {
                        // 넘는다면 0을 넣어 이미 큐에 있는 트럭이 다리를 건너게 함
                        bridgeQueue.add(0);
                        time++;
                    }
                }
            }

        }
        return time + bridge_length;
    }
}
