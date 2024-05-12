package org.example.dp;

import java.util.Scanner;

public class P12919 {
    public static boolean isMatch = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String target = scanner.nextLine();

        dfs(s, target, "A");
        dfs(s, target, "B");

        if (isMatch) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    public static void dfs(String s, String target, String option) {
        StringBuilder sb = new StringBuilder(s); // 속도: String < StringBuffer < StringBuilder
        sb.append(option);
        String newString = sb.toString();
        if (option == "B") {
            newString = sb.reverse().toString();
        }
        if (newString.length() < target.length()) {
            dfs(newString, target, "A");
            dfs(newString, target, "B");
        } else if(target.equals(newString)){
            isMatch = true;
        }
    }

}
