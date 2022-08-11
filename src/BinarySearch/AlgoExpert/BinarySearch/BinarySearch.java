package BinarySearch.AlgoExpert.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        if (array.length == 0) {
            return -1;
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target ) {
                return mid;
            } else if (target < array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 21, 33, 45, 45, 61, 72, 73};
        int target = 33;
        System.out.println(binarySearch(array, target));
    }


}
