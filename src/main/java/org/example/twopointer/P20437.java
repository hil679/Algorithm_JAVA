package org.example.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P20437 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            int k = Integer.parseInt(br.readLine());
            int alpha[] = new int[26];
            if (k == 1) {
                System.out.println("1 1");
                continue;
            }

            for (int j =0; j <s.length(); j++) {
                alpha[s.charAt(j)-'a']++;
            }

            int min = 10001, max = 0;
            for(int j = 0; j < s.length(); j++) {
                if (alpha[s.charAt(j)-'a'] < k) continue;
                int count = 1, kCnt = 1;
                for (int x = j+1; x < s.length(); x++) {
                    count++;
                    if (s.charAt(j) == s.charAt(x))
                    {
                        kCnt++;
                    }
                    if(kCnt == k) {
                        min = Math.min(count, min);
                        max = Math.max(count, max);
                        break;
                    }
                }
            }
            if (max == 0) {
                System.out.println(-1);
            } else {
                System.out.println(min+" "+max);
            }

        }
    }


    public static void prev1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            int k = Integer.parseInt(br.readLine());

            if(k == 1) {
                // k가 1일때 -> 이거 없으면 틀림
                // 아래에서 지금과 그 다음 문자부터 비교를 하기 때문에 1은 무조건 자기 자신임으로 따로 예외처리 필요
                System.out.println("1 1");
                continue;
            }

            int[] alpha = new int[26];//알파벳 별 개수를 저장한다.
            for(int j = 0; j < s.length(); j++) {
                alpha[s.charAt(j) - 'a']++;
            }
            int min = 10001;
            int max = -1;

            for(int j = 0; j < s.length(); j++) {
                if(alpha[s.charAt(j) - 'a'] < k) continue;

                int count = 1;
                for(int l = j + 1; l < s.length(); l++) {
                    if(s.charAt(j) == s.charAt(l)) count++;
                    if(count == k) {
                        min = Math.min(min, l - j + 1);
                        max = Math.max(max, l - j + 1);
                        break;
                    }
                }
            }

            if(min == 10001 || max == -1) System.out.println("-1");
            else System.out.println(min + " " + max);

        }
    }
}
