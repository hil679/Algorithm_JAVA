package org.example.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int switchNum = Integer.valueOf(bf.readLine());
        int[] switches = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(s -> Integer.valueOf(s))
                .toArray();
        int studentNum = Integer.valueOf(bf.readLine());

        for(int i = 0; i < studentNum; i++) {
            int[] student = Arrays.stream(bf.readLine().split(" "))
                    .mapToInt(s -> Integer.valueOf(s))
                    .toArray();
            int studentSwitch = student[1];
            if(student[0] == 1) { // 남자일 때
                for(int j = 1; j * studentSwitch <= switchNum; j++) {
                    int changeSwitchIndex = j * studentSwitch - 1; // 배수일 때에서 1빼주기 -> 0번부터 배열이 시작하기 떄문
                    if(switches[changeSwitchIndex] == 1){ //스위치 상태 변경
                        switches[changeSwitchIndex] = 0;
                    } else {
                        switches[changeSwitchIndex] = 1;
                    }
                }
            } else{ //여자
                studentSwitch -= 1; //배열이 0부터 시작이라 1빼줌
                int studentSwitch_left = studentSwitch -1; // 부여받은 스위치 번호의 왼쪽
                int studentSwitch_right = studentSwitch + 1; // 부여받은 스위치 번호의 오른쪽
                if(switches[studentSwitch] == 1){ //여자는 부여받은 스위치 번호에서는 무조건 상태 변화
                    switches[studentSwitch] = 0;
                } else {
                    switches[studentSwitch] = 1;
                }
                while(studentSwitch_left >=0 &&  studentSwitch_right < switchNum) { // 스위치 상태 범위 확인 (index 벗어나면 안 됨)
                    if(switches[studentSwitch_left] == switches[studentSwitch_right]) { // 양쪽 스위치가 쌍으로 같을 때
                        if (switches[studentSwitch_left] == 1) { // 상태 변경
                            switches[studentSwitch_left] = 0;
                            switches[studentSwitch_right] = 0;
                        } else {
                            switches[studentSwitch_left] = 1;
                            switches[studentSwitch_right] = 1;
                        }
                        studentSwitch_left--; // 다시 각각 스위치 옆으로 이동해서 비교하려고
                        studentSwitch_right++;
                    } else
                        break; // 다르면 바로 반복문 빠져나오기
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int nextline = 0;
        for(int s : switches) {
            sb.append(s);
            sb.append(" ");
            nextline++;
            if(nextline == 20) { //21번째에서 다음 줄로 변경
                sb.append("\n");
                nextline = 0;
            }
        }
        System.out.println(sb.toString());
    }
}

