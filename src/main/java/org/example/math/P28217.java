package org.example.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P28217 {
    static int triangleA[][][];
    static int triangleB[][];
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        triangleA = new int [6][n][n];
        triangleB = new int [n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangleA[0][i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangleB[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rotateAndMirror(n);

        System.out.println(calculate(n));
    }
    public static void rotateAndMirror(int n) {
        //rotate
        for (int i = 0; i < n; i++) {
            int k = i;
            for (int j = 0; j <= i; j++) {
                //rotate -120
                triangleA[1][i][j] = triangleA[0][n-1-k][n-1-i];
//                System.out.print(triangleA[1][i][j] + " ");

                //rotate 120
                triangleA[2][i][j] = triangleA[0][n-1-j][k];
//                System.out.print(triangleA[2][i][j] + " ");
                k--;


            }
//            System.out.println();
        }

        //mirror
        for (int i = 0; i < n; i++) {
            int k = i;
            for (int j = 0; j <= i; j++) {
                // mirror original one
                triangleA[3][i][j] = triangleA[0][i][i-j];
//                System.out.print(triangleA[3][i][j] + " ");

                // mirror -120 rotation one
                triangleA[4][i][j] = triangleA[1][i][i-j];
//                System.out.print(triangleA[4][i][j] + " ");

                // mirror 120 rotation one
                triangleA[5][i][j] = triangleA[2][i][i-j];
//                System.out.print(triangleA[5][i][j] + " ");
            }
//            System.out.println();
        }
    }

    public static int calculate(int n){
        int min = 55;
        for (int i = 0; i < 6; i++) {
            int calcValue = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= j; k++) {
                    calcValue += Math.abs(triangleB[j][k] - triangleA[i][j][k]);
                }
            }
            if (min > calcValue) min = calcValue;
        }
        return min;
    }
}
