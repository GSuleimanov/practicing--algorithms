package three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        var s = new Solution();
        var result = s.threeSum(new int[] {0,0,-4,-2,1,0,-5,-4,-4,4,-2,0,4,-2,3,1,-5,0});
        long endTime = System.currentTimeMillis();
        System.out.println("Result is: " + result + ". It took " + (endTime - startTime) + " milliseconds");
        System.out.println("Result's size is: " + result.size());
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, HashMap<Integer, Integer>> resMap = new HashMap<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int solution = -(nums[i] + nums[j]);
                var r = Arrays.asList(nums[i], nums[j], solution);
                r.sort(Comparator.naturalOrder());
                int first = r.get(0);
                int second = r.get(1);
                if (resMap.containsKey(first) && resMap.get(first).containsKey(second)) continue;
                for (int k = j + 1; k < nums.length - 1; k++)
                    if (i < nums.length && nums[k] == solution) {
                        if (resMap.containsKey(first)) resMap.get(first).put(second, solution);
                        else {
                            HashMap<Integer, Integer> tmp = new HashMap<>();
                            tmp.put(second, solution);
                            resMap.put(first, tmp);
                        }
                        result.add(r);
                    }
            }
        }
        return result;
    }
}
// @lc code=end
