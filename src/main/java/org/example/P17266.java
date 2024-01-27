package org.example;

import java.util.Scanner;

public class P17266 {
    static int[] arr;
    static int m,n;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n =sc.nextInt();
        m =sc.nextInt();
        arr = new int[m];

        for(int i = 0; i < m; i++) { // 가로등이 설치된 지점 입력 받기
            arr[i] = sc.nextInt();
        }

        int left = 1;
        int right = n;
        int result = 0;

        while(left <= right) {
            int mid = (left + right) / 2;
                    // mid 높이로 모든 지점을 비출 수 있다면 result 갱신 후 높이를 줄여 재탐색
            if(possible(mid)) {
                result = mid;
                right = mid - 1;
            }
                    // 모든 지점을 비출 수 없다면 높이를 높여 재탐색
            else
                left = mid + 1;
        }
        System.out.println(result);
    }
    static boolean possible(int height) {
        //0 - 10, 2 4, 5
        int prev = 0; // 이전 가로등이 비춘 마지막 지점, 0 지점부터 모두 비춰주어야 하기 때문에 0부터 시작

        for(int i = 0; i < arr.length; i++) { // 모든 가로등 범위 확인 필요하기 때문에 전체 가로등 설치 폭 순회
                    /*
                     * 가로등이 있는 지점에서 비출 수 있는 높이(target)을 빼면 가로등이 비추는 최소값을 알 수가 있습니다.
                     */
            if(arr[i] - height <= prev) { // 비출 수 있는 끝 지점 <= 이전에 비췄던 최대 끝 지점
                prev = arr[i] + height; // arr[i] + target을 하게되면 가로등이 다시 비춰야만 하는 최소값
            } else {
                return false;
            }
        }
        return n - prev <= 0;
        //마지막 지점(n)도 가로등이 비출 수 있는지 확인 필요
        // 비춰야 하는 끝 지점 - 비출 수 있는 끝 지점 <= 0 ( 비출 수 있는 끝 범위가 더 커야하니까)
    }
}
