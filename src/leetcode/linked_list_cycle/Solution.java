package linked_list_cycle;
/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
 */

import java.util.HashSet;

// @lc code=start
public class Solution {
    public boolean hasCycle(ListNode head) {
        var uniqs = new HashSet<ListNode>();
        while (head != null)
            if (!uniqs.add(head)) return true;
            else head = head.next;
        return false;
    }
}
// @lc code=end
