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
                    for (int j = i + 1; j < length; i++) {
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
}
