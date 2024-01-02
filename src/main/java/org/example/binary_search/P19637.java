package org.example.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder(); // 반복 print는 시간 초과 일으킬 수 있음 -> 따라서 StringBuilder로 합쳐서 한번에 출력
        int powerLevelNum = Integer.valueOf(st.nextToken());
        int characterNum = Integer.valueOf(st.nextToken());

        Power[] levels = new Power[powerLevelNum];

        for(int i = 0; i < powerLevelNum; i++) {
            st = new StringTokenizer(bf.readLine());
            levels[i] = new Power(st.nextToken(), Long.valueOf(st.nextToken()));

        }

        while(characterNum > 0){
            long power = Long.valueOf(bf.readLine());
            int start = 0;
            int last = powerLevelNum - 1;
            while (start <= last) {
                int mid = (start + last) / 2;
                if(power > levels[mid].level) {
                    start = mid + 1;
                } else {
                    last = mid - 1; // mid - 1?
                    // 100 200 300 400 500 600   [440]
                    // 2 (start = 3) -> 4 (last = 4,3) -> 3
                }
            }
            sb.append(levels[start].title + "\n");
            characterNum--;
        }
        System.out.print(sb.toString());
    }

    public static class Power{
        Long level;
        String title;

        Power(String title, Long level) {
            this.level = level;
            this.title = title;
        }
    }
}


