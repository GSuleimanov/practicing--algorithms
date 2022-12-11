package leetcode.number_of_digit_one;
/*
 * @lc app=leetcode id=233 lang=java
 *
 * [233] Number of Digit One
 */

import java.util.stream.IntStream;

// @lc code=start
class Solution {
    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.countDigitOne(5_000_000));
        //10: 2, 100: 21, 1_000: 301, 10_000: 4001, 100_000: 50001, 1_000_000: 600001
        //       50: 15,    500: 200,  5_000: 2500,  50_000: 30000,   500_000: 350000
        // 10_000_000: 7000001
        //  5_000_000: 4000000
    }

    public int countDigitOne(int n) {
        return IntStream.rangeClosed(0, n).reduce(0, (a, b) -> a + countDigit(1, b));
    }

    public int countDigit(int countedDigit, int analyzingDigit) {
        int sum = 0;
        while (analyzingDigit > 0) {
            int r = analyzingDigit % 10;
            sum = r == countedDigit ? ++sum : sum;
            analyzingDigit /= 10;
        }
        return sum;
    }
}
// @lc code=end
