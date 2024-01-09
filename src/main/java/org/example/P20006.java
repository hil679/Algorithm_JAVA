package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P20006 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int playerNum = Integer.valueOf(st.nextToken());
        int roomLimit = Integer.valueOf(st.nextToken());
        HashMap<String, Integer> rest = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(int i = 0; i < playerNum; i++) {
            result.add(new ArrayList<>());
        }

        for(int i = 0; i < playerNum; i++) {
            String[] p = bf.readLine().split(" ");
            int currentLevel = Integer.valueOf(p[0]);
            rest.put(p[1], currentLevel);
            for(int j = 0; j < playerNum; j++) {
                if(result.get(j).size() == 0) {
                    result.get(j).add(p[1]);
                    break;
                } else if(result.get(j).size()< roomLimit
                        && currentLevel <= rest.get(result.get(j).get(0)) + 10
                && currentLevel >= rest.get(result.get(j).get(0)) - 10) {
                    result.get(j).add(p[1]);
                    break;
                }
            }
        }

        for(List<String> room : result) {
            if(room.size() == 0)
                break;
            else if(room.size() == roomLimit) {
                System.out.println("Started!");
            }else{
                System.out.println("Waiting!");
            }
            Collections.sort(room);
            for(String player : room) {
                System.out.println(rest.get(player) + " " + player);
            }
        }


    }
}
