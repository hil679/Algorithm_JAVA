package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P13549 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] loc = new int[100001]; // k + 1 사이즈로 하면 더 큰 숫자에서 -를 여러번 하는 경우에서 런타임에러가 난다.
        Arrays.fill(loc, -1); // 원래 초기화 기본값 0인 것은 -1로 바꾸기
        loc[n] = 0;
        if (n != k) {
            bfs(loc, n);
        }

        System.out.println(loc[k]);
    }

    public static void bfs(int[] loc, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        while(!queue.isEmpty()) {
            n = queue.poll();
            //간선의 길이가 다르기 때문에 현재값이 새로 구해진 시간값보다 크면 바꾸어야한다.
            int currentTime = loc[n];

            if (n - 1 >= 0 && loc[n - 1] > currentTime + 1) {
                queue.add(n - 1);
                loc[n - 1] = currentTime + 1;
            }
            if (n + 1 <= 100000 && loc[n + 1] > currentTime + 1) {
                queue.add(n + 1);
                loc[n + 1] = currentTime + 1;
            }
            if (n * 2 <= 100000 && loc[n * 2] > currentTime) {
                queue.add(n * 2);
                loc[n * 2] = currentTime;
            }
        }
    }
}
/*
둘 다 가능한 경우라면 당연히 BFS가 다익스트라보다 나을 수 밖에 없습니다.

BFS의 시간복잡도는 O(V+E)인 반면에 다익스트라는 O((V+E)logV)이니까요.

다만 그래프가 가중치가 있는 그래프가 된다면 BFS로는 최단거리를 구하기 불가능 해지는 경우들이 있고, 이를 해결하기 위해 다익스트라 알고리즘을 사용하면 됩니다.
 */