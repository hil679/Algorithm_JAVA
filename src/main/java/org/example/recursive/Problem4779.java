package org.example.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Problem4779 {
    public static StringBuilder answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null){
            int num = (int) Math.pow(3, Integer.parseInt(str));
            answer = new StringBuilder();
            initAnswer(num);
            Cantorian(0, num);
            System.out.println(answer);
        }
    }
    public static void Cantorian(int start,int size) { //시작 인덱스, 문자열 사이즈
        if(size==1) { //문자열 사이즈가 1이되면 리턴
            return;
        }
        int newSize=size/3;
        // 3등분한 문자열의 2번째 부분 공백처리
        for(int i=start+newSize; i<start+2*newSize; i++) {
            answer.setCharAt(i, ' ');
        }
        Cantorian(start, newSize); // 3등분한 문자열에서 첫번째 부분
        Cantorian(start + 2 * newSize, newSize); // 3등분한 문자열의 세번째 부분,
        // start 더해주지 않으면 3등분한 마지막 거에서 뒤쪽 인덱스는 반영이 안 됨. ->
        // ex) 27 -> 9로 사이즈일 때 마지막 3등분은 start가 17인데 17에서 새 사이즈 3으로 두 번 더해져서 뒤쪽의 3등분의 가운데를 다시 없애야하는데 start안 하면 17 + 3*2를 시작점으로 하는 부분의 replace가 일어나지 않고 이미 앞에서 진행한 6을 start로 진행하게 됨
    }

    public static void initAnswer(int num){//string으로 return 시 memory 초과
        for(int i = 0; i < num; i++)
            answer.append("-");
    }
}
