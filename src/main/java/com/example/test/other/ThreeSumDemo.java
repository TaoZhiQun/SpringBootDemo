package com.example.test.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumDemo {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result =new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]>0){
                break;
            }
            int left =i+1;
            int right =nums.length-1;
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            while(left<right){
                int sum = nums[left]+nums[right]+nums[i];
                if(sum==0){
                    result.add(Arrays.asList(new Integer[]{nums[left],nums[right],nums[i]}));
                    while(left<right&&nums[left]==nums[left+1]){
                        left++;
                    }
                    while(left<right&&nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(sum>0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{-1,-1,0,1,2};
        List<List<Integer>> lists = new ThreeSumDemo().threeSum(nums);
        System.out.println(Arrays.asList(lists));
    }
}
