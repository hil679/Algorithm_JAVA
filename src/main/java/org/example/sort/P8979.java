package org.example.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
1. 메달 정보 입력 배열에 저장
2. 알고자하는 국가와 나머지 다른 국가의 각 메달 개수 비교
  2-1) 금의 개수가 많으면 result + 1
  2-2) 금의 개수가 같고, 은의 개수가 많으면 result + 1
  2-3) 은의 개수가 같고, 동의 개수가 많으면 result + 1
3. 알고자하는 국가보다 높은 순위의 국가의 개수가 result이기에 최종 result + 1을 한 값이 알고자하는 국가의 순위
 */
public class P8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] nationInfo = bf.readLine().split(" ");
        int n = Integer.valueOf(nationInfo[0]);
        int k = Integer.valueOf(nationInfo[1]);
        int[][] medals = new int[n + 1][4];
        int result = 0;

        for(int i = 1; i <= n; i++) { //각 국가 메달 정보 저장
            int[] medal = Arrays.stream(bf.readLine().split(" "))
                    .mapToInt(x -> Integer.valueOf(x)).toArray();
            medals[medal[0]] = new int[]{medal[1], medal[2], medal[3]}; // 국가의 번호에 해당하는 인덱스에 저장
        }

        for(int i = 1; i <= n; i++) {
            if(medals[k][0] < medals[i][0]) { // 금의 개수 비교
                result++;
            } else if (medals[k][0] == medals[i][0]) { // 금의 개수가 같다면
                if(medals[k][1] < medals[i][1]){ // 은의 개수 비교
                    result++;
                } else if (medals[k][1] == medals[i][1]) { // 은의 개수가 같다면
                    if(medals[k][2] < medals[i][2]){ // 동의 개수 비교
                        result++;
                    }
                }
            }
        }

        System.out.println(result + 1); // 최종 순위 출력
    }
}
