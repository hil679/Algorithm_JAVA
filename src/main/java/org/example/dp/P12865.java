package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nk[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nk[0];
        int max_weight = nk[1];
        int weight[] = new int[n+1];
        int value[] = new int[n+1];
        int result[][] = new int[n+1][max_weight+1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= max_weight; i++) {
            int limitWeight = i;
            for (int j = 1; j <= n; j++) {
                if (limitWeight < weight[j]) {
                    result[j][i] = result[j-1][i]; // 현재 weight가 절대 못 들어감
                }else { // 단순히 물건 추가가 안 될 때
                    // 이전까지의 최대,
                    // 지금꺼 넣기 위해 이전 무게까지 고려한 result(j-1번째) 중에서
                    // (j-1번쨰, 지금 무게 빼고 남은 무게에 대한 value중 이전꺼까지 고려(지금꺼는 이제 넣을 꺼니까 j-1)했을 때 최대)
                    //
                    // 현재 넣을 무게 만큼 뺀 곳의 value + 현재 무게 value
                    result[j][i] = Math.max(result[j - 1][i], result[j-1][i - weight[j]] + value[j]);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <=max_weight; i++) {
            for (int j = 1; j <=n; j++) {
                if (max < result[j][i])
                    max = result[j][i];
            }
        }

        System.out.println(max);
    }
}
