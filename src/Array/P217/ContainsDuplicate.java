package Array.P217;

import java.util.HashSet;

/**
 * LeetCode P206. Reverse Linked List.
 *
 * @author Jonghoon Jang
 * @version Dec, 2021
 */
public class ContainsDuplicate {

    /**
     * Given an integer array nums, return true
     * if any value appears at least twice in the array,
     * and return false if every element is distinct.
     *
     * @param nums an array of int
     * @return true if any value appears at least twice in the array,
     * and return false if every element is distinct
     *
     * Time complexity: O(N), memory: O(N)
     *
     */
    public boolean containsDuplicate(final int[] nums) {
        HashSet<Integer> numberMap = new HashSet<>();
        for (int number: nums) {
            if (numberMap.contains(number)) return true;
            else numberMap.add(number);
        }
        return false;
    }
}
