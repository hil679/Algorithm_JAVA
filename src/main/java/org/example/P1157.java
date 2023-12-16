package org.example;

import java.util.HashMap;
import java.util.Scanner;
/*
    1. 무조건 대문자로 만든다.
    2. 단어의 알파벳을 순회하여 개수를 센다. 이때 가장 많이 나온 알파벳과 알파벳 개수를 업데이트한다.
    3. map에서 value값(나온 각 알파벳 개수)을 순회하며 max값이 중복되는지 확인한다.
    4. max값의 개수가 1이상이면 ?, 아니면 변수에 저장해둔 max알파벳을 출력한다.
 */
public class P1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        word = word.toUpperCase(); // 대문자로 바꾸기

        HashMap<Character, Long> alphabets = new HashMap<>();
        long max = 0; //최댓값
        char maxChar = 0; //최댓값에 해당하는 알파벳

        for(char c : word.toCharArray()) {
            if(alphabets.containsKey(c)) // 이미 개수 센 알파벳이면 넘김
                continue;
            long cnt = word.chars().filter(character -> c == character).count(); // 알파벳 개수 세기
            alphabets.put(c, cnt); // 알파벳과 나온 개수 저장

            if(cnt > max){ // 새로운 알파벳의 개수와 기존 max알파벳 개수 비교 후 업데이트
                max = cnt;
                maxChar = c;
            }
        }

        long cnt = 0;
        for(long i : alphabets.values()) { //map에서 value값(나온 각 알파벳 개수)을 순회하며 max값이 중복되는지 확인
            if(i == max) {
                cnt++;
                if(cnt > 1)
                    break;
            }
        }
        if(cnt == 1) { //  max값의 개수가 1이면 변수에 저장해둔 max알파벳을 출력
            System.out.println(maxChar);
        } else { // max값의 개수가 1이상이면 ?
            System.out.println("?");
        }

    }
}
