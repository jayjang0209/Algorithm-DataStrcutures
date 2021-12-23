package sorting_searching.P88;

import java.util.Arrays;

/**
 * LeetCode P88. Merge Sorted Array.
 *
 * @author Jonghoon Jang
 * @version Dec, 2021
 */
public class MergeSortedArray {

    public MergeSortedArray() {
    }

    /**
     * Merge nums1 and nums2 into a single array sorted in non-decreasing order and
     * merged numbers will be stored inside the nums1 array.
     *
     * @param nums1 a array of integers
     * @param m the number of integers in the array
     * @param nums2 a array of integers
     * @param n the number of integers in the array
     */
    public static void merge(final int[] nums1, final int m, final int[] nums2, final int n) {
        int pointerInFirstArray = m - 1;
        int pointerInSecondArray = n - 1;
        int index = m + n - 1;
        while (pointerInSecondArray >= 0 && pointerInFirstArray >= 0) {
            if (nums1[pointerInFirstArray] < nums2[pointerInSecondArray]) {
                nums1[index--] = nums2[pointerInSecondArray--];
            } else {
                nums1[index--] = nums1[pointerInFirstArray--];
            }
        }

        while (pointerInSecondArray >= 0) {
            nums1[index--] = nums2[pointerInSecondArray--];
        }
    }

    public static void main(final String[] args) {
        int[] firstArray = {1, 5, 6, 0, 0, 0, 0}; // fixed size.
        int[] secondArray = {2, 3, 6, 8};

        merge(firstArray, firstArray.length - secondArray.length, secondArray, secondArray.length);
        System.out.println(Arrays.toString(firstArray));
    }
}
