package org.example.구현;

import java.util.ArrayList;
import java.util.Scanner;

public class P24337 {

    static ArrayList<Integer> building;
    static int n, a, b;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();

        building = new ArrayList<>();

        if (a + b > n + 1) {
            System.out.print(-1);
            return;
        }

        for (int i = 1; i < a; i++) {
            building.add(i);
        }
        building.add(Math.max(a, b));

        for (int i = b - 1; i >= 1; i--) {
            building.add(i);
        }

        while (building.size() < n) {
            building.add(1, 1);
        }

        for (int i : building) {
            System.out.print(i + " ");
        }
    }
}
