package org.programmers.brute_force_search;

public class Dictionary {
    public int solution(String word) {
        String str = "AEIOU";
        int[] cycle = {781,156,31,6,1};
        int index,result=word.length();
        for(int i=0;i<word.length();i++){
            index = str.indexOf(word.charAt(i));
            result+=cycle[i]*index;
        }
        return result;
    }
}


