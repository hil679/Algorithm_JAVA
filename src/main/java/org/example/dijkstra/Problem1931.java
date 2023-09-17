package org.example.dijkstra;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem1931 {
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int meetingNum = sc.nextInt();
        List<List<Integer>> meetingTime= new ArrayList<>();

        for(int i = 0; i < meetingNum; i++){
            meetingTime.add(Stream.of(sc.nextInt(), sc.nextInt())//외우기
                    .collect(Collectors.toList()));
        }

        meetingTime.sort(Comparator.comparingInt(listElem -> listElem.get(0))); // 외우기, https://romcanrom.tistory.com/136


        List<List<Integer>> answerList = new ArrayList<>();
        answerList.add(meetingTime.get(0));
        for(int i = 1; i < meetingTime.size(); i++){
            List<Integer> newMeetingTime = meetingTime.get(i);
            List<Integer> answerListLastElem = answerList.get(answerList.size() -1);

            if (answerListLastElem.get(0) == newMeetingTime.get(0)
                    && answerListLastElem.get(0) == newMeetingTime.get(1)) {

                if(!answerListLastElem.contains(newMeetingTime))
                    answerList.add(newMeetingTime);
            }else if(answerListLastElem.get(1) > newMeetingTime.get(0) &&
                    answerListLastElem.get(1) > newMeetingTime.get(1)){//이 조건을 먼저 확인하게 되면 (5, 6)이 들어간 상태에서 (5, 5)가 추가만 되어야 하는데 삭제도 됨

                answerList.remove(answerList.size() -1);
                answerList.add(newMeetingTime);
            }else if(answerListLastElem.get(1) <= newMeetingTime.get(0)){//

                answerList.add(newMeetingTime);
            }
        }

        answer = answerList.size();
        System.out.println(answer);

    }
}