package com.example.rollingwindow;

import java.util.Arrays;

/**
 * @className: lt2090
 * @author: bingjie_zou@163.com
 * @date: 2025/3/1 21:36
 * @version: 1.0
 * @description: lt2090 半径为k的子数组平均值
 */


public class lt2090 {

    public static void main(String[] args) {
        int[] nums = new int[]{7,4,3,9,1,8,5,2,6};
        int[] ans = getAverages(nums, 3);
        for (int a : ans) {
            System.out.println(a + ",");
        }
    }

    public static int[] getAverages(int[] nums, int k) {
        //两种可以优化掉的情况 包括
        //1.k=0 直接返回原数组
        if(k == 0){
            return nums;
        }
        //2.k>nums.length
        if(2*k + 1 > nums.length){
            return new int[]{-1};
        }
        //3.正常情况
        //3.1可以确定出需要遍历的数组的个数 nums.length - k + 1
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1); //用-1填充 只需要修改不为负一的地方即可
        //3.2进行遍历 并把结果存储到ans里
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            //入队
            sum += nums[i];
            //验证
            if(i < 2*k){
                continue;
            }
            //更新
            ans[i - k] = sum / (2*k + 1);
            //出队
            sum -= nums[i - 2*k];
        }
        return ans;

    }
}
