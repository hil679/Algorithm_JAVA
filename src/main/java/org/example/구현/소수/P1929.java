package org.example.구현.소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1929 {
    static boolean[] isPrime;

    static void prime(int s,int e){
        isPrime = new boolean[e+1]; // N번째의 수 까지 받기위해 N+1까지 동적할당

        for(int i = 0; i < isPrime.length; i++){
            isPrime[i] = true; // boolean배열의 default값은 false이므로 true로 바꿔주기
        }
        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i <= Math.sqrt(e); i++){ // 2부터 n의 제곱근까지의 모든 수를 확인
            if(isPrime[i]){ // 해당수가 소수라면, 해당수를 제외한 배수들을 모두 false 처리하기
                for(int j = i*i; j<= e; j += i){//그 이하의 수는 모두 검사했으므로 i*i부터 시작
                    isPrime[j] = false;
                }
            }
        }
        for (int i = s; i <= e; i++) {
            if (isPrime[i])
                System.out.println(i);
        }
    } // isPrime_fun 함수 종료

    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int start = Integer.valueOf(st.nextToken());
        int end = Integer.valueOf(st.nextToken());
        prime(start, end);
    }
    //using sqrt(root)
    public static void main2(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int start = Integer.valueOf(st.nextToken());
        int end = Integer.valueOf(st.nextToken());

        for (int i = start; i <= end; i++) {
            if (i == 1) continue;
            boolean prime = true;
            for (int j = 2; j <= Math.round(Math.sqrt(i)); j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) System.out.println(i);
        }
    }
}
