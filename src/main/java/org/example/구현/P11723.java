package org.example.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
/*
1. 입력에 대해 어떤 명령어에 해당하는지 확인하고
2. set이용
 */
public class P11723 {
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        int tryNum = Integer.valueOf(bf.readLine());

        while (tryNum > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            String order = st.nextToken();
            if (order.equals("add")) {
                int num = Integer.valueOf(st.nextToken());
                set.add(num); //add명령어인 경우 원소 추가(중복 시 무시)
            } else if (order.equals("remove")) {
                int num = Integer.valueOf(st.nextToken());
                set.remove(num); //remove 명령어인 경우 원소 제거(없을 시 무시)
            } else if (order.equals("check")) {
                int num = Integer.valueOf(st.nextToken());
                check(num, set); // 포함 시 1, 아니면 0
            } else if (order.equals("toggle")) {
                int num = Integer.valueOf(st.nextToken());
                toggle(num, set);
            } else if (order.equals("all")) {
                set.addAll(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
                // 원소에 추가, 1~20 추가하면서 있는 원소 무시
            } else {
                set.clear();
            }

            tryNum--;
        }
        System.out.println(sb.toString());
    }

    public static void check(int num, Set<Integer> set) {
        if (set.contains(num)) { // 포함하는지 확인
            sb.append(1);
            sb.append("\n");
        } else {
            sb.append(0);
            sb.append("\n");
        }
    }

    public static void toggle(int num, Set<Integer> set) {
        if (set.contains(num)) // 포함 시
            set.remove(num); // 삭제
        else // 아니면
            set.add(num); // 추가
    }

}
