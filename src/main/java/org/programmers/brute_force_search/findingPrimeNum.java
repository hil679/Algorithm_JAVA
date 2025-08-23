package org.programmers.brute_force_search;

import java.util.*;

class findingPrimeNum {
    Set<Integer> allNumbers = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;

        rec("", numbers);

        for(int num : allNumbers) {
            if(isPrime(num))
                answer++;
        }
        return answer;
    }

    public boolean isPrime(int num) {
        if(num == 0 || num == 1) return false;
        for(int i = 2; i <= num / 2 ; i++) { // i <= num / 2 + 1 -> 반례 2
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }


    public void rec (String temp, String n) {
        if(!temp.equals("")) {
            // System.out.print(temp + " ");
            allNumbers.add(Integer.parseInt(temp));
        }

        for (int i = 0; i < n.length(); i++) {
            rec(temp + n.charAt(i), n.substring(0, i) + n.substring(i + 1)); //i번째 숫자만 빼면서 조합
        }
    }

    //"", 17
    //1, 7 -> 1(i=0까지)
    //17, "" -> 17, n = ""니까 for x
    //7, 1 -> 7
    //71, "" -> 71
}
