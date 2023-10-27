package org.example.hash;

import java.util.*;

public class programmersHashPhoneBook {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, List<String>> hm = new HashMap<>();

        for (String phone : phone_book) {
            String key = phone.substring(0, 1);
            if (!hm.containsKey(key))
                hm.put(key, new ArrayList<>());
            List<String> l = hm.get(key);
            l.add(phone);
            hm.put(key, l);
        }

        for (String key : hm.keySet()) {
            List<String> keyList = hm.get(key);
            Collections.sort(keyList, (String a, String b) -> a.length() - b.length());
            int length = keyList.size();
            if (length > 1) {
                for (int i = 0; i < length - 1; i++) {
                    String valueCreteria = keyList.get(i);
                    for (int j = i + 1; j < length; j++) {
                        if (keyList.get(j).substring(0, valueCreteria.length()).equals(valueCreteria)) {
                            answer = false;
                            break;
                        }
                    }
                    if (answer == false)
                        break;
                }
            }
            if (answer == false)
                break;
        }

        return answer;
    }

    public boolean solutio2(String[] phone_book) {
        Arrays.sort(phone_book, (String a, String b) -> a.length() - b.length());
        int length = phone_book.length;

        for (int i = 0; i < length -1; i++) {
            String valueCreteria = phone_book[i];
            int valueCreteriaLength = valueCreteria.length();
            for (int j = i + 1; j < length; j++) {
                if (phone_book[j].indexOf(valueCreteria) == 0) {//indexof와 substring 속도 차이
                    return false;
                }
            }
        }
        return true;
    }


    //정답
    public boolean solution3(String[] phone_book) {
        Arrays.sort(phone_book); //문자열 길이가 아니라 문자열을 int로 바꿨을 때 그 숫자의 크기대로 sort됨(사전순)
        //sort하면 phone_book[i]가 phone_book[i+1과 i+2]의 접두어일수는 있다.
        //그러나 phone_book[i+1]이 phone_book[i+2]의 접두어가 아닌데 phone_book[i]가 phone_book[i+2]의 접두어일 수는 없다.
        int length = phone_book.length;

        for (int i = 0; i < length - 1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) {//indexof와 substring 속도 차이
                return false;
            }
        }
        return true;
    }
}
