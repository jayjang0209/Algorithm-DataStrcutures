package Array.AlgoExpert.TwoNumberSum;

import java.util.Arrays;

public class TwoNumberSum {
    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        int n = array.length;
        Arrays.sort(array);

        if (array.length == 0) {
            return new int[0];
        }

        int[] ans = new int[2];
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                System.out.println(i + "with" + j);
                if (array[i] + array[j] == targetSum) {
                    ans[0] = array[i];
                    ans[1] = array[j];
                    return ans;
                }

            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 5, -4, 8, 11, 1, -1, 6};
        int targetSum = 10;
        System.out.println(Arrays.toString(twoNumberSum(array, targetSum)));
    }
}

