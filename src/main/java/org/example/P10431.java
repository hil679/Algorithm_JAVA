package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
버블 정렬
직전 학생보다 현재 학생이 더 작으면 무조건 위치를 바꾼다.
현재 학생을 제외하고 이미 앞에 세워진 학생들은 무조건 정렬이 된 상태이다.
따라서 내 앞에 있는 학생이 나보다 작다면 더이상 위치 교환을 멈춘다.
 */
public class P10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder();
        int answer = 0;

        for(int i = 1; i <= p; i++) {
            int[] students = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(s -> Integer.valueOf(s))
                    .toArray(); // 현재 테스트케이스 번호와 학생 키 정보 저장
            for(int j = 1; j < 20; j++) {
                for(int k = j; k > 0; k--) {
                    if(students[k] > students[k+1]) { //나보다 앞에 학생이 크면 자리 바꿈
                        int temp = students[k];
                        students[k] = students[k+1];
                        students[k+1] = temp;
                        answer++;
                    } else{ // 그렇지 않으면 자리 바꿈 중단
                        break;
                    }
                }
            }

            sb.append(students[0]);
            sb.append(" ");
            sb.append(answer);
            sb.append("\n"); // 바꾸는 횟수 출력
            answer = 0; // 바꾸는 횟수 초기화
        }

        System.out.println(sb.toString());
    }
}
