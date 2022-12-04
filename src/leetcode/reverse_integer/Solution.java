package reverse_integer;
/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {

    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.reverse(21836));
    }

    public int reverse(int x) {
        long reversed = x < 0 ? - 0 : 0;
        if ((x < 0x80000000 || x > 0x7fffffff)) return 0;
        while (x != 0) {
            if (reversed*10 < 0x80000000 || reversed*10 > 0x7fffffff) return 0;
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return (int) reversed;
    }
}
// @lc code=end