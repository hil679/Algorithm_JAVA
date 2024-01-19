package org.example;

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
            if(student[0] == 0) {
                for(int j = 1; j * studentSwitch <= switchNum; j++) {
                    int changeSwitchIndex = j * studentSwitch;
                    if(switches[changeSwitchIndex] == 1){
                        switches[changeSwitchIndex] = 0;
                    } else {
                        switches[changeSwitchIndex] = 1;
                    }
                }
            } else{
                int studentSwitch_left = studentSwitch -1;
                int studentSwitch_right = studentSwitch + 1;
                if(switches[studentSwitch] == 1){
                    switches[studentSwitch] = 0;
                } else {
                    switches[studentSwitch] = 1;
                }
                while(studentSwitch_left >=1 &&  studentSwitch_right<= switchNum) {
                    if(switches[studentSwitch_left] == switches[studentSwitch_right]) {
                        if (switches[studentSwitch_left] == 1) {
                            switches[studentSwitch_left] = 0;
                            switches[studentSwitch_right] = 0;
                        } else {
                            switches[studentSwitch_left] = 1;
                            switches[studentSwitch_right] = 1;
                        }
                        studentSwitch_left--;
                        studentSwitch_right++;
                    } else
                        break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int nextline = 1;
        for(int s : switches) {
            sb.append(s);
            sb.append(" ");
            nextline++;
            if(nextline == 20) {
                sb.append("\n");
                nextline = 0;
            }
        }
        System.out.println(sb.toString());
    }
}

