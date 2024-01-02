package org.example.brute_force;

import java.util.Scanner;
/*
키나 몸무게 둘 중 하나라도 같으면 덩치 비교가 안 된다는 것을 유의해야한다.
 */
public class P7568 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Student[] students = new Student[n];

        for(int i = 0; i < n; i ++) {
            Student s = new Student(scanner.nextInt(), scanner.nextInt());
            students[i] = s;
            for(int j = 0; j < i; j++) {
                if(s.weight > students[j].weight) { // 새로운 학생의 무게가 클 때
                    if(s.height > students[j].height) {
                        students[j].rank++;
                    }
                } else if(s.weight < students[j].weight){ //이미 입력 받은 학생의 무게가 더 클 때
                    if(s.height < students[j].height) {
                        s.rank++;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Student s : students) {
            sb.append(s.rank);
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }

    static class Student {
        int weight;
        int height;
        int rank;

        Student(int weight, int height) {
            this.weight = weight;
            this.height = height;
            rank = 1;
        }
    }
}


//88 186
//60 175
//58 183
//55 185
//46 155