package org.example.programmers.string;
import java.util.*;
public class 개인정보수집유효기안 {
    static int[] todayInfo;
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] a = {};
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap <String, Integer> hm = new HashMap<>();
        for (String term : terms) {
            String[] t = term.split(" ");
            hm.put(t[0], Integer.parseInt(t[1]));
        }
        todayInfo = Arrays.stream(today.split("\\."))
                .mapToInt(Integer::parseInt)
                .toArray(); //year, month, day
        // System.out.println(todayInfo[0]);

        Integer idx = 1;
        for (String privacy : privacies) {
            StringTokenizer st = new StringTokenizer(privacy);
            String date = st.nextToken();
            int[] limitInfo = Arrays.stream(date.split("\\."))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int term = hm.get(st.nextToken());

            if (checkDueDate(limitInfo, term)) {
                System.out.println(idx);
                answer.add(idx);

            }
            idx++;
        }

        // return a;
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean checkDueDate(int[] limitInfo, int term) {
        int passYear = term / 12;
        term -= 12 * passYear;
        limitInfo[0] += passYear;

        if (limitInfo[1] + term > 12) {
            int left = limitInfo[1] + term  - 12;
            limitInfo[1] = left;
            limitInfo[0]++;
        } else {
            limitInfo[1] += term;
        }

        if (limitInfo[2] == 1){
            if (limitInfo[1] == 1) {
                limitInfo[1] = 12;
                limitInfo[0] -= 1;
            } else
                limitInfo[1] -= 1;

            limitInfo[2] = 28;
        } else {
            limitInfo[2] -= 1;
        }
        System.out.println(limitInfo[0] + " " + limitInfo[1] + " " + limitInfo[2] );
        // System.out.println(todayInfo[0] + " " + todayInfo[1] + " " + todayInfo[2] +"\n");
        if (todayInfo[0] > limitInfo[0])
            return true;
        else if (todayInfo[0] < limitInfo[0])
            return false;
        else {
            if (todayInfo[1] > limitInfo[1])
                return true;
            else if (todayInfo[1] < limitInfo[1])
                return false;
            else {
                if (todayInfo[2] > limitInfo[2])
                    return true;
                return false;
            }
        }
        // new sol :  (year * 12 * 28) + (month * 28) + day;
    }
}
