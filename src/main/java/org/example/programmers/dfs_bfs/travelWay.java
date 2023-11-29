package org.example.programmers.dfs_bfs;

import java.util.*;

class travelWay {

    static ArrayList<String> list = new ArrayList<>();
    static boolean useTickets[];

    public String[] solution(String[][] tickets) {
        useTickets = new boolean[tickets.length];

        dfs(0, "ICN", "ICN", tickets);

        Collections.sort(list);

        return list.get(0).split(" ");
    }

    static void dfs(int ticketNum, String now, String path, String[][] tickets){
        if (ticketNum == tickets.length) {
            list.add(path);
            return;
        }

        for (int i = 0; i < useTickets.length; i++) {
            if (!useTickets[i] && now.equals(tickets[i][0])) {
                useTickets[i] = true;
                dfs(ticketNum + 1, tickets[i][1], path + " " +tickets[i][1], tickets);
                useTickets[i] = false;
            }
        }
    }
}

//ex1)
//icn
//jfk -> i = 0: !useTickets[i] ==false, i = 1 -> now.equals(tickets[i][0]) == false
//    -> i = 2
//hnd -> i = 0, i = 1 // i = 2
//iad
