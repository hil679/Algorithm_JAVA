package org.example.dijkstra;

import java.util.Scanner;
import java.util.Stack;

public class Problem11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int enterMoneyTypeNum = sc.nextInt();
        int totalMoney = sc.nextInt();
        int answer = 0;

        Stack<Integer> moneyTypeList = new Stack<>();

        for(int i = 0; i < enterMoneyTypeNum; i++){
            moneyTypeList.push(sc.nextInt());
        }
        while(!moneyTypeList.empty()){
            int moneyType = moneyTypeList.pop();
            answer += totalMoney / moneyType;
            totalMoney %= moneyType;
        }
        System.out.println(answer);
    }
}
