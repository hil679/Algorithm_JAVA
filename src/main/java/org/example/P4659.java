package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
문자열을 이용해 각 비민번호 조건을 확인한다.
 */
public class P4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input;
        String ac = "<%s> is acceptable.\n"; // acceptable
        String notAc = "<%s> is not acceptable.\n"; //not acceptable
        List<String> vowels = new ArrayList<>(List.of("a", "e", "i", "o", "u"));

        while(!(input = bf.readLine()).equals("end")){ // 비밀번호가 end이면 종료
            int vowelsNum = 0; // 연속된 모음의 개수 세기 위한 변수
            int consonantsNum = 0; // 연속된 자음의 개수 세기 위한 변수
            boolean threeContinuous = false; //연속된 모음 또는 자음의 개수가 3개 이상이면 true
            boolean hasNotVowel = true; //모음을 가지고 있다면 false
            boolean isDuplicate = false; // ee,oo 제외한 알파벳 2번 연속적이면 true

            for(int i = 0; i < input.length() - 1; i++) { //ee,oo 제외한 알파벳 2번 연속인지 확인
                String first = input.substring(i, i+1); // 첫 글자
                String second = input.substring(i + 1, i+2); // 다음 글자
                if(first.equals(second)){ // 앞 글자와 뒷 글자가 같을 때
                    if(!first.equals("e") && !first.equals("o")){ // e랑 o가 둘 다 아니라면
                        System.out.printf(notAc, input);//불가능 출력
                        isDuplicate = true; // 연속적, 중복임을 확인
                        break;
                    }
                }
            }
            if(isDuplicate) { //중복이면
                continue; // 다시 while
            }

            for(int i = 0; i < input.length(); i++) { //모음이 있는지 없는지 확인
                String first = input.substring(i, i+1); // 알파벳 하나씩 추출
                if(vowels.contains(first)){ // 모음 저장된 리스트에 포함이 되는지 확인
                    hasNotVowel = false; // 모음이 있다면 모음을 가지고 있지 않다는 변수에 false부여
                    break;
                }
            }
            if(hasNotVowel){ // 가지고 있지 않다면
                System.out.printf(notAc, input); //불가능 출력
                continue;
            }

            for(int i = 0; i < input.length(); i++) { // 모음 자음 연속적으로 각각 3번이상 나오는지 확인
                String s = input.substring(i, i+1);
                if(vowels.contains(s)){ // 모음이면
                    vowelsNum++; //모음 개수 +1
                    consonantsNum = 0; // 자음 연속 개수 리셋
                } else{ // 자음이면
                    consonantsNum++; //자음 개수 +1
                    vowelsNum = 0; // 모음 연속 개수 리셋
                }
                if(vowelsNum == 3 || consonantsNum == 3){ // 연속 개수 둘 중의 하나라도 3이면
                    threeContinuous = true; //3개 연속 조건 true
                    break;
                }
            }
            if(threeContinuous){ // 3개 연속이면(ture)
                System.out.printf(notAc, input); //불가능 출력
                continue;
            }

            System.out.printf(ac, input); // 위의 조건을 모두 넘어갔다면 가능한 비밀번호라는 의미
        }
    }
}
