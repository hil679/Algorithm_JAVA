package org.example.programmers.string;
import java.util.*;
import java.util.stream.Collectors;

public class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> reportNum = new HashMap<>();
        HashMap<String, Set<String>> reportedPeople = new HashMap<>();

        for (String r : report) {
            String[] people = r.split(" ");
            reportedPeople.computeIfAbsent(people[1], key -> new HashSet<>());
            Set<String> set = reportedPeople.get(people[1]);
            set.add(people[0]);
            reportedPeople.put(people[1], set);
            // reportedPeople.put(people[1], reportedPeople.getOrDefault(people[1], new HashSet<>()).add(people[0]));
        }
        for (String id : id_list) {
            //만약 해당 id 신고자 수 >= k 이면, 신고한 사람 key의 value++
            if(!reportedPeople.containsKey(id)) continue;

            Set<String> set = reportedPeople.get(id);
            if(set.size() < k) continue;
            for (String s : set) {
                reportNum.put(s, reportNum.getOrDefault(s, 0) + 1);
            }
        }
        int i =0;
        for (String id : id_list) {
            //reportNum의 신고한 개수를 answer에 담아
            int n = reportNum.getOrDefault(id, 0);
            answer[i++] = n;
        }

        return answer;
    }

    public int[] ohterSolution(String[] id_list, String[] report, int k) {
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        HashMap<String, Integer> count = new HashMap<>(); // 신고 받은 사람 리스트
        for (String s : list) {
            String target = s.split(" ")[1];
            count.put(target, count.getOrDefault(target, 0) + 1);
        }

        return Arrays.stream(id_list).map(_user -> { //map -> 데이터 변형, _user -> id_list안 사람 String 하나씩
            final String user = _user;
            List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")) // 신고자에 대한 정보 모아서(mugi가 신고한 사람들)
                    .collect(Collectors.toList());//list로 만들고
            return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k) //mugi가 신고한 사람(s.split(" ")[1])이 신고 받은 수 >= k인 경우
                    .count(); //개수 반환
        }).mapToInt(Long::intValue).toArray();// stream api에서 return한 count()를 int배열로 변환후 반환
    }
}
