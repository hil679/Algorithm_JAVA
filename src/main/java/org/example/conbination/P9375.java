package org.example.conbination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(bf.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.valueOf(bf.readLine());
            Map<String, Integer> clothes = new HashMap<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
                String cloth = st.nextToken();
                String type = st.nextToken();
                if (clothes.containsKey(type))
                    clothes.put(type, clothes.get(type) + 1);
                else
                    clothes.put(type,2);
            }

            int cnt = 1;
            for(int c : clothes.values()) {
//                System.out.println(c);
                cnt *= c;
            }
            System.out.println(cnt - 1);
        }
    }
}
