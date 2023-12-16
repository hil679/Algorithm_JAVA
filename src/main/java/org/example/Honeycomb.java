package org.example;

import java.util.Scanner;
/*
    외곽의 벌집이 늘어나는 개수 규칙을 구한다(등차수열)
    1, 6, 12... 이렇게 줄마다 개수를 구하면 a2부터 6씩 늘어난다.
 */
public class Honeycomb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 1; // 처음 시작 지점을 무조건 포함하기 위해 1부터 시작
        while(n > 1) { // 위에서 처음 시작 지점의 개수는 포함했음으로 처음 시작(1) 전까지 6n씩 빼가며 몇번의 줄을 넘어왔는지 확인
            n -= 6 * answer;
        }
        System.out.println(answer);
    }
}
