package leetcode.valid_palindrome;

import java.util.Arrays;
import java.util.function.Consumer;

/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {

    public static void main(String[] args) {
        Consumer<String> checkAndPrint = s ->
            System.out.printf("%n%s -- %s a palindrome.", s, new Solution().isPalindrome(s) ? "IS" : "IS NOT");
        var strings = Arrays.asList("Aama", "A man, a p:pan?aMa", " ", ".", ".,", "ab");
        strings.stream().forEach(checkAndPrint);
    }

    public boolean isPalindrome(String s) {
        return tryToCompare(s, 0, s.length() - 1);
    }

    private boolean equalChars(char a, char b) {
        return a == b || Character.toLowerCase(a) == b || Character.toLowerCase(b) == a;
    }

    private boolean tryToCompare(String s, int i, int j) {
        if (i > j || i == j) return true;
        else if (!Character.isLetterOrDigit(s.charAt(i))) return tryToCompare(s, ++i, j);
        else if (!Character.isLetterOrDigit(s.charAt(j))) return tryToCompare(s, i, --j);
        else if (equalChars(s.charAt(i), s.charAt(j))) return tryToCompare(s, ++i, --j);
        return false;
    }
}
// @lc code=end
