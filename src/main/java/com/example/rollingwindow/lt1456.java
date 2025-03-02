package com.example.rollingwindow;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @className: lt
 * @author: bingjie_zou@163.com
 * @date: 2025/3/1 20:29
 * @version: 1.0
 * @description:
 */


public class lt1456 {

    public static void main(String[] args) {
        String s = "abciiidef";
        System.out.println(maxVowels(s, 3));
    }

    public static int maxVowels(String s, int k){
        //定长的滑动窗口
        //每次移动进一个出一个 减少不必要的计算
        //结果记录用ans
        int ans = 0;
        //哈希set把元音字母存进去 哈希set查询的时间复杂度为O（1）
        Set<Character> set = new HashSet<>();
        set.addAll(List.of('a', 'e', 'i', 'o', 'u'));
        int count = 0; // 初始化计数变量
        for(int i = 0; i < s.length(); i++){
            //每次先判断一下入队的元素和出队的元素是否为元音字母
            if(set.contains(s.charAt(i))){
                //如果是元音字母 则技术加1
                count++;
            }
            //如果当前子串长度还没到k 直接跳出循环
            if(i < k - 1){
                continue;
            }

            //如果子串长度达到了k则需要先更新最大元音字母数 再移动左端
            ans = Math.max(ans, count);
            if (set.contains(s.charAt(i+1-k))){
                count--;
            }

        }
        return ans;
    }
}
