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
        if (strs.length == 1) return strs[0];
        String result = compare(strs[0], strs[1]);
        for (int i = 1; i < strs.length - 1; i++) result = compare(result, strs[i+1]);
        return result;
    }

    private String compare(String one, String another) {
        StringBuilder result = new StringBuilder();
        int minWordLength = Math.min(one.length(), another.length());
        for (int i = 0; i < minWordLength; i++)
            if (one.charAt(i) != another.charAt(i)) break;
            else result.append(one.charAt(i));
        return result.toString();
    }
}
// @lc code=end