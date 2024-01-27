package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P9017 {
    static class Team implements Comparable<Team>{
        String name;
        int memberNum;
        int score;
        int fiveMemberScore;

        public Team(String name) {
            this.name = name;
            memberNum = 0;
            score = 0;
        }

        @Override
        public int compareTo(Team o) {
            if(this.score > o.score) {
                return 1;
            }
            else if(this.score == o.score) {
                if(this.fiveMemberScore > o.fiveMemberScore) // 5번째 선수의 점수가 적으면 정렬 앞으로
                    return 1;
                return -1;
            }
            else {
                return -1;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.valueOf(bf.readLine());

        for(int i = 0; i < testcase; i++) {
            int score = 1;
            int n = Integer.valueOf(bf.readLine());
            String[] teams = bf.readLine().split(" ");
            Set<String> teamType = new HashSet<>(List.of(teams));
            HashMap<String, Team> validTeam = new HashMap<>();

            for(String team : teamType) {
                if(Arrays.stream(teams).filter(t -> t.equals(team)).count() == 6 // 총 인원이 6명이고
                        && !validTeam.keySet().contains(team)){ // 타당한 자격인 팀인지 확인이 됐는가
                    validTeam.put(team, new Team(team));
                }
            }

            for(String team : teams) {
                if(validTeam.keySet().contains(team)) {
                    int memberNum = ++validTeam.get(team).memberNum;
                    if(memberNum <= 4) { // 4명까진 점수 더하기
                        validTeam.get(team).score += score;
//                        System.out.println(team + " " + validTeam.get(team).score);
                    }
                    else if(memberNum == 5) { // 5명은 점수 따로 저장, 정렬을 위해
                        validTeam.get(team).fiveMemberScore = score;
//                        System.out.println(memberNum + " " + team + " " + validTeam.get(team).fiveMemberScore);
                    }
                    score++;
                }
            }

            List<Team> sortedTeams = new ArrayList<>(validTeam.values());
            Collections.sort(sortedTeams); // 정렬
//            for(Team t: sortedTeams){
//                System.out.print(t.name);
//            }

            sb.append(sortedTeams.get(0).name); // 가장 첫번째 팀이 제일 빨리 들어온 팀
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
