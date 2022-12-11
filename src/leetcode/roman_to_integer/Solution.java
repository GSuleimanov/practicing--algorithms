package leetcode.roman_to_integer;

import java.util.HashMap;

/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
    static HashMap<Character, Integer> romanInteger = new HashMap<>(8,1);

    static {
        romanInteger.put('M', 1000);
        romanInteger.put('D', 500);
        romanInteger.put('C', 100);
        romanInteger.put('L', 50);
        romanInteger.put('X', 10);
        romanInteger.put('V', 5);
        romanInteger.put('I', 1);
    }

    public static void main(String[] args) {
        var s = new Solution();
        long startTime = System.currentTimeMillis();
        var result = s.romanToInt("MCMXCIV");
        long endTime = System.currentTimeMillis();
        System.out.println("Result is: " + result + ". It took " + (endTime - startTime) + " milliseconds");
    }

    public int romanToInt(String s) {
        int sum = 0;
        int current = 0;
        int previous = 0;
        for (int i = s.length()-1; i >= 0 ; i--) {
            current = romanInteger.get(s.charAt(i));
            if (previous > current) sum -= current;
            else {
                sum += current;
                previous = current;
            }
        }
        return sum;
    }
}
// @lc code=end