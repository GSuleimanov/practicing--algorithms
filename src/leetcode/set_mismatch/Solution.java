package leetcode.set_mismatch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

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
        IntConsumer addAndFixDupl = x -> { if (!uniqs.add(x)) result[DUPL] = x; };
        Arrays.stream(nums).forEach(addAndFixDupl);
        result[MISS] = IntStream.range(1, nums.length+1)
                .filter(x -> !uniqs.contains(x))
                .findAny().orElse(0);
        // System.out.printf("nums➤ %s, uniqs➤ %s, result➤ -> %s\n", Arrays.toString(nums), uniqs, Arrays.toString(result));
        return result;
    }
}
// @lc code=end