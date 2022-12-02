package src.two_sum;

import java.util.Arrays;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution2 {

    public static void main(String[] args) {
        int[] test = new int[] {-18,-10,-3,1,4,7,3,9,5,17,11,14,3,0};
        var s = new Solution2();

        long startTime = System.currentTimeMillis();
        int[] result = s.twoSum(test,-6);
        long endTime = System.currentTimeMillis();

        System.out.println("Result is: " + Arrays.toString(result) + ". It took " + (endTime - startTime) + " milliseconds");

    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i<nums.length; i++)
            for (int j=i+1; j<nums.length; j++)
                if (nums[i] + nums[j] == target) return new int[] {i,j};
        throw new IllegalArgumentException();
    }
}
// @lc code=end