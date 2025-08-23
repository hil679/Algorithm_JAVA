package org.programmers.string;
import java.util.*;

public class 숫자문자열과영단어 {
    //with HashMap
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        Map<String, String> number = new HashMap<>() {{
            put("zero", "0");
            put("one", "1");
            put("two", "2");
            put("three", "3");
            put("four", "4");
            put("five", "5");
            put("six", "6");
            put("seven", "7");
            put("eight", "8");
            put("nine", "9");
        }};
        for (int i = 0; i < s.length(); ) {
            if (Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
                i++;
            } else {
                if (number.containsKey(s.substring(i, i+3))) {
                    sb.append(number.get(s.substring(i, i+3)));
                    i += 3;
                }
                else if (number.containsKey(s.substring(i, i+4))) {
                    sb.append(number.get(s.substring(i, i+4)));
                    i += 4;
                }
                else if (number.containsKey(s.substring(i, i+5))) {
                    sb.append(number.get(s.substring(i, i+5)));
                    i += 5;
                }
            }

        }
        return Integer.parseInt(sb.toString());
    }

    //replaceAll
    public int otherSolution(String s) {
        String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i = 0; i < strArr.length; i++) {
            s = s.replaceAll(strArr[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}
