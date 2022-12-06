package leetcode.set_mismatch;

import java.util.Arrays;
import java.util.HashSet;

/*
 * @lc app=leetcode id=645 lang=java
 *
 * [645] Set Mismatch
 */

// @lc code=start
class Solution {
    private static final int DUPL = 0;
    private static final int MISS = 1;
    private int[] result = new int[] {0,0};

    public static void main(String[] args) {
        var s = new Solution();
        s.findErrorNums(new int[] {1,2,2,4});
        s.findErrorNums(new int[] {1,1});
        s.findErrorNums(new int[] {2,2});
        s.findErrorNums(new int[] {3,2,2});
        s.findErrorNums(new int[] {1,2,4,4,5});
    }

    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> uniqs = new HashSet<>();
        int sumOfNums = Arrays.stream(nums).peek(x -> { if (result[DUPL] == 0 && !uniqs.add(x)) result[DUPL] = x; }).sum();
        int expectedSum = nums.length*(nums.length+1)/2;
        result[MISS] = expectedSum - (sumOfNums - result[DUPL]);
        return result;
    }
}
// @lc code=end