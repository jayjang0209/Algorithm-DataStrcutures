package Array.AlgoExpert.ValidateSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * AlgoExpert Validate Subsequence.
 *
 * https://www.algoexpert.io/questions/validate-subsequence
 * @author Jay Jang
 * @version Aug, 2022
 */
public final class ValidateSubsequence {

    private ValidateSubsequence() {
    }

    /**
     * Given two non-empty arrays of integers, write a function that determines whether
     * the second array is a subsequence of the first one.
     *
     * Sample
     * array = [5, 1, 22, 25, 6, -1, 8, 10]
     * sequence = [1, 6, -1, 10]
     *
     * @param array an array
     * @param sequence an array
     * @return true if the second array is a subsequence of the first one, otherwise return false.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public static boolean isValidSubsequence(final List<Integer> array, final List<Integer> sequence) {

        if (array.size() == 1 && sequence.contains(array.get(0))) {
            return true;
        }

        for (int i = 0; i < array.size(); i++) {
            if (sequence.size() == 0) {
                break;
            }

            if (array.get(i) == sequence.get(0)) {
                sequence.remove(0);
            }
        }

        return sequence.size() == 0;
    }


    public static void main(final String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10));
        ArrayList<Integer> sequence = new ArrayList<Integer>(Arrays.asList(22, 25, 6));
        System.out.println(isValidSubsequence(array, sequence));
    }
}
