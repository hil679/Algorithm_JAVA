package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P12919 {
    public static boolean isMatch = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        String s = br.readLine();

        dfs(s, target);

        if (isMatch) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    public static void dfs(String s, String target) {
        if (s.length() == target.length()) {
            if(target.equals(s)){
                isMatch = true;
            }
            return;
        }
        if (s.substring(s.length() - 1).equals("A")) {
            dfs(s.substring(0, s.length() - 1), target);
        }
        if (s.startsWith("B")){
            StringBuilder sb = new StringBuilder(s.substring(1)); // 속도: String < StringBuffer < StringBuilder
            dfs(sb.reverse().toString(), target);
        }
    }

}
