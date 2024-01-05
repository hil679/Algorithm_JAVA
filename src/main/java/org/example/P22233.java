package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class P22233 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = bf.readLine().split(" ");
        int n = Integer.valueOf(nums[0]);
        int m = Integer.valueOf(nums[1]);
        Set<String> notes = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        while(n > 0) {
            notes.add(bf.readLine());
            n--;
        }

        while(m > 0) {
            String[] useKeywords = {bf.readLine()};
            if(useKeywords[0].contains(",")) {
                useKeywords = useKeywords[0].split(",");
            }
            for(String keyword : useKeywords) {
                if(notes.contains(keyword)) {
                    notes.remove(keyword);
                }
            }
            sb.append(notes.size());
            sb.append("\n");
            m--;
        }

        System.out.print(sb.toString());
    }
}
