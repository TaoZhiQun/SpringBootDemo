package com.example.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AddDemo {
    public static void main(String[] args) {
        int[] nums = new int[]{ 2,3,5,7,11,13,17,19,23,29};
        int target = 13;
        long start = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            twoSum(nums, target);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(2);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] forTwoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
