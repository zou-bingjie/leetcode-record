package com.example.rollingwindow;


/**
 * @className: lt643
 * @author: bingjie_zou@163.com
 * @date: 2025/3/1 0:35
 * @version: 1.0
 * @description: leetcode643
 */


public class lt643 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,12,-5,-6,50,3};
        double maxAverage = findMaxAverage(nums, 4);
        System.out.println(maxAverage);

    }

    public static double findMaxAverage(int[] nums, int k) {
        //固定长度的滑动窗口
        //窗口指针的初始化
        int left = 0, right = k - 1;
        //ans记录答案
        int ans = Integer.MIN_VALUE;
        //右端的指针遍历到最后一个
        while(right < nums.length){
            int sum = 0;
            for(int i = left; i <= right; i++){
                sum += nums[i] / k;
            }
            ans = Math.max(ans, sum);
            left++;
            right++;
        }
        return ans;
    }


}
