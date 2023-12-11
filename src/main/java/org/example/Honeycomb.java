package org.example;

import java.util.Scanner;

public class Honeycomb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 1;
        while(n > 1) {
            n -= 6 * answer;
            answer++;
        }
        System.out.println(answer);
    }
}
