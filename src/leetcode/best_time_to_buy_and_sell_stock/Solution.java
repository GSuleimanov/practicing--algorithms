package leetcode.best_time_to_buy_and_sell_stock;

/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {

    public static void main(String[] args) {
        int[] arr1 = new int[] {7,1,5,3,6,4,5};
        int[] arr2 = new int[] {1,2};
        var s = new Solution();
        System.out.println(s.maxProfit(arr2));
    }

    public int maxProfit(int[] prices) {
        int newProfit, profit = 0, maxStock = prices[prices.length - 1];
        for (int i = prices.length - 1; i >= 0; i--) {
            if (maxStock < prices[i]) maxStock = prices[i];
            else if ((newProfit = maxStock - prices[i]) > profit) profit = newProfit;
        }
        return profit;
    }
}

// @lc code=end
