package com.example.test.other.algorithm;

import java.util.Arrays;

/**
 * @author TaoZhiQun
 * @version v1.0
 * @desc TODO
 * @date 2019/7/22 9:22
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 5, 1, 2, 9, 8, 8, 7, 0};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
    private static void selectionSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            int minIndex = array[i];
            for(int j = i+1;j<array.length;j++){
                minIndex = array[j]<array[minIndex]?j:minIndex;
            }
            int temp = array[minIndex];
            array[minIndex] =array[i];
            array[i] =temp;
        }
    }

}
