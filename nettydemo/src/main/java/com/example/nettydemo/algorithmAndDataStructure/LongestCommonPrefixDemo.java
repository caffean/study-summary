package com.example.nettydemo.algorithmAndDataStructure;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Classname LongestCommonPrefixDemo
 * @Description 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * @Date 2019/9/11 10:18
 * @Author lyn
 */
public class LongestCommonPrefixDemo {

    public static void main(String[] args) {
        String[] strings = new String[]{"abcd", "abc", "ab"};
        String s = longestCommonPrefix(strings);
        String s1 = longestCommonPrefix1(strings);
        System.out.println(s);
        System.out.println(s1);
    }

    private static String longestCommonPrefix(String[] strings) {
        for (int i = 0; i < strings[0].length(); i++) {
            char c = strings[0].charAt(i);
            for (int j = 1; j < strings.length ; j++) {
                if (i == strings[j].length() || strings[j].charAt(i) != c)
                    return strings[0].substring(0, i);
            }
        }
        return strings[0];
    }

    /**
     * 方法一：水平扫描法
     * 思路
     * <p>
     * 首先，我们将描述一种查找一组字符串的最长公共前缀 LCP(S_1 \ldots S_n)LCP(S1…Sn) 的简单方法。
     * 我们将会用到这样的结论：
     * <p>
     * LCP(S_1 \ldots S_n) = LCP(LCP(LCP(S_1, S_2),S_3),\ldots S_n)LCP(S1…Sn)=LCP(LCP(LCP(S1,S2),S3),…Sn)
     * <p>
     * 算法
     * 为了运用这种思想，算法要依次遍历字符串 [S_1 \ldots S_n][S1…Sn]，当遍历到第 ii
     * 个字符串的时候，找到最长公共前缀 LCP(S_1 \ldots S_i)LCP(S1…Si)。当 LCP(S_1 \ldots S_i)LCP(S1…Si)
     * 是一个空串的时候，算法就结束了。 否则，在执行了 nn 次遍历之后，算法就会返回最终答案 LCP(S_1 \ldots S_n)LCP(S1…Sn)。
     * @param strs
     * @return
     */
    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }


}
