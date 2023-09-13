package org.example.dijkstra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.List;

public class Problem11399 {//백준 제출 때는 Main으로 바꿔서 채점해야 함.
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int peopleNum = sc.nextInt();

        List<Integer> minuteList = new ArrayList<>();
        for(int i = 0; i < peopleNum; i++){
            minuteList.add(sc.nextInt());
        }
        minuteList.sort(Integer::compareTo);
        int mulNum = peopleNum;
        for(int i = 0; i < peopleNum; i++){
            answer += minuteList.get(i) * mulNum;
            mulNum--;
        }
        System.out.println(answer);
    }
}
