package org.example.dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem9184 {//불연속적 -> top dowm이 더 구현하기 좋음
    private static int[][][] arr = new int[21][21][21];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(str);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(isExit(a, b, c)){
                break;
            }
            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));
        }
    }

    private static boolean isExit(int a, int b, int c){
        if(a == -1 && b ==  -1 && c == -1)
            return true;
        return false;
    }

    private static int w(int a, int b, int c){
        arr[0][0][0] = 1;

        if (a <= 0 || b <= 0 || c <= 0){
            return 1;
        }
        else if (a > 20|| b > 20 || c > 20){
            if(arr[20][20][20] != 0)
                return arr[20][20][20];
            arr[20][20][20] = w(20, 20, 20);
            return arr[20][20][20];
        }
        if(arr[a][b][c] != 0)
            return arr[a][b][c];
        if (a < b && b < c){
            arr[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
            return arr[a][b][c];
        }
        arr[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        return arr[a][b][c];
    }
}
