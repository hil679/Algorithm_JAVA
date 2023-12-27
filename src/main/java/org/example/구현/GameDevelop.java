package org.example.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GameDevelop {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String sizes = bf.readLine();
        int n = Integer.valueOf(sizes.substring(0, 1));
        int m = Integer.valueOf(sizes.substring(2, 3));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int cx = Integer.valueOf(st.nextToken());
        int cy = Integer.valueOf(st.nextToken());
        int d = Integer.valueOf(st.nextToken());
        String[][] map = new String[n][m];

        for(int i = 0; i < n; i++) {
            map[i] = bf.readLine().split(" ");
        }
        map[cy][cx] = "2";

        int result = 1;
        while(true) {
            if(!map[cy - 1][cx].equals("0")
                    && !map[cy][cx + 1].equals("0")
                    && !map[cy + 1][cx].equals("0")
                    && !map[cy][cx - 1].equals("0")) {
                if(d == 0) {
                    if(map[cy - 1][cx].equals("1"))
                        break;
                    else
                        cy--;
                } else if(d == 1) {
                    if(map[cy][cx + 1].equals("1"))
                        break;
                    else
                        cx++;
                } else if(d == 2) {
                    if(map[cy + 1][cx].equals("1"))
                        break;
                    else
                        cy++;
                } else if(d == 3) {
                    if(map[cy][cx - 1].equals("1"))
                        break;
                    else
                        cx--;
                }
                continue;
            }
            if (d == 0 && map[cy - 1][cx].equals("0")) {
                result++;
                map[cy - 1][cx] = "2";
                cy--;
            } else if (d == 1 && map[cy][cx + 1].equals("0")) {
                map[cy][cx + 1] = "2";
                cx++;
                result++;
            } else if (d == 2 && map[cy + 1][cx].equals("0")) {
                map[cy + 1][cx] = "2";
                cy++;
                result++;
            } else if (d == 3 && map[cy][cx - 1].equals("0")) {
                map[cy][cx - 1] = "2";
                cx--;
                result++;
            } else {
                if(d == 0)
                    d += 3;
                else
                    d--;
            }
        }
        System.out.println(result);
    }

}
//4 4
//1 1 0
//1 1 1 1
//1 0 0 1
//1 1 0 1
//1 1 1 1