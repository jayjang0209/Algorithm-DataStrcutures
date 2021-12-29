package Math.P412;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode P412. Fizz Buzz
 *
 * @author Jonghoon Jang
 * @version Dec, 2021
 */
public final class FizzBuzz {

    private FizzBuzz() {
    }

    /**
     * Returns a string array
     * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
     * answer[i] == "Fizz" if i is divisible by 3.
     * answer[i] == "Buzz" if i is divisible by 5.
     * answer[i] == i (as a string) if none of the above conditions are true.
     *
     * @param n an integer
     * @return string array as a List
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public static List<String> fizzBuzz(final int n) {
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                answer.add("FizzBuzz");
            } else if (i % 3 == 0) {
                answer.add("Fizz");
            } else if (i % 5 == 0) {
                answer.add("Buzz");
            } else {
                answer.add(String.valueOf(i));
            }
        }
        return answer;
    }
}
