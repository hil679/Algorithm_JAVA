package org.example.graph;

import java.util.*;

class 표병합 {
    public static int[] values;
    static String[][] table;
    public String[] solution(String[] commands) {
        // String[] answer = {};
        table = new String[50][50];
        values = new int[2500];
        List<String> answer = new ArrayList<>();

        for (String command : commands) {
            String[] splitCommand = command.split(" ");
            if (splitCommand[0].equals("UPDATE")) {
                if (Character.isDigit(splitCommand[1].charAt(0))) {
                    int r = Integer.parseInt(splitCommand[1]);
                    int c = Integer.parseInt(splitCommand[2]);
                    table[r][c] = splitCommand[3];
                    values[50*r + c] = 50*r + c;
                }
                else {
                    int row = 0;
                    for (String[] t : table) {
                        int col = 0;
                        for (String x : t) {
                            if (x == null) continue;
                            if (x.equals(splitCommand[1])) {
                                table[row][col] = splitCommand[1];
                            }
                            col++;
                        }
                        // System.out.println(row);
                        row++;
                    }
                }
            } else if (splitCommand[0].equals("MERGE")) {
                int r1 = Integer.parseInt(splitCommand[1]);
                int c1 = Integer.parseInt(splitCommand[2]);
                int r2 = Integer.parseInt(splitCommand[3]);
                int c2 = Integer.parseInt(splitCommand[4]);

                int num1 = r1*50 + c1;
                int num2 = r2*50 + c2;

                //둘 중 하나만 값을 가지고 있는 경우
                if(values[find(num1)] == 0 && values[find(num2)] != 0){
                    table[r2][c2] = table[r1][c1];
                    int temp = num1;
                    num1 = num2;
                    num2 = temp;
                }

                union(num1, num2);

            } else if (splitCommand[0].equals("UNMERGE")) {
                int r1 = Integer.parseInt(splitCommand[1]);
                int c1 = Integer.parseInt(splitCommand[2]);

                values[find(r1*50 + c1)] = 0;
                System.out.println();
                System.out.println(values[54]);
                System.out.println(table[5][4]);
                System.out.println(values[53]);
                System.out.println(table[5][3]);
                System.out.println(values[52]);
                System.out.println(table[5][2]);

            } else if (splitCommand[0].equals("PRINT")){
                int r1 = Integer.parseInt(splitCommand[1]);
                int c1 = Integer.parseInt(splitCommand[2]);
                int v = values[find(50*r1 + c1)];
                String cont = table[v/50][v%50];

                if (cont == null)
                    answer.add("EMPTY");
                else
                    answer.add(cont);
            }
        }
        return answer.toArray(String[]::new);
    }

    public static int find(int x) {
        if (values[x] == x){
            // System.out.println(x);
            return x;
        }
        else{
            // System.out.println(x);
            return find(values[x]); // find한 숫자가 다시 다른 숫자과 연관있을 수 있으니 find 또 필요
        }
    }

    public static int unmergeFind(int x) {
        if (values[x] == x){
            return x;
        }
        else{
            values[find(values[x])] = 0;
            table[x/50][x%50] = null;
            return values[x] = find(values[x]); // find한 숫자가 다시 다른 숫자과 연관있을 수 있으니 find 또 필요
        }
    }

    public static void union(int a, int b) {
        int x = find(values[a]);
        int y = find(values[b]);
        values[b] = x;
    }
}