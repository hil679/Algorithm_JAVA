package org.example.sort;

import java.util.*;

public class 위에서아래로 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i =0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        Collections.sort(list, Collections.reverseOrder()); // 역정렬
        System.out.println(list.toString());
    }
}
//3
//15
//27
//12