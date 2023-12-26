package org.example.sort;

import java.util.*;

public class 두배열의원소교체 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        Integer[] arr1 = new Integer[n];
        Integer[] arr2 = new Integer[n];

        for(int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }
        for(int i = 0; i < n; i++) {
            arr2[i] = scanner.nextInt();
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2, Collections.reverseOrder());

        for(int i = 0; i < k; i++) {
            arr1[i] = arr2[i];
        }

        int sum = Arrays.stream(arr1).reduce(0, (x, y) -> x + y);
        System.out.println(sum);
    }
}
