package com.example.rollingwindow;

import java.util.*;

/**
 * @className: lt2841
 * @author: bingjie_zou@163.com
 * @date: 2025/3/2 15:41
 * @version: 1.0
 * @description:
 */


public class lt2841 {

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.addAll(List.of(1,1,1,3));
        System.out.println(maxSum(nums, 2, 2));
    }

    public static long maxSum(List<Integer> nums, int m, int k) {
        //哈希表去重计数 + 定长滑动窗口
        long ans = 0L;
        long sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < k - 1; i++){
            int num = nums.get(i);
            map.put(num, map.getOrDefault(num, 0) + 1);
            sum += num;
        }
        for(int i = k - 1; i < nums.size(); i++){
            //新元素入队
            int num = nums.get(i);
            map.put(num, map.getOrDefault(num, 0) + 1);
            sum += num;
            //如果哈希集合中元素个数大于等于m 说明至少存在m个不相同的元素
            if(map.size() >= m){
                ans = Math.max(ans, sum);
            }
            //旧元素出队
            int old = nums.get(i + 1 - k);
            map.put(old, map.get(old) - 1);
            if(map.get(old) == 0){
                map.remove(old);
            }
            sum -= old;
        }
        return ans;
    }
}
