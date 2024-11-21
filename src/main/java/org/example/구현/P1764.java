package org.example.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        List<String> noListen = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = bf.readLine();
            if (!noListen.contains(name))
                noListen.add(name);
        }
        noListen.stream().sorted();

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String name = bf.readLine();
            if (noListen.contains(name)) {
                cnt++;
                sb.append(name);
                sb.append('\n');
            }
        }
        System.out.println(cnt);
        System.out.println(sb.toString());

    }
}
