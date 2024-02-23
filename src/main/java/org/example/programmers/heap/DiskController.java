package org.example.programmers.heap;

import java.util.*;

public class DiskController {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]-o2[0] != 0){
                    return o1[0]-o2[0]; // 시작 시간 오름 차순
                }else {
                    return o1[1]-o2[1]; // 시작 시간이 같으면 처리 시간 오름 차순
                }
            }
        });
        PriorityQueue<int[]> pqueue = new PriorityQueue<>((o1, o2) -> o1[1]- o2[1]);

        int start;
        int duration;
        int index = 1;

        pqueue.add(jobs[0]);
        int cur_time = jobs[0][0]; // 처음 시작 sec
        while(!pqueue.isEmpty()) {
            int[] job = pqueue.poll();
            start = job[0];
            duration = job[1];
            cur_time += duration;

            for(int i = index; i < jobs.length; i++) {
                if(jobs[i][0] <= cur_time){// 남은 job의 종료 시간이 현재 job의 시작 시간 보다 작or같다면
                    pqueue.add(jobs[i]);
                    index++;
                } else {
                    break;
                }
            }
            answer += (cur_time - start); // 요청부터 종료까지 걸린 시간
            // System.out.println(answer);

            if(index < jobs.length && pqueue.isEmpty()) { // 디스크 남았는데 대기 큐가 빈 경우
                pqueue.add(jobs[index]);
                cur_time = pqueue.peek()[0]; // 시작 시간까지 처리할 거 없기때문에 현재 시간 다음 잡 실행할 시작 시간으로 건너뜀 -> 여기서 넣는게 유일한 job이니까 그냥 여기서 cur_time 조정
                index++;
            }


        }
        return Integer.valueOf(answer / jobs.length);
    }
}

//cur job이 끝나기 전에 요청이 들어온 것 중에 제일 오래걸리는 것부터 실행
//job이 요청된 시간부터 해당 job이 끝나는 시점까지 걸린 시간을 answer에 더하기
//max heap -> priority queue 내림차순