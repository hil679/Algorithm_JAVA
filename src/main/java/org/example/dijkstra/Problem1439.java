package org.example.dijkstra;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem1439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        StringTokenizer st0 = new StringTokenizer(input, "1");//구분자 자체는 토큰으로 인식하지 않기 떄문에 1이 나오는 경우는 모두 제외됨
        //만약 1이 나오는 경우도 토큰으로 넣고 싶다면 (input, "0", true)
        StringTokenizer st1 = new StringTokenizer(input, "0");
        System.out.println(Math.min(st0.countTokens(), st1.countTokens()));
    }
}
