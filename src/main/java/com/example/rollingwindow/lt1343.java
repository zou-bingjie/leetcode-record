package com.example.rollingwindow;

import java.lang.invoke.VarHandle;

/**
 * @className: lt1343
 * @author: bingjie_zou@163.com
 * @date: 2025/3/1 21:21
 * @version: 1.0
 * @description:
 */


public class lt1343 {

    public static void main(String[] args) {
        int[] arr = new int[]{2,2,2,2,5,5,5,8};
        System.out.println(numOfSubarrays(arr, 3, 4));
    }

    public static int numOfSubarrays(int[] arr, int k, int threshold){
        //定长滑动窗口 每次需要计算窗口平均值 并与threshold进行比较
        int sum = 0;
        int ans = 0;
        int target = k * threshold;
        for (int i = 0; i < arr.length; i++){
            //先增
            sum += arr[i];
            //如果还没达到窗口长度 直接跳出循环 不执行后面的操作
            if(i < k - 1){
                continue;
            }
            //达到了窗口长度后 计算平均值 并更新ans
            if(sum >= target){
                ans++;
            }
            //队首元素出队
            sum -= arr[i + 1 - k];
        }
        return ans;
    }
}
