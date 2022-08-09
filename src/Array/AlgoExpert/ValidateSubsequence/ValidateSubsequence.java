package Array.AlgoExpert.ValidateSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidateSubsequence {

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {

        if (array.size() == 1 && sequence.contains(array.get(0))) {
            return true;
        }

        List<Integer> TempSequence = sequence;

        for (int i = 0; i < array.size(); i++) {
            if (TempSequence.size() == 0) {
                break;
            }

            if(array.get(i) == TempSequence.get(0)) {
                TempSequence.remove(0);
            }
        }

        if (TempSequence.size() == 0) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10));
        ArrayList<Integer> sequence = new ArrayList<Integer>(Arrays.asList(22, 25, 6));
        System.out.println(isValidSubsequence(array, sequence));
    }
}
