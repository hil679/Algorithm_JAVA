package org.example.dijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem2012 { //자료형 -> int를 넘어갈 수 있다!
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long answer = 0;
        long peopleNum = sc.nextInt();

        List<Long> peopleRank = new ArrayList<>();
        for(long i = 0; i < peopleNum; i++){
            peopleRank.add(sc.nextLong());
        }
        peopleRank.sort(Long::compareTo);

        long index = 1;
        for(long rank : peopleRank){
            answer += Math.abs(index - rank);
            index++;
        }

        System.out.println(answer);
    }
}
