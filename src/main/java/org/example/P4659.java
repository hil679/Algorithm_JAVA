package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input;
        String ac = "<%s> is acceptable.\n";
        String notAc = "<%s> is not acceptable.\n";
        List<String> vowels = new ArrayList<>(List.of("a", "e", "i", "o", "u"));

        while(!(input = bf.readLine()).equals("end")){
            int vowelsNum = 0;
            int consonantsNum = 0;
            boolean threeContinuous = false;
            boolean hasNotVowel = true;
            boolean isDuplicate = false;

            for(int i = 0; i < input.length() - 1; i++) {
                String first = input.substring(i, i+1);
                String second = input.substring(i + 1, i+2);
                if(first.equals(second)){
                    if(!first.equals("e") && !first.equals("o")){
                        System.out.printf(notAc, input);
                        isDuplicate = true;
                        break;
                    }
                }
            }
            if(isDuplicate) {
                isDuplicate = false;
                continue;
            }

            for(int i = 0; i < input.length(); i++) {
                String first = input.substring(i, i+1);
                if(vowels.contains(first)){
                    hasNotVowel = false;
                    break;
                }
            }
            if(hasNotVowel){
                System.out.printf(notAc, input);
                continue;
            }

            for(int i = 0; i < input.length(); i++) {
                String s = input.substring(i, i+1);
                if(vowels.contains(s)){
                    vowelsNum++;
                    consonantsNum = 0;
                } else{
                    consonantsNum++;
                    vowelsNum = 0;
                }
                if(vowelsNum == 3 || consonantsNum == 3){
                    threeContinuous = true;
                    break;
                }
            }
            if(threeContinuous){
                System.out.printf(notAc, input);
                continue;
            }

            System.out.printf(ac, input);
        }
    }
}
