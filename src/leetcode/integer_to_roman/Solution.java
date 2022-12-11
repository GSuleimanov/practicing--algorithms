package leetcode.integer_to_roman;

import java.util.HashMap;

/*
 * @lc app=leetcode id=12 lang=java
 *
 * [12] Integer to Roman
 */

// @lc code=start
class Solution {
    int[] integers = new int[] {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    static HashMap<Integer, String>  romans = new HashMap<>();;

    static {
        romans.put(1000,"M");
        romans.put(900,"CM");
        romans.put(500,"D");
        romans.put(400,"CD");
        romans.put(100,"C");
        romans.put(90,"XC");
        romans.put(50,"L");
        romans.put(40,"XL");
        romans.put(10,"X");
        romans.put(9,"IX");
        romans.put(5,"V");
        romans.put(4,"IV");
        romans.put(1,"I");
    }

    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.intToRoman(517));
    }

    public int getClosest(int value) {
        for (int integer : integers) if (integer <= value) return integer;
        return 0;
    }

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int toRoman = num;
        while (toRoman > 0) {
            int closest = getClosest(toRoman);
            result.append(romans.get(closest));
            toRoman -= closest;
        }
        return result.toString();
    }
}
// @lc code=end
