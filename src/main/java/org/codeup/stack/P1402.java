package org.codeup.stack;
import java.util.*;
import java.io.*;
public class P1402 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> s = new Stack<>();
        while(st.hasMoreTokens()) {
            s.push(Integer.parseInt(st.nextToken()));
        }
        while(!s.isEmpty()) {
            System.out.print(s.pop()+ " ");

        }
    }
}
