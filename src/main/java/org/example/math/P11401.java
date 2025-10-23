package org.example.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
페르마의 소정리
모듈러 연산에서 덧셈(+), 곱셈(×), (-)은 분배법칙이 성립하고, 나눗셈(/)은 안 됩니다.
a는 정수, p는 소수, a % p != 0이면,
(a^p) % p = a % p
(a^(p-1)) % p = 1 % p // 양변을 a로 나눔
=> (a^(p-2)) % p = a^(-1) % p // 양변을 a로 나눔
=> a%p: 원소, 1%p: 항등원, a^(p-2)%p: a의 역원

p = 1,000,000,007
(n!/(n-c)!c!) % p
=[{ (n!) % p } * {((n-c)!c!)^(-1) % p} ] % p // (n-c)!c! = a
=[{ (n!) % p } * {((n-c)!c!)^(p-2) % p} ] % p
 */
public class P11401 {
    final static long P = 1000000007;
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.valueOf(st.nextToken());
        long c = Long.valueOf(st.nextToken());

        /*
        시간복잡도
        최대 N, K = 4,000,000
        3N
         */
        //(a*b) % mod = {(a%mod) * (b%mod)} % mod
        // 분자 N!
        long numer = factorial(n);

        // 분모 (K! * (N-K)!) mod p
        long denom = factorial(c) * factorial(n - c) % P;


        // N! * 분모의 역원((K! * (N-K)!)
        System.out.println(numer * pow(denom, P - 2) % P);
    }

    // 팩토리얼 함수
    public static long factorial(long N) {
        long fac = 1L;

        while(N > 1) {
            fac = (fac * N) % P;
            N--;
        }
        return fac;
    }


    /*
     * 역원 구하는 함수
     * base : 밑,   expo = 지수 (exponent)
     * 거듭 제곱을 분할 정복 방식으로 푼다.
     */
    public static long pow(long base, long expo) {
        long result = 1;

        // 3 17
        // 3^2 8, 3
        // 3^4 4
        // 3^8 2
        // 3^16 1
        //3^32 0, 3^17
        while (expo > 0) {

            // 지수가 홀 수면 반환하고자 하는 result에 곱해주도록 한다.
            // 지수가 모두 짝수라면 expo가 1이 될 떄까지 base의 값이 제곱되다가 최종적으로 result에 담긴다.
            if (expo % 2 == 1) {
                result *= base;
                result %= P;
            }
            base = (base * base) % P;
            expo /= 2;
        }
        return result;
    }
}