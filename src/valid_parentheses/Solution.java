package valid_parentheses;

import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.IntStream;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    private static int[] opening = new int[] {40,91,123};
    private static int[] closing = new int[] {41,93,125};
    LinkedList<Integer> linkedList = new LinkedList<>();

    public boolean isValid(final String s) {
        s.chars().forEach(this::addOrDelete);
        return linkedList.isEmpty();
    }

    private void addOrDelete(int bracket) {
        Optional.ofNullable(linkedList.peekLast())
            .filter(l -> l.equals(opening[getIdxIfClosing(bracket)]))
            .ifPresentOrElse(x -> linkedList.removeLast(), () -> linkedList.add(bracket));
    }

    private int getIdxIfClosing(int bracket) {
        return IntStream.range(0, closing.length)
                .filter(i -> closing[i] == bracket).findAny().orElse(-1);
    }
}
// @lc code=end
