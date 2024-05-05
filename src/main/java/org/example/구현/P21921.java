package org.example.구현;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class P21921 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        sc.nextLine();
        int[] people = Arrays.stream(sc.nextLine().split(" ")).mapToInt(i -> Integer.valueOf(i)).toArray();

        int maxVisitNum = 0;
        int temp = 0;
        int answer = 0;

        for(int i = 0; i + x <= people.length; i++) {
            for(int j = i; j < i + x; j++) {
                temp += people[j];
            }
            if(maxVisitNum > temp) {
                temp = 0;
                continue;
            } else if (maxVisitNum == temp) {
                answer++;
            } else {
                maxVisitNum = temp;
                answer = 1;
            }
            temp = 0;
        }


        if(answer == 0){
            System.out.println("SAD");
        } else {
            System.out.println(maxVisitNum);
            System.out.println(answer);
        }
    }
}
