package longest_common_prefix;

/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {

    public static void main(String[] args) {
        var strings = new String[] {"flower", "flow", "flat"};
        var lPref = new Solution().longestCommonPrefix(strings);
        System.out.println(lPref);
    }

    public String longestCommonPrefix(String[] strs) {
        String result;
        if (strs.length < 2) result = strs[0];
        else {
            result = compare(strs[0], strs[1]);
            for (int i = 0; i < strs.length - 1; i++)
                result = compare(result, strs[i+1]);
        }
        return result;
    }

    private String compare(String one, String another) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < one.length(); i++)
            if (one.length() - 1 < i || another.length() - 1 < i
                    || one.charAt(i) != another.charAt(i)) break;
            else result.append(another.charAt(i));
        return result.toString();
    }
}
// @lc code=end