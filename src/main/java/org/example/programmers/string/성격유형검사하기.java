package org.example.programmers.string;
import java.util.*;
public class 성격유형검사하기 {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int i = 0;
        HashMap<String, Integer> report = new HashMap<>();
        for (String s : survey) {
            String first = s.substring(0,1);
            String second = s.substring(1);
            if (choices[i] < 4) {
                report.put(first, report.getOrDefault(first, 0) + (4-choices[i]));
            } else if (choices[i] > 4) {
                report.put(second, report.getOrDefault(second, 0) + (choices[i]-4));
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(report.getOrDefault("T", 0) >report.getOrDefault("R", 0) ? "T" : "R");
        sb.append(report.getOrDefault("F", 0) >report.getOrDefault("C", 0) ? "F" : "C");
        sb.append(report.getOrDefault("M", 0) >report.getOrDefault("J", 0) ? "M" : "J");
        sb.append(report.getOrDefault("N", 0) >report.getOrDefault("A", 0) ? "N" : "A");
        return sb.toString();
    }
}
