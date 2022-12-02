package valid_parentheses;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    private static char[] closingBrackets = new char[] {')',']','}'};
    private static char[] openingBrackets = new char[] {'(','[','{'};
    LinkedList<Character> linkedList = new LinkedList<>();

    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "]";
        String s5 = "";
        // assert new Solution().isValid(s1);
        // assert new Solution().isValid(s2);
        // assert !new Solution().isValid(s3);
        System.out.println(new Solution().isValid(s1));
        System.out.println(new Solution().isValid(s2));
        System.out.println(new Solution().isValid(s3));
        System.out.println(new Solution().isValid(s4));
        System.out.println(new Solution().isValid(s5));
    }

    public boolean isValid(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (bracketsMatches(ch)) linkedList.removeLast();
            else linkedList.add(ch);
        }
        System.out.println(linkedList);
        return linkedList.isEmpty();
    }

    private boolean bracketsMatches(char bracket) {
        for (int i = 0; i < closingBrackets.length; i++)
            if (bracket == closingBrackets[i]
                    && !linkedList.isEmpty()
                    && linkedList.getLast() == openingBrackets[i])
                return true;
        return false;
    }
}
// @lc code=end
