package org.example.recursive;

import java.util.Scanner;

public class Problem24060 {

    static int[] arr;
    static int count = 0;
    static int k;
    static int result = -1;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] arr = new int[num];
        k = sc.nextInt();

        arr = new int[num];

        for(int i = 0 ; i < num ; i++){
            arr[i] = sc.nextInt();
        }

        sc.close();

        mergeSort(arr, 0, arr.length - 1);
        System.out.print(result);

    }

    static void mergeSort(int A[], int low, int high){

        if(low < high){
            int mid = (low + high) / 2;
            mergeSort(A, low, mid);
            mergeSort(A, mid + 1, high);
            merge(A, low, mid, high);
        }
    }

    static void merge(int A[], int low, int mid, int high){
        int i = low;
        int j = mid + 1;
        int t = 0;


        while(i <= mid && j <= high){
            if(A[i] <= A[j]){
                arr[t++] = A[i++];
            }else{
                arr[t++] = A[j++];
            }
        }

        while(i <= mid){
            arr[t++] = A[i++];
        }

        while(j <= high){
            arr[t++] = A[j++];
        }

        t = 0;
        i = low;

        while(i <= high){
            count++;
            if(count == k){
                result = arr[t];
                break;
            }
            A[i++] = arr[t++];
        }
    }
}
