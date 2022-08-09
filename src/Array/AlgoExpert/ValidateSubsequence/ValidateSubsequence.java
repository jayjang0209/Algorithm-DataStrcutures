package Array.AlgoExpert.ValidateSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidateSubsequence {

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


    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10));
        ArrayList<Integer> sequence = new ArrayList<Integer>(Arrays.asList(22, 25, 6));
        System.out.println(isValidSubsequence(array, sequence));
    }
}
