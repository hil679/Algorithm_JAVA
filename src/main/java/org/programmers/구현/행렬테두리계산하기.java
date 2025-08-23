package org.programmers.구현;

public class 행렬테두리계산하기 {
    static int min;

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int [rows+1][columns+1];
        int num = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                map[i][j] = num++;
            }
        }

        int q = 0;
        for (int[] query : queries) {
            min = rows * columns + 1;

            int curCol = query[1];
            int curRow = query[0];
            int curTemp = map[curRow][curCol];
            int nextTemp;
            for (curCol = query[1]; curCol < query[3]; curCol++) {
                checkMin(curTemp);
                nextTemp = map[curRow][curCol+1];
                map[curRow][curCol+1] = curTemp;
                curTemp = nextTemp;
            }
            for (curRow = query[0]; curRow < query[2]; curRow++) {
                checkMin(curTemp);
                nextTemp = map[curRow+1][curCol];
                map[curRow+1][curCol] = curTemp;
                curTemp = nextTemp;
            }
            for (; curCol > query[1]; curCol--) {
                checkMin(curTemp);
                nextTemp = map[curRow][curCol-1];
                map[curRow][curCol-1] = curTemp;
                curTemp = nextTemp;
            }
            for (; curRow > query[0]; curRow--) {
                checkMin(curTemp);
                nextTemp = map[curRow-1][curCol];
                map[curRow-1][curCol] = curTemp;
                curTemp = nextTemp;
            }
            answer[q++] = min;
        }
        return answer;
    }

    private void checkMin(int value) {
        if (min > value) min = value;
    }

//1번 최대 도는 횟수 = 100*100가장자리
//최대 10000번
//1억 이하
}
