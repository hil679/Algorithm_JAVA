package org.programmers.dfs_bfs;

public class 이모티콘할인행사_dfs {
    static int[] discountNorm = {10,20,30,40};
    static int[][] gusers;
    static int[] answer = {0,0};
    public int[] solution(int[][] users, int[] emoticons) {
        // int[] answer = {0,0};
        int[] discountPercentage = new int[emoticons.length];
        gusers = users;
        dfs(discountPercentage, emoticons, 0);

        return answer;
    }

    private void dfs(int[] discountPercentage, int[] emoticons, int temp) {
        if (temp == emoticons.length) {
            int[] tempAnswer = {0,0};
            for (int[] user : gusers) {
                int totPrice = 0;
                for (int i = 0; i < discountPercentage.length; i++) {
                    if (discountPercentage[i] >= user[0]) {
                        totPrice += emoticons[i] * (100 - discountPercentage[i]) / 100;
                    }
                }
                // System.out.println(discountPercentage[0] + " "+discountPercentage[1]);
                // System.out.println(totPrice + " ");
                // System.out.println();
                if (user[1]<=totPrice) {
                    tempAnswer[0]+=1;
                }
                else
                    tempAnswer[1]+=totPrice;
            }

            if (answer[0] < tempAnswer[0]) {
                answer = tempAnswer;
            }
            if (answer[0] == tempAnswer[0] && answer[1] < tempAnswer[1])
                answer = tempAnswer;
            return;
        }

        for (int dn : discountNorm) {
            discountPercentage[temp] = dn;
            dfs(discountPercentage, emoticons, temp + 1);
        }

    }
}
