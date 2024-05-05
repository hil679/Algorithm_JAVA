package org.example.구현;

import java.util.Arrays;
import java.util.Scanner;

public class P21921 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        sc.nextLine();
        int[] people = Arrays.stream(sc.nextLine().split(" ")).mapToInt(i -> Integer.valueOf(i)).toArray();

        int temp = 0;
        for(int j = 0; j < x; j++) {
            temp += people[j];
        }
        int maxVisitNum = temp;
        int answer = 1;

        int prev = 0;
        for(int i = x; i < people.length; i++) {
            temp -= people[prev];
            temp += people[i];
            prev++;
            if(maxVisitNum < temp) {
                maxVisitNum = temp;
                answer = 1;
            } else if (maxVisitNum == temp) {
                answer++;
            }
        }


        if(maxVisitNum == 0){ // answer == 0이면 maxVisitNum = temp = 0일 때 answer가 +되면서 문제가 됨
            System.out.println("SAD");
        } else {
            System.out.println(maxVisitNum);
            System.out.println(answer);
        }
    }
}
