package leetcode.valid_parentheses;

import java.util.LinkedList;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    private static int[] opening = new int[] {40,91,123};
    private static int[] closing = new int[] {41,93,125};
    private LinkedList<Character> opened = new LinkedList<>();

    public boolean isValid(final String s) {
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            for (int j = 0; j < 3; j++)
                if (current == opening[j]) opened.add(current);
                else if (current == closing[j] && (opened.isEmpty() || opened.pollLast() != opening[j])) return false;
        }
        return opened.isEmpty();
    }
}
// @lc code=end
