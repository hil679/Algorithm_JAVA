package org.example.구현;

import java.util.Scanner;

/*
idea: 1. 크기 비교, 2. 삼각형 판단, 3. 어떤 삼각형인지 판단
 */
public class TriangleThreeSide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int max = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(max == 0 || b == 0 || c == 0)
                break;
            int temp;
            if(b > max){ // 크기 비교
                if(b > c) {
                    temp = max;
                    max = b;
                    b = temp;
                } else {
                    temp = max;
                    max = c;
                    c = temp;
                }
            } else if (c > max) {
                temp = max;
                max = c;
                c = temp;
            }

            if(max < b + c) {
                if(max == b && b == c) {
                    System.out.println("Equilateral");
                } else if(max != b && b != c && c != max){
                    System.out.println("Scalene");
                } else {
                    System.out.println("Isosceles");
                }
            } else {
                System.out.println("Invalid");
            }

        }
    }
}
