package com.example.test.other.algorithm;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {20, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    private static void quickSort(int[] arr,int start,int end){
        if(start<end){
            int i,j,temp,t;
            i = start;
            j = end;
            temp =arr[start];
            while(i<j){
                while(temp<=arr[j] && i<j){
                    j--;
                }
                while(temp>=arr[i] && i<j){
                    i++;
                }
                if(i<j){
                    t = arr[j];
                    arr[j] =arr[i];
                    arr[i] =t;
                }
            }
            arr[start] =arr[i];
            arr[i]= temp;
            quickSort(arr,start,j-1);
            quickSort(arr,j+1,end);
        }
    }

}
