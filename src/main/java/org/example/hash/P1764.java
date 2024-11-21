package org.example.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
HashSet의 contains()는 O(1), ArrayList의 contains()는 O(n)
HashSet은 map을 기반으로 구현되고, ArrayList는 indexOf()를 사용해서 contain여부를 결정
처음에 ArrayList를 사용해서 시간초과가 났는데, 효율성이 필요한 문제라면 HashSet을 사용요함.
 */
public class P1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        HashSet<String> noListen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String name = bf.readLine();
            noListen.add(name);
        }

        List<String> noListenSee = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String name = bf.readLine();
            if (noListen.contains(name))
                noListenSee.add(name);
        }

        Collections.sort(noListenSee);
        StringBuilder sb = new StringBuilder();

        for (String name : noListenSee) {
            sb.append(name);
            sb.append('\n');

        }
        System.out.println(noListenSee.size());
        System.out.println(sb.toString());

    }
}
