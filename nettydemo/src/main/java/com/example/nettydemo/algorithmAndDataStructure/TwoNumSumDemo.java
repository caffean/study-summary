package com.example.nettydemo.algorithmAndDataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname TwoNumSumDemo
 * @Description 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
    示例:
    给定 nums = [2, 7, 11, 15], target = 9
    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]
 * @Date 2019/9/4 10:07
 * @Author lyn
 */
public class TwoNumSumDemo {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        int[] i = new int[]{1,3,4,1,4,1,4,2,7,11};
        twoSum1(i,9);
        System.out.println(System.currentTimeMillis());

    }

    //方法1 暴力循环解决 时间复杂度：$O(n^2)$， 对于每个元素，
    // 我们试图通过遍历数组的其余部分来寻找它所对应的目标元素，这将耗费 $O(n)$ 的时间。因此时间复杂度为 $O(n^2)$
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //方法2 采用
    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target- nums[i]),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
