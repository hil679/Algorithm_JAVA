package org.programmers.sort;
import java.util.*;
public class 데이터분석 {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        int extIdx = getIdx(ext);
        int sort_byIdx = getIdx(sort_by);
        List<int[]> realData = new ArrayList<>();

        int i = 0;
        for (int[] d : data) {
            if (d[extIdx] < val_ext) {
                realData.add(d);
                i++;
            }
        }
        System.out.print(sort_byIdx);
        realData.sort((num1,num2)->num1[sort_byIdx]-num2[sort_byIdx]);
        return realData.toArray(new int[i][]);
    }

    private int getIdx(String ext) {
        if (ext.equals("code"))
            return 0;
        else if (ext.equals("date"))
            return 1;
        else if (ext.equals("maximum"))
            return 2;
        else if (ext.equals("remain"))
            return 3;
        return -1;
    }
}
