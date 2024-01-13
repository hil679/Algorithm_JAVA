package org.example.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P20125 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int headX = -1;
        int headY = -1;
        StringBuilder result = new StringBuilder();

        //쿠키 정보 입력 받기
        String[][] cookie = new String[n][n];
        for(int i = 0; i < n; i++) {
            String line = bf.readLine();
            for(int j = 0; j < n; j++) {
                cookie[i][j] = line.substring(j, j+1);
            }
        }

        //find head
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(cookie[i][j].equals("*")) {
                    headY = i;
                    headX = j;
                    break;
                }
            }
            if(headY != -1) //첫 *이 head값이니까 값이 넣어지면 무조건 head
                break;
        }

        int heartX = headX;
        int heartY = headY + 1; // head바로 아래가 heart
        result.append(heartY + 1);
        result.append(" ");
        result.append(heartX + 1);
        result.append("\n");

        //find left arm
        int leftArm = 0;
        for(int i = 0; i < heartX; i++) {
            if(cookie[heartY][i].equals("*")) {
                leftArm = heartX - i;
                break;
            }
        }

        //find right arm
        int rightArm = 0;
        for(int i = n-1; i < n; i--) {
            if(cookie[heartY][i].equals("*")) {
                rightArm = i - heartX;
                break;
            }
        }

        //find back
        int back = 0;
        for(int i = heartY; i < n; i++) {
            if(cookie[i][heartX].equals("_")) {
                back = i - heartY - 1;
                break;
            }
        }

        //허리 끝 기준 양 옆에 아래에 다리가 있으니까 허리 끝 좌표 찾기
        int backEndX = heartX;
        int backEndY = heartY + back;

        //find left leg
        int leftLeg = 0;
        for(int i = backEndY + 1; i < n; i++) {
            if(cookie[i][backEndX - 1].equals("*")) {
                leftLeg++;
            }
        }
        //find right leg
        int rightLeg = 0;
        for(int i = backEndY + 1; i < n; i++) {
            if(cookie[i][backEndX + 1].equals("*")) {
                rightLeg++;
            }
        }

        result.append(leftArm + " " + rightArm + " " + back + " " + leftLeg + " " + rightLeg);
        System.out.println(result.toString());
    }

}
