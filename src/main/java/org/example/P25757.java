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

        while (n > 0) {
            names.add(bf.readLine());
            n--;
        }
        if(gameInfo[1].equals("Y")) {
            System.out.println(names.size());
        } else if(gameInfo[1].equals("F")) {
            System.out.println(names.size() / F);
        } else if(gameInfo[1].equals("O")) {
            System.out.println(names.size() / O);
        }

    }
}
