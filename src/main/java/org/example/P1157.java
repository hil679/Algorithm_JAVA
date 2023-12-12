package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class P1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        word = word.toUpperCase();

        HashMap<Character, Long> alphabets = new HashMap<>();
        long max = 0;
        char maxChar = 0;

        for(char c : word.toCharArray()) {
            if(alphabets.containsKey(c))
                continue;
            long cnt = word.chars().filter(character -> c == character).count();
            alphabets.put(c, cnt);

            if(cnt > max){
                max = cnt;
                maxChar = c;
            }
        }

        long cnt = 0;
        for(long i : alphabets.values()) {
            if(i == max) {
                cnt++;
                if(cnt > 1)
                    break;
            }
        }
        if(cnt == 1) {
            System.out.println(maxChar);
        } else {
            System.out.println("?");
        }

    }
}
