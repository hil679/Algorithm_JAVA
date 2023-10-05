package org.example.recursive;

import java.util.Scanner;

public class Problem25501 {
    public static int recursiveNum = 0;
    public static int recursion(String s, int l, int r){
        recursiveNum++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();

        while(inputNum > 0){
            String input = sc.next();
            System.out.println(input + ": " + isPalindrome(input)+ " " + recursiveNum);
            recursiveNum = 0;
            inputNum--;
        }
    }
}
