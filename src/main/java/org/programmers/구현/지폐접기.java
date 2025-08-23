package org.programmers.구현;

public class 지폐접기 {
    public int main(int[] wallet, int[] bill) {
        int answer = 0;

        int x = bill[0];
        int y = bill[1];
        int bigBill = x > y ? x: y;
        int smallBill = x < y ? x: y;
        int bigW = wallet[0] > wallet[1] ? wallet[0] : wallet[1];
        int smallW = wallet[0] < wallet[1] ? wallet[0] : wallet[1];

        while (bigBill > bigW || smallBill > smallW)
        {
            bigBill /= 2;
            if (bigBill < smallBill) {
                int temp = bigBill;
                bigBill = smallBill;
                smallBill = temp;
            }
            answer++;
        }
        return answer;
    }
}
