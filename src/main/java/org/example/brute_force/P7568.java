package org.example.brute_force;

import java.util.Scanner;
/*
* 키나 몸무게 둘 중 하나라도 같으면 덩치 비교가 안 된다는 것을 유의해야한다.

새로 학생이 들어올 때마다 기존 학생과 비교하며 순위를 변동한다.
무게를 비교하고 무게가 큰 학생이 키도 크다면 다른 학생의 순위를 높인다.
무게와 키, 둘 중의 하나라도 같거나 무게와 키가 엇갈려서 순위 비교가 안된다면 순위 변동은 없다.
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
                    if(s.height > students[j].height) { //새로운 학생의 키도 크다면
                        students[j].rank++; // 기존학생 등수 올리기
                    }
                } else if(s.weight < students[j].weight){ //이미 입력 받은 학생의 무게가 더 클 때
                    if(s.height < students[j].height) { // 기존 학생의 키도 크다면
                        s.rank++; // 새로운 학생 등수 올리기
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