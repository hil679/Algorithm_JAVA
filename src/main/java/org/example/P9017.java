package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P9017 {
    static class Team implements Comparable<Team>{
        int memberNum;
        int score;
        int fiveMemberScore;

        public Team() {
            memberNum = 0;
            score = 0;
        }

        @Override
        public int compareTo(Team o) {
            if(this.score > o.score) {
                return 1;
            }
            else if(this.score == o.score) {
                if(this.fiveMemberScore > o.fiveMemberScore)
                    return 1;
                return 0;
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
        int score = 1;
        for(int i = 0; i < testcase; i++) {
            int n = Integer.valueOf(bf.readLine());
            String[] teams = bf.readLine().split(" ");
            Set<String> teamType = new HashSet<>(List.of(teams));
//            List<String> validTeam = new ArrayList<>();
            HashMap<String, Team> validTeam = new HashMap<>();

            for(String team : teamType) {
                if(Arrays.stream(teams).filter(t -> t.equals(team)).count() == 6){
                    validTeam.put(team, new Team());
                }
            }

            for(String team : teams) {
                if(validTeam.keySet().contains(team)) {
                    validTeam.get(team).memberNum++;
                    int memberNum = validTeam.get(team).memberNum;
                    if(memberNum <= 4) {
                        validTeam.get(team).score += score;
                        score++;
                    }
                    else if(memberNum == 5) {
                        validTeam.get(team).fiveMemberScore = score;
                        score++;
                    }
                }
            }

            validTeam.values().stream().sorted();
            sb.append(validTeam.keySet().toArray()[0]);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
