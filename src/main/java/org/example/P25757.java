package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class P25757 {
    public static final int F = 2;
    public static final int O = 3;

    public static void main(String[] args) throws IOException {
        Set<String> names = new HashSet<>(); //list로 contain확인하고 add하면 시간 초과
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] gameInfo = bf.readLine().split(" ");
        int n = Integer.valueOf(gameInfo[0]);

        //어차피 중복 안되니까 다 add하고 set에서 알아서 중복 저장하지 않음
        while (n > 0) {
            names.add(bf.readLine());
            n--;
        }

        //중복되지 않은 총 사람을 한 게임당 한께할 수 있는 사람의 수로 나눈 몫만큼 게임을 진행할 수 있다.
        if(gameInfo[1].equals("Y")) {
            System.out.println(names.size());
        } else if(gameInfo[1].equals("F")) {
            System.out.println(names.size() / F);
        } else if(gameInfo[1].equals("O")) {
            System.out.println(names.size() / O);
        }

    }
}
