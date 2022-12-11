package leetcode.valid_palindrome;

import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;

/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {

    public static void main(String[] args) {
        Consumer<String> checkAndPrint = s -> { System.out.printf("%n%s -- %s a palindrome.", s, new Solution().isPalindrome(s) ? "IS" : "IS NOT"); };
        var strings = Arrays.asList("A man, a p:pan?aMa", " ", ".", ".,", "ab");
        strings.stream().forEach(checkAndPrint);
    }

    public boolean isPalindrome(String s) {
        if (s.isBlank() || s.length() == 1) return true;
        int i = 0;
        int j = s.length()-1;
        IntFunction<String> getStr = x -> String.valueOf(s.charAt(x));
        IntPredicate notLetterOrDigit = x -> !Character.isLetterOrDigit(s.charAt(x));
        BiPredicate<Integer, Integer> notEquals = (x,y) -> !getStr.apply(x).equalsIgnoreCase(getStr.apply(y));
        while (true) {
            if (i > j || i == j) return true;
            else if (notLetterOrDigit.test(i)) i++;
            else if (notLetterOrDigit.test(j)) j--;
            else if (notEquals.test(i, j)) return false;
            else {
                i++;
                j--;
            }
        }
    }
}
// @lc code=end
